package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class DisposalItem {

    @Id
    Long disposalItemId;
    Long recycleItemId;
    String recycleItemName;
    Long Qty;
    Long Weight;
    Long Point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="disposal_id")
    private MyDisposal myDisposal;

}
