package com.example.springbootmybatisplus.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Author对象", description="")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "author_id", type = IdType.AUTO)
    private Integer authorId;

    private String authorUsername;

    private String authorPassword;

    private String authorEmail;

    private String authorBio;

    private String authorFavouriteSection;


}
