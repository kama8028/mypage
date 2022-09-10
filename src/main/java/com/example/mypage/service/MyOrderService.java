package com.example.mypage.service;

import com.example.mypage.domain.*;
import com.example.mypage.repository.MyAddressRepository;
import com.example.mypage.repository.MyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyOrderService {

    private final MyOrderRepository myOrderRepository;

    public Long order (MyOrder myOrder) {
        //MyOrder myOrder = new MyOrder();

        //myOrder.setOrderId(orderId);
        //myOrder.setMemberId(memberId);
        //myOrder.setOrderDate(LocalDateTime.now());
        //myOrder.setOrderItem(orderItems);
        //myOrder.setAddress("없음");
        //myOrder.setDeliveryStatus(DeliveryStatus.READY);

        //for (OrderItem orderItem : orderItems) {
        //    myOrder.addOrderItem(orderItem);
        //}

        //System.out.println(myOrder.getOrderId());
        //System.out.println(myOrder.getMemberId());
        //System.out.println(myOrder.getOrderDate());
        //System.out.println(myOrder.getAddress());
        //System.out.println(myOrder.getDeliveryStatus());

        myOrderRepository.save(myOrder);

        return myOrder.getOrderId();
    }

    public Long deliverySave(MyOrder myOrder) {

        myOrderRepository.save(myOrder);

        return myOrder.getOrderId();
    }

    public Long cancel (Long orderId) {

        myOrderRepository.delete(orderId);

        return orderId;
    }

    public MyOrder findOne(Long orderId) {
        return myOrderRepository.findOne(orderId);
    }
    public List<MyOrder> findAll(Long memberId) {
        return myOrderRepository.findAll(memberId);
    }

}
