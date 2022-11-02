package com.pojo;

/**
 * @ClassName New
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-20 14:54
 * @Version 1.0
 */

public class New {
    private int id;             //主键
    private String title;       //标题
    private String content;     //内容
    private String createTime;  //创建时间

    public New() {
    }

    public New(int id, String title, String content, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
