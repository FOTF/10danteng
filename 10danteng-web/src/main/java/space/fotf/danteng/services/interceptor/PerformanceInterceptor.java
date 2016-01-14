package space.fotf.danteng.services.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class PerformanceInterceptor implements MethodInterceptor{
    
    @Autowired
    private HttpServletRequest request;
    
    private static final Logger log = LoggerFactory.getLogger("time");

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //请求地址
        String uri = request.getRequestURI();
        Object object = null;
        long startTime = System.currentTimeMillis();
        object = invocation.proceed();
        long endTime = System.currentTimeMillis();
        log.info("请求地址是：{}，请求花费时间是：{}", uri, (endTime - startTime));
        return object;
    }

}
