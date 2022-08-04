package com.example.mypage.repository;


import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MyAddressRepository {

    private final EntityManager em;

    public MyAddress findOne(Long id) {
        return em.find(MyAddress.class, id);
    }
}
