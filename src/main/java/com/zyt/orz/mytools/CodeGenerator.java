package com.zyt.orz.mytools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis-plus 代码生成工具
 */
public class CodeGenerator {

	/**
	 * Mapper 文件位置
	 */
	private final static String PACKAGE_URL = "com.zyt.orz";
	/**
	 * Mapper XML 文件位置
	 */
	private final static String MAPPER_XML = "/src/main/resources/mapper/";

	// db连接信息
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://10.1.8.15;databaseName=ReallyTest";
	private static String userName = "sa";
	private static String passWord = "qwer55555";

//	private static String driverName = "com.mysql.jdbc.Driver";
//	private static String url = "jdbc:mysql://localhost:3306/ant?useUnicode=true&useSSL=false&characterEncoding=utf8";
//	private static String userName = "sa";
//	private static String passWord = "qwer55555";

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	@SuppressWarnings("resource")
	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
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
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("zyt");
		gc.setOpen(false);
		// 实体属性 Swagger2 注解
		gc.setSwagger2(true);
		// 数据库到实体 时间类型生成策略
		gc.setDateType(DateType.SQL_PACK);

		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(url);
		dsc.setDriverName(driverName);
		dsc.setUsername(userName);
		dsc.setPassword(passWord);

		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
//		pc.setModuleName(scanner("模块名"));
		// 生成位置
		pc.setParent(PACKAGE_URL);
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};

		// 如果模板引擎是 freemarker
//		String templatePath = "/templates/mapper.xml.ftl";
		// 如果模板引擎是 velocity
		String templatePath = "/templates/mapper.xml.vm";

		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
//						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
				return projectPath + MAPPER_XML + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();

		templateConfig.setXml(null);
		mpg.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//		strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		// 公共父类
//		strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
		// 写于父类中的公共字段
//		strategy.setSuperEntityColumns("id");
		strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		mpg.execute();
	}

}
