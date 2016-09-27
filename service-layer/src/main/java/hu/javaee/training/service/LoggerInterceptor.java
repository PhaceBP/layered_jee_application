package hu.javaee.training.service;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class LoggerInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) {
		try {

			Method invokedMethod = ctx.getMethod();

			System.out.println("Invoced business method: " + invokedMethod.getName());
			for (Parameter p : invokedMethod.getParameters()) {
				System.out.println("Parameter name: " + p.getName());
				System.out.println("Parameter type: " + p.getType().getName());
			}
			return ctx.proceed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
