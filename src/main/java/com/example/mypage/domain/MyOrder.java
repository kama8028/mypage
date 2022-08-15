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
    @GeneratedValue
    private Long orderId;
    private Long memberId;
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "myOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem = new ArrayList<>();
    private String address;
}
