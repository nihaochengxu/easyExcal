package com.it.easyexcal.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 【会员模块】会员信息
 * </p>
 *
 * @author Brave
 * @since 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user")
@ApiModel(value="User对象", description="【会员模块】会员信息")
public class User extends SuperEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户名")
    private String clientId;

    @ApiModelProperty(value = "密码")
    private String clientPassword;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像图片地址")
    private String headUrl;

    @ApiModelProperty(value = "性别  0：未知 1：男  2：女")
    private String sex;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "个人描述")
    private String description;

    @ApiModelProperty(value = "上次登录时间")
    private Date lastLogin;

    @ApiModelProperty(value = "最后登录IP")
    private String lastIp;

    @ApiModelProperty(value = "最后登录设备ID")
    private String lastDevice;

    @ApiModelProperty(value = "用户类别：A-普通用户；B-管理员；C-第三方；D-商户；E-内测普通用户")
    private String category;

    @ApiModelProperty(value = "来源渠道 0：后台，10：小程序，20：app，30：线下，40：官网平台")
    private Boolean sourceType;

    @ApiModelProperty(value = "邀请码")
    private String invitationCode;

    @ApiModelProperty(value = "启用状态 0：禁用 1：启用")
    private Boolean state;

    @ApiModelProperty(value = "im导入标识：0：未导入 1：已导入")
    private Boolean imImportFlag;


}
