package com.example.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/*
 * 1. 查詢簽審單
 *  no: "A123"
 *  1-1 查無簽審單
 *      throw QueryNoApprovalFormFoundException.java
 * 2. 回復簽審資訊
 * {
 *      no: "A123"
 * }
 * */
@ExtendWith(MockitoExtension.class)
class ConfirmReviewApprovalServiceTest {
    /*
     * @InjectMocks 用於標註待測試的服務類別（ConfirmReviewApprovalService）。
     * */
    @InjectMocks
    private ConfirmReviewApprovalService confirmReviewApprovalService;

    /*
     * @Mock 用於標註服務類別中所依賴的 ConfirmReviewApprovalRepository 的模擬物件。
     *
     * @Mock
     * private ConfirmReviewApprovalRepositoryImpl confirmReviewApprovalRepository;
     * */
    @Mock
    private ConfirmReviewApprovalRepository confirmReviewApprovalRepository;

    /*
     * 模擬設定 => 執行被測試的方法 => 預期結果設定 => 比較實際與預期結果 => 驗證方法呼叫
     * */
    @Test
    void test_query_approval_form_should_be_successful() {
        ConfirmReviewApprovalEntity confirmReviewApprovalEntity = new ConfirmReviewApprovalEntity();
        confirmReviewApprovalEntity.setNo("A123");
        /*
         * 檢查 confirmReviewApprovalRepository 是否有通。
         * 使用 Mockito 的 given 方法，模擬了 confirmReviewApprovalRepository 的 findByNo 方法，
         * 並設定當傳入任意字串時，都會返回指定的值。
         * given(confirmReviewApprovalRepository.test(anyString())).willReturn("A123");
         * */
        given(confirmReviewApprovalRepository.findByNo(anyString())).willReturn(confirmReviewApprovalEntity);

        /*
         * 檢查 confirmReviewApprovalService 是否有通。
         * 呼叫被測試的 queryByNo 方法，這會觸發模擬的 confirmReviewApprovalRepository.findByNo 方法。
         * */
        ConfirmReviewApprovalResponse actual = confirmReviewApprovalService.queryByNo("A123");

        /*
         * 檢查 ConfirmReviewApprovalResponse 是否有通。
         * 創建一個 ConfirmReviewApprovalResponse 物件 expected，並設定其屬性。
         * */
        ConfirmReviewApprovalResponse expected = new ConfirmReviewApprovalResponse();
        expected.setNo("A123");

        /*
         * usingRecursiveComparison(): 比較物件的所有屬性，包括內部物件。
         * isEqualTo(): 確保 actual 與 expected 的每個屬性都相等。
         * 這邊gpt說可以只使用一個方法就好，不必兩者同時使用。
         * ----------------------------------------------------------
         * 簡單的比喻：
         *  isEqualTo(expected) 就像檢查兩個盒子的外觀是否一樣。
         *  usingRecursiveComparison() 則是打開盒子，並檢查裡面的每一樣東西是否都一樣。
         *
         * assertEquals(expected, actual);
         * */
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);

        /*
         * verify(): 確保 confirmReviewApprovalRepository 的 findByNo 方法被呼叫一次，而且傳入的參數是 "A123"，若這個條件不滿足，測試將會失敗。
         * verify(mockObject, VerificationMode).methodName(expectedArgument);
         * mockObject: 被模擬的物件
         * VerificationMode: 驗證模式，times(1) 表示確保方法被呼叫一次
         * methodName: 方法名稱
         * expectedArgument: 預期的參數
         * */
        verify(confirmReviewApprovalRepository, times(1)).findByNo("A123");
    }
}
