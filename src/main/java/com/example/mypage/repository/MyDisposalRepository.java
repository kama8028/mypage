package com.example.mypage.repository;

import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyDisposal;
import com.example.mypage.domain.MyOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyDisposalRepository{

    private final EntityManager em;

    public List<MyDisposal> findAll(Long memberId) {
        return em.createQuery("select distinct m from MyDisposal m" +
                                 " join fetch m.disposalItem d" +
                                 " where m.memberId = :memberId order by m.disposalDate desc", MyDisposal.class).setParameter("memberId", memberId).getResultList();
    }

    public void save(MyDisposal myDisposal) {
        em.persist(myDisposal);
    }

}
