package com.xxx.rpc.sample.client;

import com.xxx.rpc.client.RpcProxy;
import com.xxx.rpc.sample.api.HelloService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("World");
        System.out.println(result);

        HelloService helloService2 = rpcProxy.create(HelloService.class, "sample.hello2");
        String result2 = helloService2.hello("世界");
        System.out.println(result2);

        FileInputStream in = new FileInputStream("xxx");
        FileChannel channel = in.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        channel.read(allocate);
        
        
        FileOutputStream out = new FileOutputStream("");
        FileChannel channel2 = out.getChannel();
        ByteBuffer src = ByteBuffer.allocate(1024);
        src.put("aa".getBytes());
		channel2.write(src);
        
        System.exit(0);
    }
}
