package com.aresoft.manager.model;

public class SysUser {
  private String id;
  private String name;
  private String nick_name;
  private String pwd;
  private String state;
  private java.sql.Date ct_date;
  private java.sql.Date up_date;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNick_name() {
    return nick_name;
  }

  public void setNick_name(String nick_name) {
    this.nick_name = nick_name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public java.sql.Date getCt_date() {
    return ct_date;
  }

  public void setCt_date(java.sql.Date ct_date) {
    this.ct_date = ct_date;
  }

  public java.sql.Date getUp_date() {
    return up_date;
  }

  public void setUp_date(java.sql.Date up_date) {
    this.up_date = up_date;
  }
}
