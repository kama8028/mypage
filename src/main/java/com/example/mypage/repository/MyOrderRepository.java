package com.example.mypage.repository;

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

//    public List<MyOrder> findOne(Long memberId) {
//
//        String jpql = "select o from myOrder o where member_id";
//
//        return em.find(MyOrder.class, memberId);
//    }

}
