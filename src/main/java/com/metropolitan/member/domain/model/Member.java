package com.metropolitan.member.domain.model;

import lombok.Value;

@Value
public class Member {
    long id;
    String name;
    String dni;
    String city;
}
