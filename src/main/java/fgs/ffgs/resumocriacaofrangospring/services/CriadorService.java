package fgs.ffgs.resumocriacaofrangospring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fgs.ffgs.resumocriacaofrangospring.dto.CriadorDto;
import fgs.ffgs.resumocriacaofrangospring.dto.VerCriadorDto;
import fgs.ffgs.resumocriacaofrangospring.dto.VerPlantelSemCriadorDto;
import fgs.ffgs.resumocriacaofrangospring.models.Criador;
import fgs.ffgs.resumocriacaofrangospring.models.Plantel;
import fgs.ffgs.resumocriacaofrangospring.repositorys.CriadorRepository;
import jakarta.transaction.Transactional;

@Service
public class CriadorService {

	@Autowired
	CriadorRepository criadorRepository;
	
	
	@Transactional
	public Criador save(CriadorDto criadorDto) {
		
		Criador criador = new Criador(criadorDto.nomeCriador());
		
		return criadorRepository.save(criador);
	}
	
	@Transactional
	public Object upadateCriador(short idCriador, CriadorDto criadorDto)  {
		
		Optional<Criador> criadorOptional = this.findById(idCriador);
		
		if(!criadorOptional.isPresent()) {
			return null;
		}
		
		Criador  criador = criadorOptional.get();
		
		criador.setNomeCriador(criadorDto.nomeCriador());
		
		if(criador.getPlantel().isEmpty()) {
			criador.setPlantel(null);
		}
		
		return criadorRepository.save(criador);
	}
	
	
	
	public VerCriadorDto mostraCriadorPorId(Short id){
		
		Optional<Criador> criadorOptional = this.findById(id);
		
		if(!criadorOptional.isPresent()) {
			return null;
		}
		
		Criador criador = criadorOptional.get();
		
		VerCriadorDto verCriadorDto; 
		
		if(!criador.getPlantel().isEmpty()) {
		
			List<VerPlantelSemCriadorDto> verPlantelSemCriadorDtos = new ArrayList<>();
		
			for(Plantel p : criador.getPlantel()) {
				var verPlantelSemCriadorDto = new VerPlantelSemCriadorDto(p.getIdPlantel(), p.getKgTotal(), p.getKgTotalDeUm(), p.getDispesaTotal(),
						p.getLucroSoComDeUm(), p.getLucroSemDispesa(),  p.getDeZE(), p.getTotalApurado());
				
				verPlantelSemCriadorDtos.add(verPlantelSemCriadorDto);
			}
			
			verCriadorDto = new VerCriadorDto(criador.getIdCriador(), criador.getNomeCriador(), verPlantelSemCriadorDtos);
			
		}else {
			
			 verCriadorDto = new VerCriadorDto(criador.getIdCriador(), criador.getNomeCriador(), null);
			 
		}
		return verCriadorDto;
	}
	
	
	public Optional<Criador> findById(Short id){
		
		return criadorRepository.findById(id);
		
	}
	
	public List<VerCriadorDto> findAll() {
		
		List<Criador> listaCriador = criadorRepository.findAll();
		List<VerCriadorDto> listaCriadorDto = new ArrayList<>();
		
		listaCriador.forEach(e -> {
			
			VerCriadorDto verCriadorDto; 
			
			if (!e.getPlantel().isEmpty()) {
				
				List<VerPlantelSemCriadorDto> verPlantelSemCriadorDtos = new ArrayList<>();
				
				for (Plantel p : e.getPlantel()) {
					
					var verPlantelSemCriadorDto = new VerPlantelSemCriadorDto(p.getIdPlantel(), p.getKgTotal(), p.getKgTotalDeUm(), p.getDispesaTotal(),
							p.getLucroSoComDeUm(), p.getLucroSemDispesa(),  p.getDeZE(), p.getTotalApurado());
					
					verPlantelSemCriadorDtos.add(verPlantelSemCriadorDto);
					
				}
				
				verCriadorDto = new VerCriadorDto(e.getIdCriador(), e.getNomeCriador(), verPlantelSemCriadorDtos);
				
			}else {
				
				verCriadorDto = new VerCriadorDto(e.getIdCriador(), e.getNomeCriador(), null);
				
			}
			
			listaCriadorDto.add(verCriadorDto);
		});
		
		return listaCriadorDto;
	}
	
	
	@Transactional
	public Object delete(Short idCriador) {
		
		Optional<Criador> criadorOptional = this.findById(idCriador);
		
		if(!criadorOptional.isPresent()) {
			return null;
		}
		
		criadorRepository.delete(criadorOptional.get());
		
		return "Criador apagado com sucesso!";
		
	}
}
