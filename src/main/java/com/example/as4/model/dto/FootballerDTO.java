package com.example.as4.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FootballerDTO {
    private Long id;
    private String firstName;
    private String surName;
    private int age;
    private String position;
    private String club;
    private int marketValue;
}