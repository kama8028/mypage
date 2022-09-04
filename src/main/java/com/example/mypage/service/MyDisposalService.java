package com.example.mypage.service;

import com.example.mypage.domain.DisposalItem;
import com.example.mypage.domain.MyDisposal;
import com.example.mypage.domain.MyOrder;
import com.example.mypage.repository.MyDisposalRepository;
import com.example.mypage.repository.MyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyDisposalService {

    private final MyDisposalRepository myDisposalRepository;

    public List<MyDisposal> findAll(Long memberId) {
        return myDisposalRepository.findAll(memberId);
    }

    public Long disposal(Long disposalId, Long memberId, LocalDateTime disposalDate, String branchName, List<DisposalItem> disposalItem) {
        MyDisposal myDisposal = new MyDisposal();

        myDisposal.setDisposalId(disposalId);
        myDisposal.setMemberId(memberId);
        myDisposal.setDisposalDate(disposalDate);
        myDisposal.setBranchName(branchName);
        myDisposal.setDisposalItem(disposalItem);

        myDisposalRepository.save(myDisposal);

        return myDisposal.getDisposalId();
    }

}
