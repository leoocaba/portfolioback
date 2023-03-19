/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lc.Controller;

import com.portfolio.lc.Entity.Persona;
import com.portfolio.lc.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leonel Caballero
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaservice;
    
    @GetMapping("/personas/traer") //de la DB al Front
    public List<Persona> getPersona() {
        return ipersonaservice.getPersona();
    }
    
    @PostMapping("/personas/crear") //del Front a la DB
    public String createPersona(@RequestBody Persona persona) {
        ipersonaservice.savePersona(persona);
        return "El usuario fue creado correctamente.";
    }
    
    @DeleteMapping("/personas/borrar/{id}") //borrar personsa de la DB
    public String deletePersona(@PathVariable Long id) {
        ipersonaservice.deletePersona(id);
        return "La personsa fue eliminada correctamente.";
    }
    
    //URI:PUERTO/personas/editar/4/nombre&apellido&img
    @PutMapping("/personas/editar/{id}") //editar una persona de la DB
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String newName,
                               @RequestParam("apellido") String newSurename,
                               @RequestParam("img") String newImg) {
        
        Persona persona = ipersonaservice.findPersona(id);  
        persona.setNombre(newName);
        persona.setApellido(newSurename);
        persona.setImg(newImg);
        
        ipersonaservice.savePersona(persona);
        
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil") 
    public Persona findPersona(Long id) {
        return ipersonaservice.findPersona(id);
    }
}
