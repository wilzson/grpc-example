package com.example.grpcserverbootstarter.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: Hello.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloServiceGrpc {

  private HelloServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "HelloService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest.class,
      responseType = com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse> getSayHelloMethod;
    if ((getSayHelloMethod = HelloServiceGrpc.getSayHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSayHelloMethod = HelloServiceGrpc.getSayHelloMethod) == null) {
          HelloServiceGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getSayHello2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello2",
      requestType = com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.class,
      responseType = com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getSayHello2Method() {
    io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getSayHello2Method;
    if ((getSayHello2Method = HelloServiceGrpc.getSayHello2Method) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSayHello2Method = HelloServiceGrpc.getSayHello2Method) == null) {
          HelloServiceGrpc.getSayHello2Method = getSayHello2Method =
              io.grpc.MethodDescriptor.<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("SayHello2"))
              .build();
        }
      }
    }
    return getSayHello2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getC2ssMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "c2ss",
      requestType = com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.class,
      responseType = com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getC2ssMethod() {
    io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getC2ssMethod;
    if ((getC2ssMethod = HelloServiceGrpc.getC2ssMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getC2ssMethod = HelloServiceGrpc.getC2ssMethod) == null) {
          HelloServiceGrpc.getC2ssMethod = getC2ssMethod =
              io.grpc.MethodDescriptor.<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "c2ss"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("c2ss"))
              .build();
        }
      }
    }
    return getC2ssMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getCs2sMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cs2s",
      requestType = com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.class,
      responseType = com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getCs2sMethod() {
    io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getCs2sMethod;
    if ((getCs2sMethod = HelloServiceGrpc.getCs2sMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getCs2sMethod = HelloServiceGrpc.getCs2sMethod) == null) {
          HelloServiceGrpc.getCs2sMethod = getCs2sMethod =
              io.grpc.MethodDescriptor.<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "cs2s"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("cs2s"))
              .build();
        }
      }
    }
    return getCs2sMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getCs2ssMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cs2ss",
      requestType = com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.class,
      responseType = com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
      com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getCs2ssMethod() {
    io.grpc.MethodDescriptor<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> getCs2ssMethod;
    if ((getCs2ssMethod = HelloServiceGrpc.getCs2ssMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getCs2ssMethod = HelloServiceGrpc.getCs2ssMethod) == null) {
          HelloServiceGrpc.getCs2ssMethod = getCs2ssMethod =
              io.grpc.MethodDescriptor.<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1, com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "cs2ss"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("cs2ss"))
              .build();
        }
      }
    }
    return getCs2ssMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceStub>() {
        @java.lang.Override
        public HelloServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceStub(channel, callOptions);
        }
      };
    return HelloServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceBlockingStub>() {
        @java.lang.Override
        public HelloServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceBlockingStub(channel, callOptions);
        }
      };
    return HelloServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceFutureStub>() {
        @java.lang.Override
        public HelloServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceFutureStub(channel, callOptions);
        }
      };
    return HelloServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sayHello(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    default void sayHello2(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1 request,
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHello2Method(), responseObserver);
    }

    /**
     */
    default void c2ss(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1 request,
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getC2ssMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1> cs2s(
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCs2sMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1> cs2ss(
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCs2ssMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HelloService.
   */
  public static abstract class HelloServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HelloServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HelloService.
   */
  public static final class HelloServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HelloServiceStub> {
    private HelloServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayHello2(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1 request,
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHello2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void c2ss(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1 request,
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getC2ssMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1> cs2s(
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getCs2sMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1> cs2ss(
        io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCs2ssMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HelloService.
   */
  public static final class HelloServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HelloServiceBlockingStub> {
    private HelloServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse sayHello(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1 sayHello2(com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1 request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHello2Method(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> c2ss(
        com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1 request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getC2ssMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HelloService.
   */
  public static final class HelloServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HelloServiceFutureStub> {
    private HelloServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse> sayHello(
        com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1> sayHello2(
        com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1 request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHello2Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SAY_HELLO2 = 1;
  private static final int METHODID_C2SS = 2;
  private static final int METHODID_CS2S = 3;
  private static final int METHODID_CS2SS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse>) responseObserver);
          break;
        case METHODID_SAY_HELLO2:
          serviceImpl.sayHello2((com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1) request,
              (io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>) responseObserver);
          break;
        case METHODID_C2SS:
          serviceImpl.c2ss((com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1) request,
              (io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CS2S:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.cs2s(
              (io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>) responseObserver);
        case METHODID_CS2SS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.cs2ss(
              (io.grpc.stub.StreamObserver<com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSayHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest,
              com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse>(
                service, METHODID_SAY_HELLO)))
        .addMethod(
          getSayHello2Method(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
              com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>(
                service, METHODID_SAY_HELLO2)))
        .addMethod(
          getC2ssMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
              com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>(
                service, METHODID_C2SS)))
        .addMethod(
          getCs2sMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
              com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>(
                service, METHODID_CS2S)))
        .addMethod(
          getCs2ssMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.example.grpcserverbootstarter.proto.HelloProto.HelloRequest1,
              com.example.grpcserverbootstarter.proto.HelloProto.HelloResponse1>(
                service, METHODID_CS2SS)))
        .build();
  }

  private static abstract class HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpcserverbootstarter.proto.HelloProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloService");
    }
  }

  private static final class HelloServiceFileDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier {
    HelloServiceFileDescriptorSupplier() {}
  }

  private static final class HelloServiceMethodDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HelloServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSayHello2Method())
              .addMethod(getC2ssMethod())
              .addMethod(getCs2sMethod())
              .addMethod(getCs2ssMethod())
              .build();
        }
      }
    }
    return result;
  }
}
