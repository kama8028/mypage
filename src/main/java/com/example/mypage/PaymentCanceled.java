package com.example.mypage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCanceled extends AbstractEvent {

    private Long ecoOrderId;

}
