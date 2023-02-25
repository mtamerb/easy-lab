package com.tamerb.easylab;


import com.tamerb.easylab.model.Report;
import com.tamerb.easylab.repository.ReportRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ReportRepositoryTests {

    @Autowired
    private ReportRepository reportRepository;

    @Test
    public void testCreateReport() {

        Report savedReport = reportRepository.save(new Report());
        Assertions.assertThat(savedReport.getId()).isGreaterThan(0);


    }
}
