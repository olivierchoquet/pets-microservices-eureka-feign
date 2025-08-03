package com.superpets.missionservice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
// auto create table
@Table(name="Missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String difficulty; // Ex: Easy, Medium, Hard
    private Long assignedPetId;
}