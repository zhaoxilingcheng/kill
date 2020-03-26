package top.lostmylife.kill.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lostmylife.kill.annotation.RateLimiterAop;
import top.lostmylife.kill.common.entity.Result;
import top.lostmylife.kill.entity.UserEntity;
import top.lostmylife.kill.service.ISecKillService;

import java.util.Arrays;


/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@RestController
@RequestMapping("sec-kill")
public class SecKillController {

    @Autowired
    private ISecKillService secKillService;

    /**
     * 假定get秒杀
     * 前提: 登录
     * 秒杀
     */
    @RateLimiterAop(value = "10004", capacity=2, key = "#userId") //限速为每秒2次
    @GetMapping("/kill/{id}")
    public Result<?> get(@PathVariable("id") Long id, Long userId) {
        UserEntity user = secKillService.getById(id);
        return Result.ok(user);
    }

}
