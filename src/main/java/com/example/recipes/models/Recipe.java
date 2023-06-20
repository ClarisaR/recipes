package com.example.recipes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table (name = "recipes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private String ingredients;
    private String preparation;
    private Date date;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
}
