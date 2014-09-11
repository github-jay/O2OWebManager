package com.o2oweb.common.dao.support;
/**
 * @author 作者姓名 king
 * @version 创建时间：Feb 25, 2013 10:47:11 AM
 * 类说明
 */
import java.util.ArrayList;
import java.util.List;

public class PageBean
{
  private static int DEFAULT_PAGE_SIZE = 24;

  private List list = new ArrayList();
  private int allRow;
  private int totalPage;
  private int currentPage;
  private int pageSize;
  private boolean isFirstPage;
  private boolean isLastPage;
  private boolean hasPreviousPage;
  private boolean hasNextPage;

  public PageBean()
  {
    this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
  }

  public PageBean(int allRow, int currentPage, int pageSize, List list) {
    this.allRow = allRow;
    this.pageSize = pageSize;
    this.currentPage = currentPage;
    this.totalPage = (allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1);

    if (this.currentPage > this.totalPage) {
      this.currentPage = this.totalPage;
    }
    this.list = list;
    init();
  }

  public List getList() {
    return this.list;
  }

  public void setList(List list) {
    this.list = list;
  }

  public int getAllRow() {
    return this.allRow;
  }

  public void setAllRow(int allRow) {
    this.allRow = allRow;
  }

  public int getTotalPage() {
    return this.totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getCurrentPage() {
    if (this.totalPage < this.currentPage) {
      this.currentPage = this.totalPage;
    }

    return this.currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public void init()
  {
    this.isFirstPage = isFirstPage();
    this.isLastPage = isLastPage();
    this.hasPreviousPage = isHasPreviousPage();
    this.hasNextPage = isHasNextPage();
  }

  public boolean isFirstPage()
  {
    return this.currentPage == 1;
  }

  public boolean isLastPage() {
    return this.currentPage == this.totalPage;
  }

  public boolean isHasPreviousPage() {
    return this.currentPage != 1;
  }

  public boolean isHasNextPage() {
    return this.currentPage != this.totalPage;
  }

  public static int countTotalPage(int pageSize, int allRow)
  {
    int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / 
      pageSize + 1;
    return totalPage;
  }

  public static int countOffset(int pageSize, int currentPage)
  {
    int page = currentPage;
    if (currentPage == 0) {
      page = 1;
    }
    int offset = pageSize * (page - 1);
    return offset;
  }

  public static int countCurrentPage(int page)
  {
    int curPage = page == 0 ? 1 : page;
    return curPage;
  }
}