package com.example.blogService.service;

import com.example.blogService.entity.Blog;
import com.example.blogService.mapper.BlogMapper;
import com.example.blogService.grpc.blog.BlogRequest;
import com.example.blogService.grpc.blog.BlogResponse;
import com.example.blogService.grpc.blog.BlogServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class BlogService extends BlogServiceGrpc.BlogServiceImplBase {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public void getBlogById(BlogRequest request, StreamObserver<BlogResponse> responseObserver) {
        int id = request.getId();
        Blog blogResult = blogMapper.getBlogById(id);
        BlogResponse response = null;
        if (blogResult != null) {
             response = BlogResponse.newBuilder()
                    .setId(blogResult.getId())
                    .setCreateTime(blogResult.getCreateTime())
                    .setCategory(blogResult.getCategory())
                    .setContext(blogResult.getContent())
                    .setTitle(blogResult.getTitle())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
