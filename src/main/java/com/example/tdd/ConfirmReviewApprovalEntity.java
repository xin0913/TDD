package com.example.tdd;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
/*
 * 在這邊加入 @Table，好讓 Entity 可以去指定他要讀哪一個 Table，若沒指定他會直接去讀Entity的名字對應的Table。
 * ex：ConfirmReviewApprovalEntity 就會去讀 CONFIRM_REVIEW_APPROVAL_ENTITY Table。
 * */
@Table(name = "CONFIRM_REVIEW_APPROVAL")
public class ConfirmReviewApprovalEntity {

    @Id
    private String no;

}
