package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    private Long orderItemId;
    private Long itemId;
    private String itemName;
    private Long Price;
    private Long Qty;
    private Long reviewId;

    private Long ecoProductId;
    private String ecoProductName;
    private Long ecoProductUnitPrice;
    private Long ecoProductQty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private MyOrder myOrder;

    public OrderItem(){

    }

/*    public static OrderItem createOrderItem(EcoOrderItem ecoOrderItem) {
        OrderItem orderItem = new OrderItem();
    }*/

}
