package com.example.tdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
 * JpaRepository<實體類別（Entity Class）的型別, 主鍵(@Id)的型別>
 * */
public interface ConfirmReviewApprovalRepository extends JpaRepository<ConfirmReviewApprovalEntity, String> {
    ConfirmReviewApprovalEntity findByNo(String no);

    String test(String no);
}