package space.fotf.operation.process.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import space.fotf.operation.process.entity.InfoDetailEntity;
import space.fotf.operation.process.entity.PageEntity;

/**
 * 信息处理工具
 * @author 宗祥
 */
public class ProcessInfoUtils {
    /**
     * 查询标题和图片路径的正则
     */
    private static final String regTitleAndImageSrcStr = "<div class=\"entry rich-content\"><p>(.*?)<img src=\"(.*?)\">";
    
    /**
     * 查询前一页和后一页的正则
     */
    private static final String prexAndNextSrcStr = "<div class=\"qianhou\">(.*?)</div><div class=\"posts\">";
    
    /**
     * 获取页面内容
     * @param loadUrl
     * @return
     */
    public static PageEntity getWebContent(String loadUrl) {
        PageEntity pEntity = null;
        List<InfoDetailEntity> details = null;
        StringBuffer sb = new StringBuffer("");
        try {
            URL url = new URL(loadUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setConnectTimeout(6000);
            conn.connect();
            String temp;
            InputStream is = conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    is, "utf-8"));
            while ((temp = in.readLine()) != null) {
                sb.append("\n");
                sb.append(temp);
            }
            in.close();
            is.close();
        } catch (Exception ee) {

        }
        System.out.println(sb.toString());
        pEntity = new PageEntity();
        details = new ArrayList<InfoDetailEntity>();
        Pattern patternB = Pattern.compile(prexAndNextSrcStr);
        Matcher matcherB = patternB.matcher(sb);
        String prexDayUrl = null;
        String nextDayUrl = null;
        while(matcherB.find()){
            String str = matcherB.group();
            String prexSrc = str.substring(str.indexOf("<a "), str.lastIndexOf("<a "));
            prexDayUrl = getHref(prexSrc);
            String nextSrc = str.substring(str.lastIndexOf("<a "), str.lastIndexOf("</a>"));
            nextDayUrl = getHref(nextSrc);
        }
        
        pEntity.setPrevUrl(prexDayUrl);
        pEntity.setNextUrl(nextDayUrl);
        pEntity.setIndex(loadUrl);
        
        Pattern pattern = Pattern.compile(regTitleAndImageSrcStr);
        Matcher matcher = pattern.matcher(sb);
        InfoDetailEntity entity = null;
        while(matcher.find()){
            String str = matcher.group();
            String strTitle = str.substring(str.indexOf("<p>") + 3, str.indexOf("</p>"));
            String strImageSrc = str.substring(str.indexOf("http"), str.indexOf("\" alt="));
            entity = new InfoDetailEntity();
            entity.setTitle(strTitle);
            entity.setImgUrl(strImageSrc);
            details.add(entity);
        }
        pEntity.setDatas(details);
        return pEntity;
    }
    
    /**
     * 获取超链接信息
     * @param str
     * @return
     */
    private static String getHref(String str){
        if(str.contains("href")){
            return str.substring(str.indexOf("href=\"") + 6, str.lastIndexOf("\" style"));
        }
        return "";
    }
    
    public static void main(String[] args) {
        PageEntity entity = ProcessInfoUtils.getWebContent("http://www.10danteng.com/");
    }

}
