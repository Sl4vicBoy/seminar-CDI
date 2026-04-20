package controller;

import event.PaymentEvent;
import qualifier.CreditCard;
import qualifier.PayPal;
import service.PaymentService;

import jakarta.inject.Inject;
import jakarta.enterprise.event.Event;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/pay")
public class PaymentServlet extends HttpServlet {

    @Inject @CreditCard
    private PaymentService cardService;

    @Inject @PayPal
    private PaymentService paypalService;

    @Inject
    private Event<PaymentEvent> event;

    @Inject
    private LocalDateTime time;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String type = req.getParameter("type");
        double amount = Double.parseDouble(req.getParameter("amount"));

        boolean isPaypal = "paypal".equalsIgnoreCase(type);

        String result = isPaypal
                ? paypalService.pay(amount)
                : cardService.pay(amount);

        event.fire(new PaymentEvent(amount));

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("""
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <title>Payment Result</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>
        <body class="bg-light">

        <div class="container d-flex justify-content-center align-items-center vh-100">
            <div class="card shadow-lg p-4 w-50">

                <div class="text-center mb-3">
                    <h2 class="text-success">Payment Successful</h2>
                    <p class="text-muted">CDI Demo Result Page</p>
                </div>

                <div class="alert alert-info">
                    <b>Method:</b> %s
                </div>

                <ul class="list-group mb-3">
                    <li class="list-group-item"><b>Result:</b> %s</li>
                    <li class="list-group-item"><b>Amount:</b> %.2f PLN</li>
                    <li class="list-group-item"><b>Time:</b> %s</li>
                </ul>

                <a class="btn btn-primary w-100" href="/seminar2_war_exploded/">
                    ← Back to Home
                </a>

            </div>
        </div>

        </body>
        </html>
        """.formatted(type, result, amount, time));
    }
}