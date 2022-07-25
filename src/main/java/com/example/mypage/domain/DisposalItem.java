package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class DisposalItem {

    Long disposalItemId;
    String disposalItemName;
    Long Qty;
    Long Weight;
    Long Point;
}
