package com.tamerb.easylab.service;

import com.tamerb.easylab.model.Report;
import com.tamerb.easylab.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;


    public Page<Report> listAll(int pageNum, String sortField, String sortDir,String keyword)
    {
        Pageable pageable = PageRequest.of(pageNum - 1, 5,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending()
        );

        if(keyword != null){
            return (Page<Report>) reportRepository.findAll(keyword, pageable);
        }

        return reportRepository.findAll(pageable);
    }

    public void save(Report report) {
        reportRepository.save(report);
    }

    public Report get(Long id) {
        return reportRepository.findById(id).get();
    }

    public void delete(Long id) {
        reportRepository.deleteById(id);
    }

}
