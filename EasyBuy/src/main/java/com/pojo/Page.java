package com.pojo;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-12 16:55
 * @Version 1.0
 */

public class Page {

    //封装页面商品集合:
    private List results;

    //封装页面分页页码信息:
    private int pageNo; //当前页码
    private int pageSize; //当前每页条数
    private int totalCount; //总记录数
    private int totalPage; //总页数

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

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if ( pageNo < 1 ){
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
        this.totalCount = totalCount;

        //同时计算总页数:
        this.totalPage = this.totalCount % this.pageSize != 0 ? (this.totalCount / this.pageSize)+1 : this.totalCount / this.pageSize;

    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
