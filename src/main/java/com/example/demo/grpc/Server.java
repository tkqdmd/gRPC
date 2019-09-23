package com.example.demo.grpc;

import io.grpc.ServerBuilder;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        BasicConfigurator.configure();
        io.grpc.Server server = ServerBuilder.forPort(8080)
                .addService(new HelloServiceImpl()).build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }
}
