package com.example.mypage.repository;

import com.example.mypage.domain.MyDisposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyDisposalRepository extends JpaRepository<MyDisposal, Long> {
}
