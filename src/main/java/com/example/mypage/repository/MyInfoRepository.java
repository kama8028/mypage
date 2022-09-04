package com.example.mypage.repository;

import com.example.mypage.domain.MyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MyInfoRepository {

    private final EntityManager em;

    public MyInfo findOne(Long id) {
        return em.find(MyInfo.class, id);
    }



}
