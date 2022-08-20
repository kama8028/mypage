package com.example.mypage.repository;

import com.example.mypage.domain.MyOrder;
import com.example.mypage.domain.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyOrderItemRepository {

    private final EntityManager em;

    public OrderItem findOne(Long orderItemId) {
        return em.createQuery("select distinct o from OrderItem o" +
                " where o.orderItemId = :orderItemId", OrderItem.class).setParameter("orderItemId", orderItemId).getSingleResult();
    }
    public void reviewSave(OrderItem orderItem) {
        em.persist(orderItem);
    }

}
