package com.example.laith.test.springdata.base;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@MappedSuperclass// this tells hibernate you don't have to create this entity inside the db
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity<ID>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public ID id;

    public String statusCode;

    public boolean isDeleted;

    @CreatedBy
    public String createdBy;

    @CreatedDate
    public LocalDate creationDate;

    @LastModifiedBy
    public String lastModifiedBy;

    @LastModifiedDate
    public LocalDate lastModifiedDate;


}
