package com.example.mypage.repository;

import com.example.mypage.domain.MyEcoPoint;
import com.example.mypage.domain.MyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MyEcoPointRepository {

    private final EntityManager em;

    public MyEcoPoint findOne(Long id) {
        return em.find(MyEcoPoint.class, id);
    }

}
