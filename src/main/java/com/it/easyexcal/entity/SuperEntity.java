package com.it.easyexcal.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体父类
 *
 * @author xiaobai
 */
@Setter
@Getter
public class SuperEntity<T extends Model<?>> extends Model<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", hidden = true)
    @TableField(exist = false)
    private Long id;

    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "uuid")
    private String dataUuid;

    @ApiModelProperty(value = "备注")
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Date updateTime;

    @TableLogic
    @TableField(select = false)
    @ApiModelProperty(value = "删除标识", hidden = true)
    private Boolean deletedFlag;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}


