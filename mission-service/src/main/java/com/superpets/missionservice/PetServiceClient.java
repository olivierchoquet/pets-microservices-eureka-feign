// Dans le microservice 'mission', pour appeler 'pet-service'
package com.superpets.missionservice;

//import com.example.mission.models.Pet; // Si vous avez un modèle partagé

import com.superpets.DTO.PetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pet-service") // 'pet-service' est le nom enregistré dans Eureka
public interface PetServiceClient {

    @GetMapping("/pets/{id}")
    PetDTO getPetById(@PathVariable("id") Long id);

    // Autres méthodes pour interagir avec pet-service
    // @PostMapping("/pets")
    // Pet createPet(@RequestBody Pet newPet);
}
