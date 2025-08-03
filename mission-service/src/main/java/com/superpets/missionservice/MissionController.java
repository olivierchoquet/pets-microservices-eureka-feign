package com.superpets.missionservice;

import com.superpets.DTO.PetDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionRepository missionRepository;
    private final PetServiceClient petServiceClient;

    public MissionController(MissionRepository missionRepository, PetServiceClient petServiceClient) {

        this.missionRepository = missionRepository;
        // for feign call
        this.petServiceClient = petServiceClient;
    }

    @GetMapping
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mission getMissionById(@PathVariable Long id) {
        return missionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Mission createMission(@RequestBody Mission mission) {
        return missionRepository.save(mission);
    }

    @PutMapping("/{missionId}/assign-pet/{petId}")
    public Mission assignPetToMission(@PathVariable Long missionId, @PathVariable Long petId) {
        // Utilise le client Feign pour appeler pet-service
        PetDTO petDetails = petServiceClient.getPetById(petId);

        if (petDetails == null) {
            throw new RuntimeException("Pet not found: " + petId);
        }
        System.out.println("Assigning pet to mission: " + missionId + " to " + petId + " pet name: " + petDetails.getName());

        // ... logique métier avec les détails de l'animal et le repository local
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new RuntimeException("Mission not found"));
        mission.setAssignedPetId(petId);
        return missionRepository.save(mission);
    }
}