package com.ashok.httpserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpServer;


 class Application {

    public static void main(String[] args) throws IOException {
        int serverport =8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverport),0 );
        server.createContext("/api/hello", (exchange -> {
            String respText = "Hello!";
            exchange.sendResponseHeaders(200, respText.getBytes().length);
            OutputStream output = exchange.getResponseBody();
            output.write(respText.getBytes());
            output.flush();
            exchange.close();
        }));
        server.setExecutor(null); // creates a default executor
        server.start();
    }
    
}
