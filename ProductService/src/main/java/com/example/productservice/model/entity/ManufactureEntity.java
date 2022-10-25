package com.example.productservice.model.entity;

import com.example.productservice.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Manufacture")
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManufactureEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "PhoneNumber")
    private String phoneNumber;

//    @OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<DrugEntity> drugs = new ArrayList<>();
}
