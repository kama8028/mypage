package com.example.mypage;

import com.example.mypage.config.kafka.KafkaProcessor;
import com.example.mypage.domain.MyOrder;
import com.example.mypage.domain.OrderItem;
import com.example.mypage.service.MyDisposalService;
import com.example.mypage.service.MyOrderItemService;
import com.example.mypage.service.MyOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PolicyHandler {

    private final MyOrderItemService myOrderItemService;
    private final MyOrderService myOrderService;
    private final MyDisposalService myDisposalService;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){

        System.out.println(eventString);

    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCompleted(@Payload PaymentCompleted paymentCompleted) {

        System.out.println(paymentCompleted);
        System.out.println("paymentCompleted 진입");

        if (!paymentCompleted.validate()) return;

        Long orderId = myOrderService.order(paymentCompleted.getOrderId(), paymentCompleted.getMemberId(), paymentCompleted.getOrderDate(), paymentCompleted.getOrderItem());

    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCanceled(@Payload PaymentCanceled paymentCanceled) {

        System.out.println(paymentCanceled);
        System.out.println("paymentCompleted 진입");

        if (!paymentCanceled.validate()) return;

        Long orderId = myOrderService.cancel(paymentCanceled.getOrderId());

    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDisposalCompleted(@Payload DisposalCompleted disposalCompleted) {

        System.out.println(disposalCompleted);
        System.out.println("disposalCompleted 진입");

        if (!disposalCompleted.validate()) return;

        Long disposalId = myDisposalService.disposal(disposalCompleted.getDisposalId(),
                disposalCompleted.getMemberId(),
                disposalCompleted.getDisposalDate(),
                disposalCompleted.getBranchName(),
                disposalCompleted.getDisposalItem());
    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCompleted(@Payload DeliveryCompleted deliveryCompleted) {

        System.out.println(deliveryCompleted);
        System.out.println("deliveryCompleted 진입");

        if (!deliveryCompleted.validate()) return;

        MyOrder myOrder = myOrderService.findOne(deliveryCompleted.getOrderId());
        myOrder.setDeliveryStatus(deliveryCompleted.getDeliveryStatus());

        myOrderService.deliverySave(myOrder);
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
