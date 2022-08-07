package com.example.mypage.service;

import com.example.mypage.domain.MyEcoPoint;
import com.example.mypage.domain.MyInfo;
import com.example.mypage.repository.MyEcoPointRepository;
import com.example.mypage.repository.MyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyEcoPointService {

    private final MyEcoPointRepository myEcoPointRepository;

    public MyEcoPoint findOne(Long id) {
        return myEcoPointRepository.findOne(id);
    }

}
