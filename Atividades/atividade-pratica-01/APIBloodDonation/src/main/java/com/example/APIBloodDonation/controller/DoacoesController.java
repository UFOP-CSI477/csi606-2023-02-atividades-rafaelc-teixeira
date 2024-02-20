package com.example.APIBloodDonation.controller;

import com.example.APIBloodDonation.dto.DoacoesDTO;
import com.example.APIBloodDonation.service.DoacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doacoes")
public class DoacoesController {

    @Autowired
    private DoacoesService doacaoService;

    @PostMapping
    public ResponseEntity createDonation(@RequestBody DoacoesDTO doacaoDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(doacaoService.createDonation(doacaoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateDonation(@PathVariable(value = "id") Long id, @RequestBody DoacoesDTO doacaoDTO) throws Exception {
        return ResponseEntity.ok().body(doacaoService.updateDonation(id, doacaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDonation(@PathVariable(value = "id") Long id) {
        doacaoService.deleteDonation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity getAllDonations() {
        return ResponseEntity.ok().body(doacaoService.getAllDonations());
    }

    @GetMapping("/{id}")
    public ResponseEntity getDonationById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(doacaoService.getDonationById(id));
    }

}
