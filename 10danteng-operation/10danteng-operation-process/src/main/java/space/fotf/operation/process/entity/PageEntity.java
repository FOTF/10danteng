package space.fotf.operation.process.entity;

import java.util.List;

/**
 * 获取的信息的转换类
 * 
 * @author 宗祥
 *
 */
public class PageEntity {

    /**
     * 前一页url
     */
    private String prevUrl;

    /**
     * 当前页url
     */
    private String index;

    /**
     * 后一页url
     */
    private String nextUrl;

    /**
     * 详细内容
     */
    private List<InfoDetailEntity> datas;

    public String getPrevUrl() {
        return prevUrl;
    }

    public void setPrevUrl(String prevUrl) {
        this.prevUrl = prevUrl;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public List<InfoDetailEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<InfoDetailEntity> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "PageEntity [prevUrl=" + prevUrl + ", index=" + index + ", nextUrl=" + nextUrl + ", datas=" + datas
                + "]";
    }
}
