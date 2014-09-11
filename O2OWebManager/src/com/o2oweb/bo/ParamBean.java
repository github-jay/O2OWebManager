package com.o2oweb.bo;

public class ParamBean
{
  private Integer start =0;
  private Integer limit = 15;
  private String sort;
  private String dir;

  public Integer getStart()
  {
    return this.start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getLimit() {
    return this.limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public String getSort()
  {
    return this.sort;
  }

  public void setSort(String sort)
  {
    this.sort = sort;
  }

  public String getDir()
  {
    return this.dir;
  }

  public void setDir(String dir)
  {
    this.dir = dir;
  }
}