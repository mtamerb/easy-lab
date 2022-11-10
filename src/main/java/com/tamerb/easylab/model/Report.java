package com.tamerb.easylab.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "laborant_id")
    private Laborant laborant;


    @NotNull
    private String fileNo;

    @NotNull
    private String nameSurname;

    @Column(unique = true)
    private String tc;

    @NotNull
    private String diagnosticTitle;

    @NotNull
    private String diagnosisDetail;

    @NotNull
    private String reportDate;

    private String photo;

    public Report(Long id) {

    }

    public Report() {

    }
    @Transient
    public String getPhotosImagePath() {
        if (photo == null || id == null) return null;

        return "/report-photos/" + id + "/" + photo;
    }
}
