package com.example.grpcclient;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.GreeterServiceGrpc;
import com.example.grpc.common.proto.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClientApplication2 {

    public static void main(String[] args) {
        // 1. 创建通信的管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        try {
            // 2. 获取代理对象 stub
            HelloServiceGrpc.HelloServiceBlockingStub helloService = HelloServiceGrpc.newBlockingStub(managedChannel);
            // 3. 完成RPC调用
            // 3.1 准备参数
            GreeterProto.HelloRequest1.Builder builder = GreeterProto.HelloRequest1.newBuilder();
            for (int i =0; i < 3; i++) {
                builder.addName("fzf" + i);
            }
            GreeterProto.HelloResponse1 response = helloService.sayHello2(builder.build());
            System.out.println(response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }

    }

}
