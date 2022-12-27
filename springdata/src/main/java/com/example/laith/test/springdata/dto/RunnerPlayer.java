package com.example.laith.test.springdata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class RunnerPlayer implements P{

    private Long id;
    private String name;
    private Long number;
    private String position;
    private Long clubId;

    public RunnerPlayer() {
    }

    @Override
    public void print() {
        System.out.println("the second is here can you see it ");
    }
}
