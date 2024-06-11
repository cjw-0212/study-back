package com.example.springbootmybatisplus.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author CJW
 * @since 2023/9/19
 */
public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //不覆盖已有文件
        gc.setFileOverride(true);
        //获取项目路径
        String projectPath = System.getProperty("user.dir");
        //代码生成的目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置作者
        gc.setAuthor("CJW");
        //生成完毕是否打开资源管理器
        gc.setOpen(false);
        //实体属性swagger2注解
        gc.setSwagger2(true);
        //去掉IService的I前缀
        gc.setServiceName("%sService");
        //mapper.xml 生成ResultMapper
        gc.setBaseResultMap(true);
        //mapper.xml 生成全属性集合
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.255.132:3306/mybatis_test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //设置生成包的父路径
        pc.setParent("com.example.springbootmybatisplus");
        //设置生成实体类的包名
        pc.setEntity("po");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        TemplateConfig templateConfig = new TemplateConfig();
        //不配置xml文件生成模板
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        //如果模板引擎是 velocity
        //String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                //配置mapper.xml文件生成在resources目录
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置包名下划线转驼峰命名法
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //设置属性值下划线转驼峰命名法
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //使用lombok注解
        strategy.setEntityLombokModel(true);
        //给控制器加上@RestController注解
        strategy.setRestControllerStyle(true);
        //设置逻辑删除字段
        //strategy.setLogicDeleteFieldName("is_deleted");
        //设置自动注入字段
        TableFill insertFill = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateFill = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        List<TableFill> list = new ArrayList<>();
        list.add(insertFill);
        list.add(updateFill);
        strategy.setTableFillList(list);
        //设置乐观锁字段
        strategy.setVersionFieldName("version");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //忽略表名前缀
        //strategy.setTablePrefix("pms_");
        mpg.setStrategy(strategy);
        //设置使用freemark模板生成
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        //执行
        mpg.execute();
    }
}
