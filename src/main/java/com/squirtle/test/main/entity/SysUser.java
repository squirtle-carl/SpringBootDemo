package com.squirtle.test.main.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统用户信息表
 * @date 2024/07/15
 */
@Data
@TableName("sys_user")
public class SysUser {
    @TableId
    @Schema(title = "userId", description = "主键id",allowableValues="李白,杜甫")
    private String id;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("phone")
    private String phone;

    @TableField("user_name")
    private String userName;

    @TableField("status")
    private String status;

    @TableField("create_time")
    private Date createTime;

    private double age;
}
