package com.example.recipes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    @NotNull
    private String ingredients;
    @NotNull
    private String preparation;
    @NotNull
    private Date date;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
}
