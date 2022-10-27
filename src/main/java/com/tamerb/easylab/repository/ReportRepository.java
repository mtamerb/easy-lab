package com.tamerb.easylab.repository;

import com.tamerb.easylab.model.Report;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query("SELECT r FROM Report r WHERE "
            + "CONCAT( r.nameSurname, ' ', r.fileNo, ' ', r.diagnosisDetail, ' ', r.diagnosticTitle, '' ,"
            + "r.reportDate, ' ', r.tc , ' ' , r.laborant.id ) "
            + " LIKE %?1%")
    public List<Report> findAll(String keyword, Pageable pageable);
}
