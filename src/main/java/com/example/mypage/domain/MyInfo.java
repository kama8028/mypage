package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/** 임시로 넣어 놓은 Entity 추후 삭제 예정 **/
@Entity
@Getter @Setter
public class MyInfo {

    @Id
    Long memberId;
    String name;
    String email;
    String phone;

}
