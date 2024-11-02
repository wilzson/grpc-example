package com.example.grpcserver.service;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.GreeterServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(HelloService.class)
@Slf4j
public class HelloService extends GreeterServiceGrpc.GreeterServiceImplBase {

    /**
     * 1. 接受client提交的参数
     * 2. 业务处理 service + dao
     * 3. 返回结果
     */
    @Override
    public void sayHello(GreeterProto.HelloRequest request, StreamObserver<GreeterProto.HelloResponse> responseObserver) {
        // 1. 接受client提交的参数
        String name = request.getName();
        // 2. 业务处理 service + dao
        System.out.println("name parameter " + name);
        // 3. 返回结果
        // 3.1 创建对应的对象的构造者
        GreeterProto.HelloResponse.Builder builder = GreeterProto.HelloResponse.newBuilder();
        // 3.2 填充数据
        builder.setMessage(name);
        // 3.3 封装响应
        GreeterProto.HelloResponse response = builder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
