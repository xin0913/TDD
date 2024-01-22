package com.example.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/*
 * Q：為甚麼明明都使用了../resources/data.sql && schema.sql 去建立測試用資料庫還需要使用 @DataJpaTest?
 * A：因 @DataJpaTest 除了有建立模擬資料庫的功能以外還有匯入其他相關依賴功能
 *   - 掃描 @Entity 注解的實體類別，自動配置 EntityManager、DataSource，並提供 @Transactional 功能，在測試結束後自動回滾，以確保測試的獨立性。
 *   - Spring Boot 會自動配置一個嵌入式的 H2 資料庫，並提供相關的 JPA 支持。
 * */
@DataJpaTest
/*
 * 告訴 Spring Boot 在測試中不要替換資料庫配置，而是使用你應用程式主要配置檔中配置的實際資料庫。
 * 這樣可以確保你在測試中使用的資料庫配置與實際生產環境中的配置相同。
 * */
@AutoConfigureTestDatabase(replace = NONE)
class ConfirmReviewApprovalRepositoryTest {

    @Autowired
    private ConfirmReviewApprovalRepository confirmReviewApprovalRepository;

    @Test
    /*
     * 使用 SQL 腳本初始化測試資料
     * */
    @Sql(scripts = "classpath:data.sql")
    void test_find_by_no_should_be_successful() {
        String no = "A123";
        /*
         * actual：實際結果，透過 repository 查詢獲取
         * expected：期望結果，手動建立一個符合預期的實體對象
         * */
        ConfirmReviewApprovalEntity actual = confirmReviewApprovalRepository.findByNo(no);
        ConfirmReviewApprovalEntity expected = new ConfirmReviewApprovalEntity();
        expected.setNo(no);

        /*
         * 使用 AssertJ 的 assertThat 斷言，使用 usingRecursiveComparison 比較對象的屬性
         * 這裡確保 actual 對象與手動建立的 expected 對象的屬性值相等
         * */
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}