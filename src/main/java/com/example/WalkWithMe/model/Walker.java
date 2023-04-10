package com.example.WalkWithMe.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Walker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String surname;

    @JsonManagedReference
    @OneToMany(mappedBy = "walker",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Reservation> reservation;
}
