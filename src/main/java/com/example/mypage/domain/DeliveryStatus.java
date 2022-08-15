package com.example.mypage.domain;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
    READY("준비"), SHIPPING("배송중"), CANCEL("취소"), COMP("배송완료");
    private final String value;

    DeliveryStatus(String value) {
        this.value = value;
    }
}
