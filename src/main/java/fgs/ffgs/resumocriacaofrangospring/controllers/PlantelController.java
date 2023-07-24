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

import fgs.ffgs.resumocriacaofrangospring.dto.PlantelDto;
import fgs.ffgs.resumocriacaofrangospring.dto.VerPlantelDto;
import fgs.ffgs.resumocriacaofrangospring.services.CriadorService;
import fgs.ffgs.resumocriacaofrangospring.services.PlantelService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/plantel")
public class PlantelController {
	
	@Autowired
	PlantelService plantelService;
	
	@Autowired	
	CriadorService criadorService;
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid PlantelDto plantelDto){
		
		
		Object verPlantelDto  = plantelService.save(plantelDto);
		
		if(verPlantelDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Criador não encotrado!");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(verPlantelDto);
	}
	
	@GetMapping
	public ResponseEntity<List<VerPlantelDto>> getAllPlantel(){
		return ResponseEntity.status(HttpStatus.OK).body(plantelService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUmPlantel(@PathVariable(value = "id") long idPlantel){
		
		VerPlantelDto verPlantelDto = plantelService.mostraPlatntelPorId(idPlantel);
		
		if(verPlantelDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plantel não encotrado!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(verPlantelDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updadePlantel(@PathVariable(value = "id") Long idPlantel,@RequestBody @Valid PlantelDto plantelDto){
		
		Object plantel = plantelService.updadePlantel(idPlantel, plantelDto);
		
		if(plantel instanceof String) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body((String)plantel);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(plantel);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePlantel(@PathVariable(value = "id") long idPlantel){
		
		Object plantel= plantelService.deletePlantel(idPlantel);
		
		if(plantel == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plantel não encotrado!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body((String) plantel);
	}
	
	
}