package com.example.tdd;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ConfirmReviewApprovalController {

    private final ConfirmReviewApprovalService confirmReviewApprovalService;

    @GetMapping("/confirmReviewApproval/{no}")
    public ConfirmReviewApprovalResponse confirmReviewApproval(@PathVariable String no) {
        ConfirmReviewApprovalResponse response = confirmReviewApprovalService.queryByNo(no);
        return response;
//        return confirmReviewApprovalService.queryByNo(no);
    }
}
