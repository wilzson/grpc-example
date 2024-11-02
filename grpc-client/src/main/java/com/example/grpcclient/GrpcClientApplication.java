package com.example.grpcclient;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.GreeterServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class GrpcClientApplication {

    public static void main(String[] args) {
        // 1. 创建通信的管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        try {
            // 2. 获取代理对象 stub
            GreeterServiceGrpc.GreeterServiceBlockingStub greetService= GreeterServiceGrpc.newBlockingStub(managedChannel);
            // 3. 完成RPC调用
            // 3.1 准备参数
            GreeterProto.HelloRequest.Builder builder = GreeterProto.HelloRequest.newBuilder();
            builder.setName("fzf");
            GreeterProto.HelloResponse response = greetService.sayHello(builder.build());
            System.out.println(response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }

    }

}
