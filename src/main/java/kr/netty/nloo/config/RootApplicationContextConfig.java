package kr.netty.nloo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kr.netty.nloo.service")
// Configurer that replaces ${...} placeholders with values from a properties file
// (in this case, JDBC-related settings for the JPA EntityManager definition below)
@PropertySource("classpath:properties/common.properties")
@Import({DataSourceConfig.class,MybatisConfig.class})
public class RootApplicationContextConfig {

}
