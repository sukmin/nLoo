package kr.netty.nloo.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:properties/common.properties")
public class DataSourceConfig {

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	@Description("DataSource configuration for the tomcat jdbc connection pool")
	public DataSource dataSource() throws ClassNotFoundException {

		// See here for more details on commons-dbcp versus tomcat-jdbc:
		// http://blog.ippon.fr/2013/03/13/improving-the-performance-of-the-spring-petclinic-sample-application-part-3-of-5/-->
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		/* 미사용인채로 오래두면 디비커넥션이 끊기는 문제가 발생하여
		 * 아래의 설정 적용
		 *  참고 : http://idkbj.tistory.com/91 
		 *  */
		//커넥션 유효성 검사를 풀에 idle 상태에 존재할때 실시할것인지 여부 (기본값 : false, 반드시 validationQuery 가 설정되어 있어야 함.)
		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("SELECT 1");
		//정된 시간 간격마다 놀고 있는 커넥션을 풀에서 제거하는 evictor thread 가 실행된다. minIdle 로 커넥션을 유지한다.
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		//evictor thread 가 한번실행시 검사할 대상 커넥션 개수.
		dataSource.setNumTestsPerEvictionRun(5);
		//evictor thread 작업시 설정된 시간만큼 사용되지 않은 커넥션을 제거한다. 
		dataSource.setMinEvictableIdleTimeMillis(-1);
		return dataSource;
	}

}
