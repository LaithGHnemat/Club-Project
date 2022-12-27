package com.example.laith.test.springdata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class PlayerDTO implements P {




   // Object mm= new Object();
    private Long id;
    private String name;
    private Long number;
    private String position;
    private Long clubId;

    static Integer dec=1;

    public PlayerDTO() {
        dec=dec+1;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", position='" + position + '\'' +
                ", clubId=" + clubId +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDTO playerDTO = (PlayerDTO) o;
        return Objects.equals(id, playerDTO.id) && Objects.equals(name, playerDTO.name) && Objects.equals(number, playerDTO.number) && Objects.equals(position, playerDTO.position) && Objects.equals(clubId, playerDTO.clubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, position, clubId);
    }

    // the first type of  polymorphism called overLoading(static, compile time polymorphism)
     @Override
    public  void print(){
        System.out.println("mmmm");
    }
    public  void print(int x){}
    public  void print(int x,int y){}
    public  void print(int x,String y){}


    public  void print(String x,int y){}
    public  final void wwwwwwwwwwww(String x,int y){}

    // the first type of  polymorphism called overriding(dynamic, run time polymorphism)

}
