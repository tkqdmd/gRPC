package com.example.demo.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.log4j.BasicConfigurator;
import org.example.demo.grpc.HelloRequest;
import org.example.demo.grpc.HelloResponse;
import org.example.demo.grpc.HelloServiceGrpc;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext(true)
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Tony")
                .setLastName("Stark")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }
}
