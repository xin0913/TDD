package com.example.tdd;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 簽審確認功能
 * "/confirmReviewApproval"
 * GET
 * 1. 查詢簽審單
 * "no": "A123"
 * 1.1 檢核權限
 * 2. 顯示簽審完成
 * {
 *  "no": "A123",
 *  "result": "簽審完成"
 * }
 */
/*
 * @WebMvcTest(ConfirmReviewApprovalController.class)，這表示這個測試僅測試 Controller 的層面，而並不會實際調用 Service 的實現。
 * */
@WebMvcTest(ConfirmReviewApprovalController.class)
public class ConfirmReviewApprovalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // 測試中將使用一個模擬（Mock）的 ConfirmReviewApprovalService，而非實際的 Service 實現。
    @MockBean
    private ConfirmReviewApprovalService confirmReviewApprovalService;

    @Test
    void test_approval_should_be_successful() throws Exception {
        ConfirmReviewApprovalResponse response = new ConfirmReviewApprovalResponse();
        response.setNo("A123");
        response.setResult("簽署完成");
        /*
         * given(confirmReviewApprovalService.queryByNo(anyString())) 模擬 queryByNo 方法的行為，
         * 並返回一個預先定義好的 ConfirmReviewApprovalResponse 物件。
         * */
        given(confirmReviewApprovalService.queryByNo(anyString())).willReturn(response);
        /*
         * given 的主要作用是告訴 Mockito 當特定的條件滿足時，模擬物件應該如何行為。
         * */
        // -------------------------------------------------------------------------------------------

        // 執行模擬的 HTTP GET 請求到 "/confirmReviewApproval/A123"
        mockMvc.perform(MockMvcRequestBuilders.get("/confirmReviewApproval/" + "A123"))
                // 印出請求和回應的詳細資訊，方便除錯
                .andDo(print())
                // 驗證狀態碼是否為 HTTP 200 OK
                .andExpect(status().isOk())
                //  // 驗證狀態碼是否為 HTTP 404 Not Found
                // .andExpect(status().isNotFound())
                //  // 驗證狀態碼是否為 HTTP 400 Bad Request
                // .andExpect(status().isBadRequest())
                // 驗證回應體中的 "no" 欄位的值是否為 "A123"
                .andExpect(jsonPath("$.no", Is.is("A123")))
                // 驗證回應體中的 "result" 欄位的值是否為 "簽署完成"
                .andExpect(jsonPath("$.result", Is.is("簽署完成")));
    }

    @Test
    void test_no_approval_form_found() throws Exception {
        given(confirmReviewApprovalService.queryByNo(anyString()))
                .willThrow(new QueryNoApprovalFormFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/confirmReviewApproval/" + "A789"))
                // 印出請求和回應的詳細資訊，方便除錯
                .andDo(print())
                // 驗證狀態碼是否為 HTTP 404 Not Found
                .andExpect(status().isNotFound())
                // 驗證回應體中的 "status" 欄位的值是否為 "F"
                .andExpect(jsonPath("$.status", Is.is("F")))
                // 驗證回應體中的 "msg" 欄位的值是否為 "查無簽審單"
                .andExpect(jsonPath("$.msg", Is.is("查無簽審單")));
    }
}
