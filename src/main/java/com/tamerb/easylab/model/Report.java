package com.tamerb.easylab.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(length = 64)
    private String photos;

    public Report() {

    }
    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;

        return "/user-photos/" + id + "/" + photos;
    }
}
