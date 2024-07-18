package com.example.demo.Config;

/**
 * 返回值常量
 *
 * @author yansiyang
 * @version V1.0
 * @date 2019-04-10 10:37:46
 */
public class HttpCode {
    public static final String NAME = "code";
    public static final String MESSAGE = "msg";
    /**
     * 请求成功
     */
    public static final int SUCCESS = 40000;
    /**
     * 身份认证失败
     */
    public static final int AUTHENTICATION_FAILURE = 40001;
    /**
     * 授权有问题
     */
    public static final int LICENSE_ERROR = 41111;
    /**
     * 在别的地方登录
     */
    public static final int LOGIN_IN_OTHER_POSITION = 40111;
    /**
     * 内部服务器错误
     */
    public static final int INTERNAL_SERVER_ERROR = 40002;
    /**
     * 服务不可用
     */
    public static final int SERVICE_UNAVAILABLE = 40003;
    /**
     * 用户被锁定
     */
    public static final int USER_LOCK = 40011;

    /**
     * 用户首次登录 重置密码 密码过期 都需要修改密码
     */
    public static final int NEED_MODIFY_PASSWORD = 40012;

    /**
     * 审计日志被删除 或 添加
     * 可同步 将备份的日志复原到日志表 或 删除多余的日志
     */
    public static final int AUDIT_LOG_EDITED = 40120;

    /**
     * 审计日志被删除 或 添加
     * 可同步 将备份的日志复原到日志表 或 删除多余的日志
     */
    public static final int AUDIT_LOG_BACKUP_EDITED = 40121;

    /**
     * 日志被篡改 且 无法复原
     */
    public static final int AUDIT_LOG_UNKNOWN = 40110;

    /**
     * 文件事件监听错误
     */
    public static final int FILE_EVENT_LISTENER_ERROR = 40122;

    /**
     * SM4密钥异常
     */
    public static final int SM4_KEY_EXCEPTION = 41114;

    /**
     * 所里单点登录
     */
    public static final int SSO_TARGET_APP = 40333;
}
