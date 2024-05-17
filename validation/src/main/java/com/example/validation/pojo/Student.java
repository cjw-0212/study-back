package com.example.validation.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * @author CJW
 * @since 2023/11/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student {
    @NotEmpty(message = "学生姓名不能为空")
    private String name;
    @Range(min = 0, max = 20, message = "学生年龄必须在0-20")
    private Integer age;

}

