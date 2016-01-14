package space.fotf.operation.process.manager.info;

import space.fotf.operation.process.entity.PageEntity;

/**
 * 获取蛋疼信息
 * @author 宗祥
 *
 */
public interface TakeInfoManager {
    
    public PageEntity getPageInfo(String pageUrl);

}
