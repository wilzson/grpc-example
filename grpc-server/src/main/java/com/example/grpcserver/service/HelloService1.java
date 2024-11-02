package com.example.grpcserver.service;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.HelloServiceGrpc;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(HelloService1.class)
public class HelloService1 extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello2(GreeterProto.HelloRequest1 request, StreamObserver<GreeterProto.HelloResponse1> responseObserver) {
        ProtocolStringList nameList = request.getNameList();
        for (String str: nameList) {
            System.out.println(str);
        }

        responseObserver.onNext(GreeterProto.HelloResponse1.newBuilder()
                .setMessage("request parameter: " + nameList)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void c2ss(GreeterProto.HelloRequest1 request, StreamObserver<GreeterProto.HelloResponse1> responseObserver) {
        ProtocolStringList name = request.getNameList();
        System.out.println("name" + name);
        // 根据业务处理的结果，提供响应
        for (int i = 0; i < 9; i++) {
            GreeterProto.HelloResponse1 response = GreeterProto.HelloResponse1.newBuilder()
                    .setMessage("处理的结果" + i)
                    .build();
            responseObserver.onNext(response);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        responseObserver.onCompleted();

    }

    @Override
    public StreamObserver<GreeterProto.HelloRequest1> cs2s(StreamObserver<GreeterProto.HelloResponse1> responseObserver) {
        return new StreamObserver<GreeterProto.HelloRequest1>() {
            String result = "";
            @Override
            public void onNext(GreeterProto.HelloRequest1 helloRequest1) {
                result += helloRequest1.getName(0);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("获取完客户端返回的值 " + result);
                // 提供响应
                GreeterProto.HelloResponse1 response1 = GreeterProto.HelloResponse1.newBuilder()
                        .setMessage(result)
                        .build();
                responseObserver.onNext(response1);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<GreeterProto.HelloRequest1> cs2ss(StreamObserver<GreeterProto.HelloResponse1> responseObserver) {
        return new StreamObserver<GreeterProto.HelloRequest1>() {
            String result = "";
            @Override
            public void onNext(GreeterProto.HelloRequest1 value) {
                System.out.println("处理一条客户端出来的数据" + result);
                result += value.getName(0);
                responseObserver.onNext(GreeterProto.HelloResponse1.newBuilder().setMessage(result).build());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("获取完客户端返回的值 " + result);
                responseObserver.onCompleted();
            }
        };
    }
}
