package com.example.mypage.repository;

import com.example.mypage.domain.MyDisposal;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB의 경우 JpaRepository 인터페이스를 사용하지 않고
 * MongoRepository 인터페이스를 사용 한다.
 */
public interface MyDisposalRepository extends MongoRepository<MyDisposal, Long> {
}
