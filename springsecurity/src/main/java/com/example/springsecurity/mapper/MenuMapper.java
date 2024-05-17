package com.example.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity.pojo.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author CJW
 * @since 2023-10-27
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    @Select("SELECT\n" +
            "\tDISTINCT m.`perms`\n" +
            "FROM\n" +
            "\tuser_role ur\n" +
            "\tLEFT JOIN `role` r ON ur.`role_id` = r.`id`\n" +
            "\tLEFT JOIN `role_menu` rm ON ur.`role_id` = rm.`role_id`\n" +
            "\tLEFT JOIN `menu` m ON m.`id` = rm.`menu_id`\n" +
            "WHERE\n" +
            "\tuser_id = #{userId}\n" +
            "\tAND r.`status` = 0\n" +
            "\tAND m.`status` = 0")
    List<String> selectPermsByUserId(String userId);
}
