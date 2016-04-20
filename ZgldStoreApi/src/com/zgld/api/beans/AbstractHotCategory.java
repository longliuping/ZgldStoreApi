package com.zgld.api.beans;

import java.io.Serializable;

public abstract class AbstractHotCategory
  implements Serializable
{
  private Integer hotid;
  private String hotname;
  private String hotimg;

  public AbstractHotCategory()
  {
  }

  public AbstractHotCategory(String hotname, String hotimg)
  {
    this.hotname = hotname;
    this.hotimg = hotimg;
  }

  public Integer getHotid()
  {
    return this.hotid;
  }

  public void setHotid(Integer hotid) {
    this.hotid = hotid;
  }

  public String getHotname() {
    return this.hotname;
  }

  public void setHotname(String hotname) {
    this.hotname = hotname;
  }

  public String getHotimg() {
    return this.hotimg;
  }

  public void setHotimg(String hotimg) {
    this.hotimg = hotimg;
  }
}