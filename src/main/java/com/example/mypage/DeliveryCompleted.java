package com.example.mypage;

import com.example.mypage.domain.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCompleted extends AbstractEvent{

    private Long orderId;
    private DeliveryStatus deliveryStatus;

}
