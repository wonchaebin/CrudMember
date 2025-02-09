package com.example.crudmember.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long id;
    private String name;

    public MemberResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
