<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CDI Payment Demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">

    <div class="card shadow-lg p-4 w-50">

        <div class="text-center mb-4">
            <h1 class="h3">CDI Payment System</h1>
            <p class="text-muted">DI • CDI • Qualifiers • Events • Interceptors • Producers</p>
        </div>

        <form action="pay" method="get">

            <div class="mb-3">
                <label class="form-label">Amount (PLN)</label>
                <input type="number" name="amount" class="form-control" value="100" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Payment Method</label>
                <select name="type" class="form-select">
                    <option value="card">Credit Card</option>
                    <option value="paypal">PayPal</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary w-100">
                Pay Now
            </button>

        </form>

        <hr>

        <div class="d-grid gap-2">
            <a class="btn btn-outline-secondary" href="pay?type=card&amount=250">
                Quick Test: 250 PLN (Card)
            </a>
        </div>

    </div>

</div>

</body>
</html>