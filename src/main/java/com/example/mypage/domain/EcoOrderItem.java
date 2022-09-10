package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EcoOrderItem {

    Long ecoProductId;
    String ecoProductName;
    Long ecoProductUnitPrice;
    Long ecoProductQty;

}
