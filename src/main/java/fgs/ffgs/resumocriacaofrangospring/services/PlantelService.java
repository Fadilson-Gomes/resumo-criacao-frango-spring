package fgs.ffgs.resumocriacaofrangospring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fgs.ffgs.resumocriacaofrangospring.dto.PlantelDto;
import fgs.ffgs.resumocriacaofrangospring.dto.VerPlantelDto;
import fgs.ffgs.resumocriacaofrangospring.models.Criador;
import fgs.ffgs.resumocriacaofrangospring.models.Plantel;
import fgs.ffgs.resumocriacaofrangospring.repositorys.PlantelRepository;
import jakarta.transaction.Transactional;

@Service
public class PlantelService {

	@Autowired
	PlantelRepository plantelRepository;
	
	@Autowired	
	CriadorService criadorService;
	
	@Transactional
	public Object save(PlantelDto plantelDto) {
		
		Optional<Criador> criadorOptional = criadorService.findById(plantelDto.idCriador());
		
		if(!criadorOptional.isPresent()) {
			return null;
		}
		
		var plantel = new Plantel();
		
		plantel.setDataChegadaPinto(plantelDto.dataChegadaPinto());
		
		plantel.setKgTotal(plantelDto.kgTotal());
		
		plantel.setKgTotalDeUm(plantelDto.kgTotalDeUm());
		
		plantel.setDispesaTotal(plantelDto.dispesaTotal());
		
		plantel.setLucroSoComDeUm(plantelDto.lucroSoComDeUm());
		
		plantel.setLucroSemDispesa(plantelDto.lucroSemDispesa());

		plantel.setDeZE(plantelDto.deZE());
		
		plantel.setTotalApurado(plantelDto.totalApurado());
		
		plantel.setCriador(criadorOptional.get());
		
		var pantel = plantelRepository.save(plantel);;
		
		var verPlantelDto = new VerPlantelDto(pantel.getIdPlantel(), pantel.getKgTotal(), pantel.getKgTotalDeUm(), pantel.getDispesaTotal(), 
										pantel.getLucroSoComDeUm(), pantel.getLucroSemDispesa(), pantel.getDeZE(), pantel.getTotalApurado(), pantel.getCriador().getNomeCriador());

		return verPlantelDto;
	}
	
	@Transactional
	public Object updadePlantel(Long idPlantel, PlantelDto plantelDto) {
		
		Optional<Plantel> plantelOptional = plantelRepository.findById(idPlantel);
		
		if(!plantelOptional.isPresent()) {
			return "Plantel não encotrado!";
		}
		
		Optional<Criador> criadorOptional = criadorService.findById(plantelDto.idCriador());
		
		if(!criadorOptional.isPresent()) {
			return "Criador não encotrado!";
		}
	
		var plantel = plantelOptional.get();
		
		plantel.setDataChegadaPinto(plantelDto.dataChegadaPinto());
		
		plantel.setKgTotal(plantelDto.kgTotal());
		
		plantel.setKgTotalDeUm(plantelDto.kgTotalDeUm());
		
		plantel.setDispesaTotal(plantelDto.dispesaTotal());
		
		plantel.setLucroSoComDeUm(plantelDto.lucroSoComDeUm());
		
		plantel.setLucroSemDispesa(plantelDto.lucroSemDispesa());

		plantel.setDeZE(plantelDto.deZE());
		
		plantel.setTotalApurado(plantelDto.totalApurado());
		
		plantel.setCriador(criadorOptional.get());
		
		var pantel = plantelRepository.save(plantel);
		
		var verPlantelDto = new VerPlantelDto(pantel.getIdPlantel(), pantel.getKgTotal(), pantel.getKgTotalDeUm(), pantel.getDispesaTotal(), 
				pantel.getLucroSoComDeUm(), pantel.getLucroSemDispesa(), pantel.getDeZE(), pantel.getTotalApurado(), pantel.getCriador().getNomeCriador());
		
		return verPlantelDto;
	} 
	
	
	public Optional<Plantel> findById(Long id){
		
		return  plantelRepository.findById(id);
		
	}
	
	public VerPlantelDto mostraPlatntelPorId(Long id){
		
		Optional<Plantel> plantelOptional =  plantelRepository.findById(id);
		
		if(!plantelOptional.isPresent()) {
			return null;
		}
		
		var pantel =  plantelOptional.get();
		
		var verPlantelDto = new VerPlantelDto(pantel.getIdPlantel(), pantel.getKgTotal(), pantel.getKgTotalDeUm(), pantel.getDispesaTotal(), 
				pantel.getLucroSoComDeUm(), pantel.getLucroSemDispesa(), pantel.getDeZE(), pantel.getTotalApurado(), pantel.getCriador().getNomeCriador());
		
		return verPlantelDto;
	}
	
	
	
	public List<VerPlantelDto> findAll(){
		List<Plantel> listaPlantel =  plantelRepository.findAll();
		List<VerPlantelDto> listaPlantelDto = new ArrayList<VerPlantelDto>();
		
		for(Plantel pantel:listaPlantel) {

			var verPlantelDto = new VerPlantelDto(pantel.getIdPlantel(), pantel.getKgTotal(), pantel.getKgTotalDeUm(), pantel.getDispesaTotal(), 
					pantel.getLucroSoComDeUm(), pantel.getLucroSemDispesa(), pantel.getDeZE(), pantel.getTotalApurado(), pantel.getCriador().getNomeCriador());
			listaPlantelDto.add(verPlantelDto);
		}
		
		return listaPlantelDto;
		
	}
	
	@Transactional
	public Object deletePlantel(long idPlantel) {
		
		Optional<Plantel> plantelOptional = this.findById(idPlantel);
		if(!plantelOptional.isPresent()) {
			return null;
		}
		
		plantelRepository.delete(plantelOptional.get());
		
		return "Plantel deletado com secesso.";
		
		
		
	}
	
	
	
}
