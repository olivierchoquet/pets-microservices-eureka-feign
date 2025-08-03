package com.superpets.petservice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// auto create table
@Table(name="PETS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species; // Ex: Cat, Dog, Hamster
    private String superpower; // Ex: Flight, Super Strength, Invisibility
    private int powerLevel; // 1-100
}