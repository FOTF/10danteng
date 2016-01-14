package space.fotf.operation.process.manager.info.impl;

import space.fotf.operation.process.entity.PageEntity;
import space.fotf.operation.process.manager.info.TakeInfoManager;
import space.fotf.operation.process.utils.ProcessInfoUtils;

public class TakeInfoManagerImpl implements TakeInfoManager{

    public PageEntity getPageInfo(String pageUrl) {
        return ProcessInfoUtils.getWebContent(pageUrl);
    }
    
    

}
