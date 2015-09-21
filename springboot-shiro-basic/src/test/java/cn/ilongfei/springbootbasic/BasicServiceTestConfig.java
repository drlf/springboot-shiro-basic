package cn.ilongfei.springbootbasic;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

/**
 * 废弃。2015-9-10
 * service 和 repository的测试一样。使用RepositoryTestConfig
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@ActiveProfiles("unittest")
public class BasicServiceTestConfig {
}
