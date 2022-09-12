package com.example.mypage;

import com.example.mypage.domain.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryStarted extends AbstractEvent{
    private Long ecoOrderId;
}
