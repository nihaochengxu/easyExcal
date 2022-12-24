package com.it.easyexcal.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.it.easyexcal.entity.SuperEntity;

/**
 * MP代码生成器
 */
public class MpGenerator {

    public static void main(String[] args) {
        // 数据源
        String url = "jdbc:mysql://localhost:3306/xiaobaidb?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "root";

        // 通过表名生成相关类,多个用英文逗号隔开
        String tableNames = "t_user";
        // 去掉表名前缀
        String tablePrefix = "t_";
        // 自定义包名，后续的代码生成会在这个包下
        String packageName = "com.it.easyexcal";

        // 生成文件的输出目录 一般放在桌面,避免项目文件被覆盖
//        String projectPath = "C:\\Users\\JiHC\\Desktop\\MP";
        String projectPath = "D:\\project\\gen";

        new AutoGenerator()
                // 全局配置
                .setGlobalConfig(getGlobalConfig(projectPath))
                // 数据源配置
                .setDataSource(getDataSource(url, driverName, username, password))
                // 包配置
                .setPackageInfo(getPackageConfig(packageName))
                // 策略配置
                .setStrategy(getStrategyConfig(tableNames, tablePrefix))
                // 模板配置
                .setTemplate(getTemplateConfig())
                .execute();
    }

    /**
     * 全局配置
     *
     * @param projectPath 生成文件的输出目录
     */
    private static GlobalConfig getGlobalConfig(String projectPath) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath)// 生成文件的输出目录
                .setAuthor("Brave")// 作者
                .setOpen(true)// 是否打开输出目录 默认值:true
                .setFileOverride(true)// 是否覆蓋已有文件 默认值：false
                .setSwagger2(true)// 开启 swagger2 模式 默认false
                .setBaseColumnList(true)// 开启 baseColumnList 默认false
                .setBaseResultMap(true)// 开启 BaseResultMap 默认false
                .setIdType(IdType.ASSIGN_UUID)// 主键策略 ASSIGN_UUID:主键生成32位字符串ID
                .setDateType(DateType.ONLY_DATE)// 设置时间类型使用哪个包下的
//                .setEntityName("%s")// entity 命名方式 默认值：null 例如：%sEntity 生成 UserEntity
                /*.setMapperName("%sDAO")// dao 命名方式 默认值：null 例如：%sDao 生成 UserDao
                .setXmlName("%sMapper")// Mapper xml 命名方式   默认值：null 例如：%sDao 生成 UserDao.xml
                .setServiceName("%sService")// service 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
                .setServiceImplName("%sServiceImpl")// service impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
                .setControllerName("%sController")*/// controller 命名方式    默认值：null 例如：%sAction 生成 UserAction
        ;
        return gc;
    }

    /**
     * 数据源配置
     */
    private static DataSourceConfig getDataSource(String url, String driverName, String username, String password) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        return dsc;
    }

    /**
     * 包配置
     *
     * @param packageName 自定义包名，后续的代码生成会在这个包下
     */
    private static PackageConfig getPackageConfig(String packageName) {
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName)
                .setController("controller")
                .setService("service")
                .setMapper("mapper")
                .setEntity("entity");
        return pc;
    }

    /**
     * 策略配置
     *
     * @param tableNames 需要生成的表名
     */
    private static StrategyConfig getStrategyConfig(String tableNames, String tablePrefix) {
        // 策略配置	数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        StrategyConfig strategy = new StrategyConfig();
        //驼峰命名
        strategy.setCapitalMode(false)
                //表名生成策略(下划线转驼峰)
                .setNaming(NamingStrategy.underline_to_camel)
                //列名生成策略(下划线转驼峰)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //【实体】是否为lombok模型（默认 false）
                .setEntityLombokModel(true)
                //生成 @RestController 控制器
                .setRestControllerStyle(true)
                //通过表名生成相关类
                .setInclude((tableNames).split(","))
                //去掉表的前缀
                .setTablePrefix(tablePrefix)
                //驼峰转连字符
                .setControllerMappingHyphenStyle(true);

        //自定义继承的类全称，带包名
//        strategy.setSuperControllerClass("com.common.BaseController");
//        strategy.setSuperServiceClass((String) null);
//        strategy.setSuperServiceImplClass((String) null);
//        strategy.setSuperMapperClass(null);
        strategy.setSuperEntityClass(SuperEntity.class);
//        strategy.setSuperEntityColumns("id");
        return strategy;
    }

    /**
     * 模板配置：velocity模板
     */
    private static TemplateConfig getTemplateConfig() {
        TemplateConfig tc = new TemplateConfig();
        //使用resource下的自定义模板，不想要生成就设置为null,如果不设置null会使用默认模板
        tc.setController("templates/controller.java.vm");
//                .setService("templates/service.java.vm")
//                .setServiceImpl("templates/serviceImpl.java.vm")
//                .setMapper("templates/mapper.java.vm")
//                .setXml("templates/mapper.xml.vm")
//                .setEntity("templates/entity.java.vm")
        return tc;
    }

}
