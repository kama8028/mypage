package com.example.mypage.service;

import com.example.mypage.domain.MyAddress;
import com.example.mypage.domain.MyOrder;
import com.example.mypage.repository.MyAddressRepository;
import com.example.mypage.repository.MyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyOrderService {

    private final MyOrderRepository myOrderRepository;

    public List<MyOrder> findAll(Long memberId) {
        return myOrderRepository.findAll(memberId);
    }

}
