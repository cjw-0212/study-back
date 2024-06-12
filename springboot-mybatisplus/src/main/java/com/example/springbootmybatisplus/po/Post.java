package com.example.springbootmybatisplus.po;

import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author CJW
 * @since 2024-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Post对象", description="")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer postId;

    private String postSubject;

    private Integer authorId;

    private Integer draftStatus;

    private String postContent;

    private Integer blogId;


}
