package fgs.ffgs.resumocriacaofrangospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fgs.ffgs.resumocriacaofrangospring.dto.CriadorDto;
import fgs.ffgs.resumocriacaofrangospring.dto.VerCriadorDto;
import fgs.ffgs.resumocriacaofrangospring.services.CriadorService;
import jakarta.validation.Valid;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/criador")
public class CriadorController {

	@Autowired
	CriadorService criadorService;
	
	@PostMapping
	public ResponseEntity<Object> saveCriador(@RequestBody @Valid CriadorDto criadorDto ){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(criadorService.save(criadorDto));
	}
	
	@GetMapping
	public ResponseEntity<List<VerCriadorDto>> getAllCriador(){
		return ResponseEntity.status(HttpStatus.OK).body(criadorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUmCriador(@PathVariable(value = "id") Short idCriador){
		
		VerCriadorDto verCriadorDto = criadorService.mostraCriadorPorId(idCriador);
		
		if(verCriadorDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Criador não Encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(verCriadorDto);
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity<Object> upadateCriador(@PathVariable(value = "id") Short idCriador, @RequestBody @Valid  CriadorDto criadorDto){
		
		Object dataUpdate = criadorService.upadateCriador(idCriador, criadorDto);
		
		if (dataUpdate == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Criador não Encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(dataUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deledeCriador (@PathVariable(value = "id") Short idCriador){
		
		
		Object dataDelete = criadorService.delete(idCriador);
		
		if(dataDelete == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Criador não Encontrado");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body((String) dataDelete);
	}
	
}
