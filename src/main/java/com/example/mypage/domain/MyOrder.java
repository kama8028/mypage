package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter @Setter
public class MyOrder {

    @Id
    private Long orderId;
    private Long memberId;
    private LocalDateTime orderDate;

    @Embedded
    private OrderItem orderItem;
    private String address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
