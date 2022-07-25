package com.example.mypage.repository;

import com.example.mypage.domain.MyDisposal;
import com.example.mypage.domain.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderRepository extends JpaRepository<MyOrder, Long> {
}
