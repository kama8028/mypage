package com.example.mypage.repository;

import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyDisposal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MyDisposalRepository{

    private final EntityManager em;

    public MyDisposal findOne(Long memberId) {
        return em.find(MyDisposal.class, memberId);
    }

}
