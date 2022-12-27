
package com.example.laith.test.springdata.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "player")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long number;
    private String position;


    @ManyToOne()
    @JoinColumn(name = "club_id")
   // @JsonManagedReference
    @JsonBackReference
    private Club club;




    public Player(String name, Long number, String position) {
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public Player(String name, Long number, String position, Club club) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.club = club;
    }
}

