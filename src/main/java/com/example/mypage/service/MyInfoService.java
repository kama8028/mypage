package com.example.mypage.service;

import com.example.mypage.domain.MyInfo;
import com.example.mypage.repository.MyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyInfoService {

    private final MyInfoRepository myInfoRepository;

    public MyInfo findOne(Long id) {
        return myInfoRepository.findOne(id);
    }

}
