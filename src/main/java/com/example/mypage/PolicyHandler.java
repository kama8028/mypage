package com.example.mypage;

import com.example.mypage.config.kafka.KafkaProcessor;
import com.example.mypage.domain.OrderItem;
import com.example.mypage.service.MyOrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PolicyHandler {

    private final MyOrderItemService myOrderItemService;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){

        System.out.println(eventString);

    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewWritten(@Payload ReviewWritten reviewWritten) {

        System.out.println(reviewWritten);
        System.out.println("reviewWritten 진입");

        if (!reviewWritten.validate()) return;

        OrderItem orderItem = myOrderItemService.findOne(reviewWritten.getOrderItemId());
        orderItem.setReviewId(reviewWritten.getReviewId());

        myOrderItemService.reviewSave(orderItem);
    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewDeleted(@Payload ReviewDeleted reviewDeleted) {

        System.out.println(reviewDeleted);
        System.out.println("reviewDeleted 진입");

        if (!reviewDeleted.validate()) return;

        OrderItem orderItem = myOrderItemService.findOne(reviewDeleted.getOrderItemId());
        orderItem.setReviewId(0L);

        myOrderItemService.reviewSave(orderItem);
    }
}
