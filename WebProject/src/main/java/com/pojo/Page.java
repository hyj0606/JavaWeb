package com.pojo;

import java.util.List;

/**
 * @ClassName Page
 * @Description 分页实体类
 * @Author hyj98
 * @Date 2022-10-05 19:50
 * @Version 1.0
 */

public class Page {

    //集合.
    private List list;

    //当前页码. 每页条数. 总记录数. 总页数.
    private int pageNo;
    private int pageSize;
    private int totalCount;
    private int totalPage;

    //查询地址 , 查询的条件
    private String url;
    private String condition;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {

        if (pageNo < 1){
            this.pageNo = 1;
        }else if (pageNo > this.totalPage){
            this.pageNo = this.totalPage;
        }else {
            this.pageNo = pageNo;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {

        //记录总条数:
        this.totalCount = totalCount;

        //计算总页数:
        if(totalCount == 0){
            this.totalCount = 1;
        }else {
            this.totalPage = this.totalCount % this.pageSize == 0 ? (this.totalCount/this.pageSize) : ((this.totalCount/this.pageSize)+1);
        }

    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
