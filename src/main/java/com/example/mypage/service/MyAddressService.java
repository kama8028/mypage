package com.example.mypage.service;

import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyInfo;
import com.example.mypage.repository.MyAddressRepository;
import com.example.mypage.repository.MyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyAddressService {

    private final MyAddressRepository myAddressRepository;

    public List<MyAddress> findAll(Long memberId) {
        return myAddressRepository.findAll(memberId);
    }

}
