package com.example.APIBloodDonation.controller;

import com.example.APIBloodDonation.dto.CidadesDTO;
import com.example.APIBloodDonation.service.CidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadesController {

    @Autowired
    private CidadesService cidadesService;

    @PostMapping
    public ResponseEntity createCity(@RequestBody CidadesDTO cidadeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadesService.createCity(cidadeDTO));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity updateCity(@PathVariable(value = "id") Long id, @RequestBody CidadesDTO cidadeDTO) throws Exception {
        return ResponseEntity.ok().body(cidadesService.updateCity(id, cidadeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable(value = "id") Long id) {
        cidadesService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity getAllCitys() {
        return ResponseEntity.ok().body(cidadesService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCityById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(cidadesService.getCityById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity getCityByName(@PathVariable(value = "nome") String nome) throws Exception {
        return ResponseEntity.ok().body(cidadesService.getCityByName(nome));
    }

}
