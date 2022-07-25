package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@Getter @Setter
public class MyDisposal {

    @Id
    private Long disposalId;
    private Long memberId;
    private LocalDateTime disposalDate;

    @Embedded
    private DisposalItem disposalItem;
    private String BranchName;


}
