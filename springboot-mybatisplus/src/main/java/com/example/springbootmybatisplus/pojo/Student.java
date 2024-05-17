package com.example.springbootmybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author CJW
 * @since 2023-03-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Student对象", description="学生")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户年龄")
    private Integer userAge;

    @ApiModelProperty(value = "用户地址")
    private String userAddress;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "插入时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
