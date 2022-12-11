package com.example.blogService.service;


import com.example.blogService.grpc.blog.HelloGrpc;
import com.example.blogService.grpc.blog.HelloRequest;
import com.example.blogService.grpc.blog.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

// 声明这是一个grpc服务类并继承 xxxGrpc.xxxImplBase
@GrpcService
public class HelloService extends HelloGrpc.HelloImplBase {

    /**
     *
     * @param request :请求体
     * @param responseObserver :onNext返回消息 onCompleted表示service处理完毕
     */
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getName();
        HelloResponse response = HelloResponse.newBuilder().setResult("Hi!" + name).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
