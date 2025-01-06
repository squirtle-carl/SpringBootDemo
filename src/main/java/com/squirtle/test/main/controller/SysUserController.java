package com.squirtle.test.main.controller;

import com.squirtle.test.main.commons.response.UserInfo;
import com.squirtle.test.main.entity.SysUser;
import com.squirtle.test.main.service.ISysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统用户控制器
 * @date 2024/07/15
 */
@RestController//包含了@Controller和@RequestBody
@RequestMapping("/safeRest/sysUser")
@Slf4j
@Tag(name = "系统用户")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @Operation(summary = "根据id查询用户")
    @GetMapping("/selectUserById")
    public UserInfo selectUserById(@RequestParam("id") String id) {
        System.gc();
        return sysUserService.selectUserById(id);
    }
}
