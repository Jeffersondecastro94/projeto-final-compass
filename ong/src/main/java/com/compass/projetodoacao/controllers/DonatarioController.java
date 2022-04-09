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

import com.compass.projetodoacao.dto.DonatarioDTO;
import com.compass.projetodoacao.dto.DonatarioFormDTO;
import com.compass.projetodoacao.dto.DonatarioPostFormDTO;
import com.compass.projetodoacao.services.DonatarioService;

@RestController
@RequestMapping("/donatarios")
public class DonatarioController {
	
	@Autowired
	private DonatarioService donatarioService;
	
	@GetMapping
	public ResponseEntity<List<DonatarioDTO>> findAll(){
		return ResponseEntity.ok(donatarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DonatarioDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(donatarioService.findById(id));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<DonatarioDTO> save(@RequestBody @Valid DonatarioPostFormDTO donatarioDTO, UriComponentsBuilder uriBuilder){
		URI uri = uriBuilder.path("/donatarios").buildAndExpand(donatarioDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(donatarioService.save(donatarioDTO));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DonatarioDTO> update(@PathVariable Integer id, @RequestBody @Valid DonatarioFormDTO donatarioDTO){
		return ResponseEntity.ok(donatarioService.update(id, donatarioDTO));
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		donatarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}