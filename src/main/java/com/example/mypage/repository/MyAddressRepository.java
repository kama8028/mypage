package com.example.mypage.repository;


import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyAddressRepository {

    private final EntityManager em;

    public List<MyAddress> findAll(Long memberId) {
        return em.createQuery("select m from MyAddress m where m.memberId = :memberId", MyAddress.class).setParameter("memberId", memberId).getResultList();
    }
}
