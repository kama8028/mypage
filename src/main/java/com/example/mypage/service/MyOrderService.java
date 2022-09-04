package com.example.mypage.service;

import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyOrder;
import com.example.mypage.domain.OrderItem;
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

    public Long order (Long orderId, Long memberId, LocalDateTime orderDate, List<OrderItem> orderItem) {
        MyOrder myOrder = new MyOrder();

        myOrder.setOrderId(orderId);
        myOrder.setMemberId(memberId);
        myOrder.setOrderDate(orderDate);
        myOrder.setOrderItem(orderItem);

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
