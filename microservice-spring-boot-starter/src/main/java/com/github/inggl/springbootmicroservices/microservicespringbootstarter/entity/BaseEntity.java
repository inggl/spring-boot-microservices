package com.github.inggl.springbootmicroservices.microservicespringbootstarter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    protected UUID id;

    @CreatedBy
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected String createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected String lastModifiedDate;
}
