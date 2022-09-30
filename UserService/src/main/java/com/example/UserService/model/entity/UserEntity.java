package com.example.UserService.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "account")
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ?
    private Long id;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String userName;
    @Column(name = "file_image")
    private byte[] fileImage;
    private Date birthday;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleEntity> roleEntity = new ArrayList<>();
}
