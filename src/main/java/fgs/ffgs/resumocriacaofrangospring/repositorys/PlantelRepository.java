package fgs.ffgs.resumocriacaofrangospring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fgs.ffgs.resumocriacaofrangospring.models.Plantel;

@Repository
public interface PlantelRepository extends JpaRepository<Plantel, Long>{}
