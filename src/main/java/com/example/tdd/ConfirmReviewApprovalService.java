package com.example.tdd;

import org.springframework.stereotype.Service;

@Service
public class ConfirmReviewApprovalService {
    private ConfirmReviewApprovalRepository confirmReviewApprovalRepository;
    public ConfirmReviewApprovalResponse queryByNo(String no) {
        ConfirmReviewApprovalEntity confirmReviewApprovalEntity = confirmReviewApprovalRepository.findByNo(no);
//        String resultNo = confirmReviewApprovalRepository.test(no);
        ConfirmReviewApprovalResponse response = new ConfirmReviewApprovalResponse();
        response.setNo(confirmReviewApprovalEntity.getNo());

        return response;
    }
}
