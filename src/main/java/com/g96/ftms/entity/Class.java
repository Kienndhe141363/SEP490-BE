package com.g96.ftms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "class")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_code")
    private String classCode;

    @Column
    private boolean status = true;

    private String descriptions;

    @Column
    private String admin;

    @Column(updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column
    private LocalDateTime endDate;

    @Column
    private LocalDateTime startDate;

    @OneToMany(mappedBy = "classs",fetch = FetchType.LAZY)
    @JsonBackReference
    List<Schedule> schedules;
}