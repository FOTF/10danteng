package space.fotf.operation.process.entity;

/**
 * 页面内容信息
 */
public class InfoDetailEntity {

    /**
     * 序号
     */
    private int index;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 0是gif，其他不是
     */
    private int isGif;

    /**
     * 好评（蛋疼）
     */
    private int goodNum;

    /**
     * 差评（乳酸）
     */
    private int bedNum;

    /**
     * 无聊
     */
    private int boringNum;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getIsGif() {
        return isGif;
    }

    public void setIsGif(int isGif) {
        this.isGif = isGif;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public int getBoringNum() {
        return boringNum;
    }

    public void setBoringNum(int boringNum) {
        this.boringNum = boringNum;
    }

    @Override
    public String toString() {
        return "InfoDetailEntity [index=" + index + ", title=" + title + ", imgUrl=" + imgUrl + ", isGif=" + isGif
                + ", goodNum=" + goodNum + ", bedNum=" + bedNum + ", boringNum=" + boringNum + "]";
    }
}
