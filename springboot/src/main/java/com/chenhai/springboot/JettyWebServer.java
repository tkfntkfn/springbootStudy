package com.chenhai.springboot;

/**
 * @author hai.chen
 * @date 2022/7/15
 */
public class JettyWebServer implements WebServer {

    @Override
    public void start() {
        System.out.println("启动jetty");
    }

}
