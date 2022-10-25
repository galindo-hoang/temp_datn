package com.example.productservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Category")
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    // testing naturalId
    private String name;
    @Column(name = "Image")
    private byte[] image;
    @ManyToMany(mappedBy = "categories")
    private Set<DrugEntity> drugs = new HashSet<>();
}
