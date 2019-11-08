package com.ycm.work5.bean;

public class MyResponse {
    //{
    //  "status": 0,
    //  "msg": "登录成功",
    //  "data": {
    //    "member_id": 34,
    //    "uname": "123",
    //    "password": "ICy5YqxZB1uWSwcVLSNLcA==",
    //    "email": "test123@qq.com",
    //    "sex": 0,
    //    "mobile": "",
    //    "regtime": 1479861190000,
    //    "lastlogin": null,
    //    "image": "",
    //    "memberAddresses": null
    //  }
    //}

    private int status;
    private String msg;
    private MyDate data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyDate getData() {
        return data;
    }

    public void setData(MyDate data) {
        this.data = data;
    }

}
