package com.superpets.petservice;

import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }
}