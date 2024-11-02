package com.example.grpcclient;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
// 客户端流式RPC
public class GrpcClientApplication5 {

    public static void main(String[] args) {
        // 1. 创建通信的管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        try {
            // 2. 获取代理对象 stub  监听异步方式
            HelloServiceGrpc.HelloServiceStub helloService = HelloServiceGrpc.newStub(managedChannel);
            // 3. 完成RPC调用
            StreamObserver<GreeterProto.HelloRequest1> helloRequest1StreamObserver = helloService.cs2s(new StreamObserver<GreeterProto.HelloResponse1>() {
                @Override
                public void onNext(GreeterProto.HelloResponse1 value) {
                    // 服务端 响应了 一个消息后，需要立刻进行处理
                    System.out.println("response = " + value.getMessage());
                }

                @Override
                public void onError(Throwable throwable) {

                }

                @Override
                public void onCompleted() {
                    // 需要把服务端 响应的所有数据 拿到后，再进行业务处理
                    System.out.println("业务处理完 Done");
                }
            });
            // 3.1 准备参数
            for(int i =0 ; i < 9; i++) {
                GreeterProto.HelloRequest1.Builder builder = GreeterProto.HelloRequest1.newBuilder();
                for (int j =0; j < 3; j++) {
                    builder.addName("fzf" + i);
                }
                GreeterProto.HelloRequest1 request = builder.build();
                helloRequest1StreamObserver.onNext(request);
                Thread.sleep(1000);
            }
            helloRequest1StreamObserver.onCompleted();
            managedChannel.awaitTermination(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }

    }

}
