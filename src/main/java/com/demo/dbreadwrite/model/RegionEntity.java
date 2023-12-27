package com.demo.dbreadwrite.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "regions_prev")
@ToString
public class RegionEntity {

    @Id
    @GenericGenerator(
            name = "sequence_gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                            value = "_id_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })

    @GeneratedValue(generator = "sequence_gen")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "region_code", nullable = false)
    private Integer regionCode;

    @Column(name = "geo_code")
    private String geoCode;

    @Column(name = "name_bn", nullable = false)
    private String nameBn;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;

//    @Column(name = "created_at", nullable = false, updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

}
