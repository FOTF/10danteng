package space.fotf.danteng.services.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.fotf.cache.InfoCache;
import space.fotf.operation.process.entity.PageEntity;

public class InfoCacheInterceptor implements MethodInterceptor{
    
    private static final Logger log = LoggerFactory.getLogger("cache");

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        boolean cacheFlag = false;
        String url = null;
        Object[] argums = invocation.getArguments();
        if(null == argums || argums.length == 0){
            //主页不进行缓存处理
            log.info("主页不进行缓存处理");
            cacheFlag = false;
        }else{
            url = (String) argums[0];
            if(StringUtils.isBlank(url) || StringUtils.equalsIgnoreCase(url, "null")){
                cacheFlag = false;
            }
        }
        
        if(cacheFlag){
            log.info("param = " + url);
            PageEntity entity = InfoCache.getCache(url);
            if(null != entity){
                log.info("缓存中有数据，直接返回。entity：{}" + entity);
                return entity;
            }
            Object pEntity = invocation.proceed();
            InfoCache.addCache(url, (PageEntity) pEntity);
            log.info("缓存中没有数据，访问添加到缓存。entity：{}" + pEntity);
            return pEntity;
        }
        return invocation.proceed();
    }

}
