package com.example.mypage;

import com.example.mypage.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableBinding(KafkaProcessor.class)
public class MypageApplication {

	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MypageApplication.class, args);
	}

}
