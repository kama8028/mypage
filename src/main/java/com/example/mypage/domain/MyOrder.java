package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter @Setter
public class MyOrder {

    @Id
    private Long orderId;
    private Long memberId;
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "myOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem = new ArrayList<>();
    private String address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;  //READY, SHIPPING, CANCEL, COMP

    public void addOrderItem(OrderItem orderItem) {
        this.orderItem.add(orderItem);
        orderItem.setMyOrder(this);
    }

    public static MyOrder createMyOrder(Long orderId, Long memberId, OrderItem... orderItems) {
        MyOrder myOrder = new MyOrder();
        myOrder.setOrderId(orderId);
        myOrder.setMemberId(orderId);
        myOrder.setOrderDate(LocalDateTime.now());

        for(OrderItem orderItem : orderItems) {
            myOrder.addOrderItem(orderItem);
        }

        myOrder.setDeliveryStatus(DeliveryStatus.READY);
        return myOrder;
    }


}
