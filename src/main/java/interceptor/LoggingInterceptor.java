package interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggingInterceptor {

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        System.out.println("Before: " + ctx.getMethod().getName());
        Object result = ctx.proceed();
        System.out.println("After: " + ctx.getMethod().getName());
        return result;
    }
}