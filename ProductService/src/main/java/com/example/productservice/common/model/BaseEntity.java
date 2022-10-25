package com.example.productservice.common.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@Data
@MappedSuperclass
public class BaseEntity {
    @Version
    @Column(name = "version")
    private Long version;

}
