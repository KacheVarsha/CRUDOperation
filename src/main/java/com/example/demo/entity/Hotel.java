package com.example.demo.entity;

import com.example.demo.enums.HotelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double ratings;
    private int stars;
    private HotelType hotelType;

    @OneToMany(targetEntity = Room.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "h_fk", referencedColumnName = "id")
    private List<Room> rooms = new ArrayList<>();
}
