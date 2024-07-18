package com.example.demo.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * Rest返回数据对象
 *
 * @author yansiyang
 * @version V1.0
 * @date 2019/4/2 15:30
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码描述
     * 参考
     */
    public R() {
        put("code", HttpCode.SUCCESS);
        put("msg", "操作成功！");
    }

    public static R error() {
        return error(HttpCode.INTERNAL_SERVER_ERROR, "请求失败！");
    }

    public static R errorWithCode(int code, String error) {
        return error(code, error);
    }

    public static R errorWithException(String exception) {
        return errorWithException(HttpCode.INTERNAL_SERVER_ERROR, "请求失败！", exception);
    }

    public static R errorWithException(String msg, String exception) {
        return errorWithException(HttpCode.INTERNAL_SERVER_ERROR, msg, exception);
    }

    public static R error(String msg) {
        return error(HttpCode.INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R errorWithException(int code, String msg, String exception) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("exception", exception);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}