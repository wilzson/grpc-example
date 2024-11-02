package com.example.grpcclient;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class GrpcClientApplication3 {

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
            Iterator<GreeterProto.HelloResponse1> Iterator = helloService.c2ss(builder.build());
            while(Iterator.hasNext()) {
                GreeterProto.HelloResponse1 next = Iterator.next();
                System.out.println("response = " + next.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }

    }

}
