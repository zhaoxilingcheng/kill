package top.lostmylife.kill.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lostmylife.kill.common.Result;
import top.lostmylife.kill.entity.UserEntity;
import top.lostmylife.kill.service.IUserService;

import java.util.Arrays;


/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 信息
     */
    @GetMapping("/{id}")
    public Result<?> get(@PathVariable("id") Integer id) {
        UserEntity user = userService.getById(id);
        return Result.ok(user);
    }

    /**
     * 保存
     */
    @PostMapping
    public Result<?> save(@RequestBody UserEntity User) {
        userService.save(User);
        return Result.ok(User);
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<?> update(@RequestBody UserEntity User) {
        userService.updateById(User);
        return Result.ok(User);
    }

    /**
     * 删除
     */
    @DeleteMapping
    public Result<?> delete(@RequestBody Integer[] ids) {
        userService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
