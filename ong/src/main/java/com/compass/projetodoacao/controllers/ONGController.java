package com.compass.projetodoacao.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.projetodoacao.dto.ONGDTO;
import com.compass.projetodoacao.dto.ONGFormDTO;
import com.compass.projetodoacao.dto.ONGPostFormDTO;
import com.compass.projetodoacao.services.ONGService;

@RestController
@RequestMapping("/ongs")
public class ONGController {
	
	@Autowired
	private ONGService ongService;
	
	@GetMapping
	public ResponseEntity<List<ONGDTO>> findAll() {
		return ResponseEntity.ok(ongService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ONGDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(ongService.findById(id));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ONGDTO> save(@RequestBody @Valid ONGPostFormDTO ongDTO, UriComponentsBuilder uriBuilder){
		URI uri = uriBuilder.path("/ongs").buildAndExpand(ongDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(ongService.save(ongDTO));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ONGDTO> update(@PathVariable Integer id, @RequestBody @Valid ONGFormDTO ongDTO){
		return ResponseEntity.ok(ongService.update(id, ongDTO));
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		ongService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}