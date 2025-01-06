package com.squirtle.test.main.commons.response;

import lombok.Data;
import lombok.Getter;

import java.io.*;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 用户信息
 * @date 2024/11/14
 */
@Data
public class UserInfo{

    private String id;

    private String account;

    private transient String password;

    private String phone;

    private String userName;

    private Boolean status;

    private String createTime;

    private double age;

    public UserInfo(){

    }
    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{userName='" + userName + "', password='" + password + "'}";
    }

}
