package com.example.springbootmybatisplus.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author CJW
 * @since 2024-06-12
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Student对象", description="学生表")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "乐观锁字段")
    @Version
    private Integer version;

    @ApiModelProperty(value = "插入时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
