package com.example.mypage.service;


import com.example.mypage.domain.MyOrder;
import com.example.mypage.domain.OrderItem;
import com.example.mypage.repository.MyOrderItemRepository;
import com.example.mypage.repository.MyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyOrderItemService {

    private final MyOrderItemRepository myOrderItemRepository;

    public OrderItem findOne(Long orderItemId) {
        return myOrderItemRepository.findOne(orderItemId);
    }

    public Long reviewSave(OrderItem orderItem) {

        myOrderItemRepository.reviewSave(orderItem);

        return orderItem.getOrderItemId();
    }

    public Long cancel (Long orderId) {

        myOrderItemRepository.delete(orderId);

        return orderId;
    }


}
