package controller;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GrpcClient("grpc-server")
    private HelloServiceGrpc.HelloServiceStub stub;

    @GetMapping("/hello")
    public String test(String name) {
        System.out.println(name);
        String res = "";
        stub.sayHello2(GreeterProto.HelloRequest1.newBuilder().addName(name).build(), new StreamObserver<GreeterProto.HelloResponse1>() {
            @Override
            public void onNext(GreeterProto.HelloResponse1 helloResponse1) {
                System.out.println(helloResponse1.getMessage());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });
        return res;
    };
}
