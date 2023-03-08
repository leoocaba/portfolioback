/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Leonel Caballero
 */

@Getter
@Setter
@Entity
public class Persona {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El nombre es muy corto o muy largo")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El nombre es muy corto o muy largo")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El nombre es muy corto o muy largo")
    private String img;
}
