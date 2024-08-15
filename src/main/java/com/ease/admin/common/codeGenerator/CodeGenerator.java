package com.ease.admin.common.codeGenerator;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.ease.admin.common.bean.entity.BaseEntity;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;

/**
 * 代码生成器
 */
public class CodeGenerator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("参数错误 , 请设置ip , password , author 三个参数");
            return;
        }
        String root = System.getProperty("user.dir").replace("\\", "\\\\");
        final String outputDir = root + "\\src\\main\\java";
        final String xmlOutputDir = root + "\\src\\main\\resources\\mapper";

        // 代码生成器
        FastAutoGenerator.create("jdbc:mysql://" + args[0] + ":3306/admin-ease", "root", args[1])
                .globalConfig(builder -> {
                    builder.author(args[2]) // 设置作者
                            .outputDir(outputDir); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> {
                    builder.parent("com.ease") // 设置父包名
                            .moduleName("admin") // 设置父包模块名
                            .entity("bean.entity")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(Arrays.asList("user" , "role" , "route" , "permission" , "token" , "user_role" , "role_route" , "route_permission" , "super_admin")); // 设置需要生成的表名

                    //实体类策略
                    builder.entityBuilder()
                            .addSuperEntityColumns("id", "create_time", "update_time", "creator", "updater", "deleted") // 设置忽略字段
                            .superClass(BaseEntity.class) // 设置父类
                            .enableLombok()
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .enableChainModel()
                            .enableTableFieldAnnotation();

                    // Mapper 策略
                    builder.mapperBuilder()
                            .enableBaseResultMap();

                    // Service 策略
                    builder.serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl");

                    //Controller策略
                    builder.controllerBuilder()
                            .enableHyphenStyle()
                            .enableRestStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
