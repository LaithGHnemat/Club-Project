package com.example.laith.test.springdata.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "club")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    private Double budget;
    @Transient // it means we don't want to add this attribute in our DB
    @JsonIgnore
    private Boolean created;


    @OneToMany(mappedBy = "club", cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST })
  ///  @JsonBackReference
    @JsonManagedReference
    private List<Player> players;




    public Club(String name, String nationality, double budget) {
        this.name = name;
        this.nationality = nationality;
        this.budget = budget;
    }
}
