package com.example.mypage.repository;

import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyDisposal;
import com.example.mypage.domain.MyOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyOrderRepository {

    private final EntityManager em;

    public List<MyOrder> findAll(Long memberId) {
        return em.createQuery("select m from MyOrder m where m.memberId = :memberId", MyOrder.class).setParameter("memberId", memberId).getResultList();
    }

}
