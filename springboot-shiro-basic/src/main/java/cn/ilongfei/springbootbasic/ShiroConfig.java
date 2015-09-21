package cn.ilongfei.springbootbasic;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config/shiro-web.xml")
public class ShiroConfig {

}
