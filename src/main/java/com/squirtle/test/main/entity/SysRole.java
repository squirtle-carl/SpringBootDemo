package com.squirtle.test.main.entity;

import lombok.Data;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统角色
 * @date 2024/12/05
 */
@Data
public class SysRole {
    private String id;

    private String name;

    private String description;

    private String type;

    private String createTime;
}
