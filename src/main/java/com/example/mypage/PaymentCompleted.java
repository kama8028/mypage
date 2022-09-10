package com.example.mypage;

import com.example.mypage.domain.EcoOrderItem;
import com.example.mypage.domain.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PaymentCompleted extends AbstractEvent {

    private Long ecoOrderId;
    private Long memberId;
    private LocalDateTime ecoOrderDate;
    private List<OrderItem> OrderItem = new ArrayList<>();

}
