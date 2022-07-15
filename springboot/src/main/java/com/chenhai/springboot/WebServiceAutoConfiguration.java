package com.chenhai.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hai.chen
 * @date 2022/7/15
 */
@Configuration
public class WebServiceAutoConfiguration implements AutoConfiguration {

    @Bean
    @ChenhaiConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer(){
        return new TomcatWebServer();
    }

    @Bean
    @ChenhaiConditionalOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer(){
        return new JettyWebServer();
    }

}
