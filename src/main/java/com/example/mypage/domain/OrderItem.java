package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id
    private Long orderItemId;
    private Long itemId;
    private String itemName;
    private String Price;
    private Long Qty;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;  //READY, SHIPPING, CANCEL, COMP


    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private MyOrder myOrder;

}
