package com.example.mypage.repository;

import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyDisposal;
import com.example.mypage.domain.MyEcoPoint;
import com.example.mypage.domain.MyOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyOrderRepository {

    private final EntityManager em;

    public MyOrder findOne(Long orderId) {
        return em.find(MyOrder.class, orderId);
    }

    public List<MyOrder> findAll(Long memberId) {
        return em.createQuery("select distinct m from MyOrder m" +
                                 " join fetch m.orderItem o" +
                                 " where m.memberId = :memberId" +
                                 " order by m.orderDate desc", MyOrder.class).setParameter("memberId", memberId).getResultList();
    }

    public void save(MyOrder myOrder) {
        em.persist(myOrder);
    }

    public void delete(Long orderId) {
        MyOrder myOrder = em.find(MyOrder.class, orderId);
        em.remove(myOrder);
    }

}
