package org.example.springbootweb.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MysqlGenerator {
  public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/spring-boot-web?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
  public static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
  public static final String DATABASE_USERNAME = "root";
  public static final String DATABASE_PASSWORD = "";
  public static final String OUT_PUT_PATH = "/spring-boot-web/src/main/java/templates/mapper.xml";
  public static String XML_PATH = "/templates/mapper.xml";
  public static String AUTHOR= "ted";
  public static String PARENT_PACKAGE = "org.example.springbootweb";
  public static final String[] SUPER_ENTITY_COLUMNS = new String[]{"id", "create_time", "update_time", "creator", "modifier"};

  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入" + tip + "：");
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) {
    FastAutoGenerator.create(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)
        // 全局配置
        .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).outputDir(String.valueOf(Paths.get(System.getProperty("user.dir"), "src", "main", "java"))))
        // 包配置
        .packageConfig((scanner, builder) -> builder.parent("org.example.springbootweb"))
        // 策略配
        .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
            .entityBuilder()
            .enableLombok()
            .addTableFills(
                new Column("creator", FieldFill.INSERT),
                new Column("create_time", FieldFill.INSERT),
                new Column("modifier", FieldFill.UPDATE),
                new Column("update_time", FieldFill.UPDATE)
            )
            .build())
        // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .templateEngine(new FreemarkerTemplateEngine())
        .execute();
  }

  // 处理 all 情况
  protected static List<String> getTables(String tables) {
    return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
  }
}
