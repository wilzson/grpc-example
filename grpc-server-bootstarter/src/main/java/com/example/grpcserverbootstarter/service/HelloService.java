package com.example.grpcserverbootstarter.service;

import com.example.grpcserverbootstarter.proto.HelloProto;
import com.example.grpcserverbootstarter.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {


    @Override
    public void sayHello(HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
        // 1. 接受client提交的参数
        String name = request.getName();
        // 2. 业务处理 service + dao
        System.out.println("name parameter " + name);
        // 3. 返回结果
        // 3.1 创建对应的对象的构造者
        HelloProto.HelloResponse.Builder builder = HelloProto.HelloResponse.newBuilder();
        // 3.2 填充数据
        builder.setMessage(name);
        // 3.3 封装响应
        HelloProto.HelloResponse response = builder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
