package com.chenhai.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

/**
 * @author hai.chen
 * @date 2022/7/15
 */
public class ChenhaiApplication {

    public static void run(Class clazz) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();

        WebServer webServer = getWebServer(applicationContext);
        webServer.start();
    }

    public static WebServer getWebServer(ApplicationContext applicationContext) {
        Map<String, WebServer> webServers = applicationContext.getBeansOfType(WebServer.class);
        if (webServers.isEmpty()) {
            throw new NullPointerException();
        }
        if (webServers.size() > 1) {
            throw new IllegalStateException();
        }
        return webServers.values().stream().findFirst().get();
    }

}
