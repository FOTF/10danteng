package space.fotf.danteng.services.controllers.info.main;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import space.fotf.danteng.services.controllers.component.PropComponent;
import space.fotf.operation.process.entity.PageEntity;
import space.fotf.operation.process.manager.info.TakeInfoManager;

@Controller
@RequestMapping("/info")
public class InfoController {
    
    private static final Logger log = LoggerFactory.getLogger(InfoController.class);
    
    @Resource
    private TakeInfoManager takeInfoManager;
    @Resource
    private PropComponent propComponent;
    
    @RequestMapping(value = "/getMainInfo", method = RequestMethod.GET)
    @ResponseBody
    public PageEntity getMainInfo(){
        log.info("获取主页面内容。");
        PageEntity pageEntity = takeInfoManager.getPageInfo(propComponent.getMainUrl());
        log.info("主页面内容。{}", pageEntity);
        return pageEntity;
    }
    
    @RequestMapping(value = "/getInfoUrl", method = RequestMethod.GET)
    @ResponseBody
    public PageEntity getInfoUrl(@RequestParam String url){
        log.info("获取{}页面内容。", url);
        PageEntity pageEntity = takeInfoManager.getPageInfo(propComponent.getMainUrl() + url);
        log.info("{}页面内容。{}", url, pageEntity);
        return pageEntity;
    }
}
