package com.example.mypage.service;

import com.example.mypage.domain.MyDisposal;
import com.example.mypage.domain.MyOrder;
import com.example.mypage.repository.MyDisposalRepository;
import com.example.mypage.repository.MyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyDisposalService {

    private final MyDisposalRepository myDisposalRepository;

    public List<MyDisposal> findAll(Long memberId) {
        return myDisposalRepository.findAll(memberId);
    }

}
