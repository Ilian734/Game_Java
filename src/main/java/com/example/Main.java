package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(1700);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);

        handler.addServlet(new ServletHolder(new Hello()), "/hello");
        handler.addServlet(new ServletHolder(new Ping()), "/ping");
        handler.addServlet(new ServletHolder(new Controller()), "/post-game-result");
        handler.addServlet(new ServletHolder(new Controller()), "/get-score/*");
        handler.addServlet(new ServletHolder(new Controller()), "/ranking");

        server.start();
        server.join();
    }
}