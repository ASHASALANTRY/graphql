package demo.demoGraphqlResolver.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
@Configuration
public class DBConfiguration {
	@Primary
	@Bean(name = "gqldb")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource daytuneDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "brassJdbcTemplate")
	public JdbcTemplate brassJdbcTemplate(@Qualifier("gqldb") DataSource brassDb) {
		return new JdbcTemplate(brassDb, false);
	}


//	@Primary
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSourceProperties daytuneDataSource() {
//		//return DataSourceBuilder.create().build();
//		 return new DataSourceProperties();
//	}
//
//	
//	   @Bean(name = "gqldb")
//	    @ConfigurationProperties("spring.datasource")
//	    public HikariDataSource dataSource(DataSourceProperties properties) {
//	        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
//	                .build();
//	    }
//
//		@Bean(name = "brassJdbcTemplate")
//		public JdbcTemplate brassJdbcTemplate(@Qualifier("gqldb") DataSource brassDb) {
//			return new JdbcTemplate(brassDb, false);
//		}
}

