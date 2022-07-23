package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class OrderItem {

    private Long orderId;
    private Long orderItemId;
    private String orderItemName;

}
