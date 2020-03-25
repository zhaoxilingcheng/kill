package top.lostmylife.kill.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zl
 * @date 2020/3/25
 * @copyright www.lostmylife.top Inc. All rights reserved.
 * @since
 */
@Setter
@Getter
public class Result<T extends BaseEntity> extends BaseEntity {

    private String code = "200";

    private String msg = "success";

    private T data;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result<?> error() {
        return new Result<>("500", "哇，开发小哥哥又有事情做了哦");
    }

    public static Result<?> ok() {
        return new Result<>("200", "如果今天是雨天，那么今天风调雨顺；如果今天是晴天，那可真是风和日丽。");
    }

    public static Result<?> ok(BaseEntity data) {
        return new Result<>(data);
    }

}
