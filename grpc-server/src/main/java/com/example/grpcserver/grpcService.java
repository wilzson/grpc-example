package com.example.grpcserver;

import com.example.grpcserver.service.HelloService;
import com.example.grpcserver.service.HelloService1;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class grpcService {
    public static void main(String[] args) throws IOException, InterruptedException {

        // 1. 绑定端口
        ServerBuilder serverBuilder = ServerBuilder.forPort(9000);
        // 2. 发布服务
        serverBuilder.addService(new HelloService());
        serverBuilder.addService(new HelloService1());
        // 3. 创建服务对象
        Server server = serverBuilder.build();

        server.start();
        server.awaitTermination();
    }
}
