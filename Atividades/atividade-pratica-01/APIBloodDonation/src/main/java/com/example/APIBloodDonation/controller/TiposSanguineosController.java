package com.example.APIBloodDonation.controller;

import com.example.APIBloodDonation.dto.TiposSanguineosDTO;
import com.example.APIBloodDonation.service.TiposSanguineosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos-sanguineos")
public class TiposSanguineosController {

    @Autowired
    private TiposSanguineosService tipoSanguineoService;

    @PostMapping
    public ResponseEntity createBloodType(@RequestBody TiposSanguineosDTO tipoSanguineoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoSanguineoService.createBloodType(tipoSanguineoDTO));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity updateBloodType(@PathVariable(value = "id") Long id, @RequestBody TiposSanguineosDTO tipoSanguineoDTO) throws Exception {
        return ResponseEntity.ok().body(tipoSanguineoService.updateBloodType(id, tipoSanguineoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBloodType(@PathVariable(value = "id") Long id) {
        tipoSanguineoService.deleteBloodType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity getAllBloodTypes() {
        return ResponseEntity.ok().body(tipoSanguineoService.getAllBloodTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity getBloodTypeById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(tipoSanguineoService.getBloodTypeById(id));
    }
}
