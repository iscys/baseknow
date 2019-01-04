package com.baseknow.utils;

/**
 * <br/>类名: Pager
 * <br/>作用: 页码计算
*/

public  class Page {

    private int pageSize;		//每页条数10条
    private int startIndex;			//每页开始的索引
    private int totalPage;			//总页数
    private int totalRecords;		//总条数
    private int pageNum;			//当前页

    /**
     * @param pageNum 当前页码
     * @param totalRecords 总记录条数
     * @param pageSize 每页要显示的条数
     */
    public Page(int pageNum , int totalRecords,int pageSize){
        this.pageNum = pageNum;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        totalPage = (totalRecords%pageSize==0)?totalRecords/pageSize:totalRecords/pageSize+1;

        if(this.pageNum>totalPage){
            this.pageNum=totalPage;
        }
        if(this.pageNum<1){
            this.pageNum=1;
        }
        startIndex = (this.pageNum-1)*pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getPageNum() {
        return pageNum;
    }

}

