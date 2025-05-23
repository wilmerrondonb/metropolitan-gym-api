package com.metropolitan.member.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private String name;
    private String dni;
    private String city;
}
