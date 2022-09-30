package com.example.UserService.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@Data
public class BaseEntity {
    @Version
    @Column(name = "version")
    private Long version;
}
