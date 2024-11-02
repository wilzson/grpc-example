# gRPC利用Java实现例子

## 一元调用（同步，阻塞等待）

1. 添加maven插件，进行protobuf的 IDL文件的编译

具体参考官方文档例子https://github.com/grpc/grpc-java

```
1. .proto文件 书写protobuf的IDL
2. [了解]protoc命令，把proto文件中的IDL 转换为编程语言
	protoc --java_out=/xxx/xxx  /xxx/xxx/xx.proto
3. [实战] maven插件 进行protobuf IDL文件的编译，并把他放置具体位置
```

```java
pom.xml
<dependency>
  <groupId>io.grpc</groupId>
  <artifactId>grpc-netty-shaded</artifactId>
  <version>1.68.1</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.grpc</groupId>
  <artifactId>grpc-protobuf</artifactId>
  <version>1.68.1</version>
</dependency>
<dependency>
  <groupId>io.grpc</groupId>
  <artifactId>grpc-stub</artifactId>
  <version>1.68.1</version>
</dependency>
<dependency> <!-- necessary for Java 9+ -->
  <groupId>org.apache.tomcat</groupId>
  <artifactId>annotations-api</artifactId>
  <version>6.0.53</version>
  <scope>provided</scope>
</dependency>
// 生成protoc插件
<build>
  <extensions>
    <extension>
      <groupId>kr.motd.maven</groupId>
      <artifactId>os-maven-plugin</artifactId>
      <version>1.7.1</version>
    </extension>
  </extensions>
  <plugins>
    <plugin>
      <groupId>org.xolstice.maven.plugins</groupId>
      <artifactId>protobuf-maven-plugin</artifactId>
      <version>0.6.1</version>
      <configuration>
        <protocArtifact>com.google.protobuf:protoc:3.25.5:exe:${os.detected.classifier}</protocArtifact>
        <pluginId>grpc-java</pluginId>
        <pluginArtifact>io.grpc:protoc-gen-grpc-java:1.68.1:exe:${os.detected.classifier}</pluginArtifact>
            <!--生成的输出结果放在哪个文件夹-->
                    <outputDirectory>${basedir}/src/main/java</outputDirectory>
                    <clearOutputDirectory>false</clearOutputDirectory> <!--追加模式-->
      </configuration>
      <executions>
        <execution>
          <goals>
            <goal>compile</goal>
            <goal>compile-custom</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

2. 正常生成proto代码需要两个命令。

```
protobuf::complie // 生成message
protobuf::complie-custom // 生成service
```

![image-20241102180117545](C:\Users\fzefeng\AppData\Roaming\Typora\typora-user-images\image-20241102180117545.png)



3. 服务端开发

```java
package com.example.grpcserver.service;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.GreeterServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

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
```

```java
package com.example.grpcserver;

import com.example.grpcserver.service.HelloService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class grpcService {
    public static void main(String[] args) throws IOException, InterruptedException {

        // 1. 绑定端口
        ServerBuilder serverBuilder = ServerBuilder.forPort(9000);
        // 2. 发布服务
        serverBuilder.addService(new HelloService());
        // 3. 创建服务对象
        Server server = serverBuilder.build();

        server.start();
        server.awaitTermination();
    }
}

```



3. 客户端开发

```java
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

```

## 服务端流式返回

```java
service GreeterService{
  rpc SayHello (HelloRequest) returns (Stream HelloResponse);
}
```

### 监听、异步服务端流式调用

```java
// 1. 创建通信的管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        try {
            // 2. 获取代理对象 stub  监听异步方式
            HelloServiceGrpc.HelloServiceStub helloService = HelloServiceGrpc.newStub(managedChannel);
            // 3. 完成RPC调用
            // 3.1 准备参数
            GreeterProto.HelloRequest1.Builder builder = GreeterProto.HelloRequest1.newBuilder();
            for (int i =0; i < 3; i++) {
                builder.addName("fzf" + i);
            }
            GreeterProto.HelloRequest1 request = builder.build();
            helloService.c2ss(request, new StreamObserver<GreeterProto.HelloResponse1>() {
                @Override
                public void onNext(GreeterProto.HelloResponse1 value) {
                    // 服务端 响应了 一个消息后，需要立刻进行处理
                    System.out.println("response = " + value.getMessage());
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("Error");
                }

                @Override
                public void onCompleted() {
                    // 需要把服务端 响应的所有数据 拿到后，再进行业务处理
                    System.out.println("业务处理完 Done");
                }
            });

            managedChannel.awaitTermination(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }

```



## 客户端流式RPC

```java
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
            }
            helloRequest1StreamObserver.onCompleted();
            managedChannel.awaitTermination(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }

```

## 双向流式RPC

服务端：

```java
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
```

客户端

```java
package com.example.grpcclient;

import com.example.grpc.common.proto.GreeterProto;
import com.example.grpc.common.proto.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

// 双向流式RPC
public class GrpcClientApplication6 {

    public static void main(String[] args) {
        // 1. 创建通信的管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        try {
            // 2. 获取代理对象 stub  监听异步方式
            HelloServiceGrpc.HelloServiceStub helloService = HelloServiceGrpc.newStub(managedChannel);
            // 3. 完成RPC调用
            StreamObserver<GreeterProto.HelloRequest1> helloRequest1StreamObserver = helloService.cs2ss(new StreamObserver<GreeterProto.HelloResponse1>() {
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
                helloRequest1StreamObserver.onNext(GreeterProto.HelloRequest1.newBuilder().addName("fzf" + i).build());
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

```

## springboot整合grpc

```markdown
1. 引入common包，包含proto文件
2. 引入对应的依赖，服务端，客户端分别引入对应依赖
```

```xml
// 服务端
<dependency>
    <groupId>com.example</groupId>
    <artifactId>grpc-common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
<dependency>
   <groupId>net.devh</groupId>
   <artifactId>grpc-server-spring-boot-starter</artifactId>
   <version>2.0.1.RELEASE</version>
</dependency>
```

```xm
// 客户端

```

