package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/** 임시로 넣어 놓은 Entity 추후 삭제 예정 **/
@Entity
@Getter @Setter
public class MyAddress {

    @Id
    Long addressId;
    Long memberId;
    String basAddr;
    String dtlAddr;

}
