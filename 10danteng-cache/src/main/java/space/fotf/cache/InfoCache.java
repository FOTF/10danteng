package space.fotf.cache;

import java.util.HashMap;
import java.util.Map;

import space.fotf.operation.process.entity.PageEntity;

/**
 * 缓存信息，缓存到内存
 * @author 宗祥
 */
public class InfoCache {
    
    /**
     * 缓存信息
     */
    private static Map<String, PageEntity> cacheMap = new HashMap<String, PageEntity>();
    
    /**
     * 取出缓存信息
     * @param url
     * @return
     */
    public static PageEntity getCache(String url){
        return cacheMap.get(url);
    }
    
    /**
     * 信息保存到缓存中
     * @param entity
     */
    public static void addCache(String url, PageEntity entity){
        cacheMap.put(url, entity);
    }

}
