package com.squirtle.test.main.api;

import com.squirtle.test.main.commons.response.UserInfo;
import com.squirtle.test.main.entity.SysUser;
import com.squirtle.test.main.service.ISysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//包含了@Controller和@RequestBody
@RequestMapping("/openRest/sysUser")
@Slf4j
@Tag(name = "系统用户")
public class OpenSysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @Operation(summary = "根据id查询用户")
    @GetMapping("/selectUserById")
    public UserInfo selectUserById(@RequestParam("id") String id) {
        log.info("selectUserById:{}",id);
        return sysUserService.selectUserById(id);
    }
}
