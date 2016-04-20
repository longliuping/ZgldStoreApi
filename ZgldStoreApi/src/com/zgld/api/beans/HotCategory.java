package com.zgld.api.beans;

import java.io.Serializable;

public class HotCategory extends AbstractHotCategory
  implements Serializable
{
  public HotCategory()
  {
  }

  public HotCategory(String hotname, String hotimg)
  {
    super(hotname, hotimg);
  }
}