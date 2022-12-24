package com.it.easyexcal.utils;

/**
 * @Author WQC
 * @Date 2022/6/30 23:22
 * @Version 1.0
 */

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 异常枚举
 *
 * @author <a href="mailto:yaoonlyi@gmail.com">purgeyao</a>
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum {

    /**
     * 参数错误
     */
    BAD_REQUEST(400, "参数错误"),

    /**
     * 401 未登录
     */
    UNAUTHORIZED(401, "未授权，请先登录"),

    /**
     * 403 未授权
     */
    FORBIDDEN(403, "访问权限不足"),

    /**
     * 404 Web 服务器找不到您所请求的文件或脚本。请检查URL 以确保路径正确。
     */
    NOT_FOUND(404,
            String.format("哎呀，无法找到这个资源啦(%s)", HttpStatus.NOT_FOUND.getReasonPhrase())),

    /**
     * 405 对于请求所标识的资源，不允许使用请求行中所指定的方法。请确保为所请求的资源设置了正确的 MIME 类型。
     */
    METHOD_NOT_ALLOWED(405,
            String.format("请换个姿势操作试试(%s)", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase())),

    /**
     * 415 Unsupported Media Type
     */
    UNSUPPORTED_MEDIA_TYPE(415,
            String.format("呀，不支持该媒体类型(%s)", HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase())),

    /**
     * 系统异常 500 服务器的内部错误
     */
    EXCEPTION(500, "服务器开小差，请稍后再试"),

    /**
     * 系统限流
     */
    TRAFFIC_LIMITING(429, "哎呀，网络拥挤请稍后再试试"),

    /**
     * 业务异常
     */
    BUSINESS_ERROR(510, "业务异常"),

    /**
     * 非法请求
     */
    ILLEGAL_REQUEST(520, "非法请求"),

    /**
     * 服务调用异常
     */
    API_GATEWAY_ERROR(530, "网络繁忙，请稍后再试"),

    /**
     * rpc调用异常
     */
    RPC_ERROR(540, "呀，网络出问题啦！"),

    /**
     * 唯一索引异常
     */
    UNIQUE_ERROR(550, "该记录已存在！");

    private final Integer code;

    private final String message;

}
