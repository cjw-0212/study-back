package com.example.springsecurity.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
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
        gc.setFileOverride(false);
        //获取项目路径
        String projectPath = System.getProperty("user.dir");
        //代码生成的目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置作者
        gc.setAuthor("CJW");
        //生成完毕是否打开资源管理器
        gc.setOpen(false);
        //实体属性swagger2注解
        gc.setSwagger2(false);
        //去掉IService的I前缀
        gc.setServiceName("%sService");
        //mapper.xml 生成ResultMapper
        gc.setBaseResultMap(true);
        //mapper.xml 生成全属性集合
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=UTF-8&" +
                "serverTimezone=Asia/Shanghai");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("CJW3117132432");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //设置生成包的父路径
        pc.setParent("com.example.springsecurity");
        //设置生成实体类的包名
        pc.setEntity("pojo");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 不生成mapper.xml文件
        /*focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });*/
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

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
        strategy.setLogicDeleteFieldName("is_deleted");
        //设置自动注入字段
        TableFill insertFill = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateFill = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        List<TableFill> list = new ArrayList<>();
        list.add(insertFill);
        list.add(updateFill);
        strategy.setTableFillList(list);
        //设置乐观锁字段
        //strategy.setVersionFieldName("version");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //忽略表名前缀
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        //设置使用freemark模板生成
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        //执行
        mpg.execute();
    }
}
