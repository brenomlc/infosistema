package br.com.infosistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infosistema.model.Veiculo; 

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	Veiculo findByPlaca(String placa);
	
	Veiculo findByRenavam(Long renavam);
	
	List<Veiculo> findByModelo(String modelo);
	
	List<Veiculo> findByAno(Integer ano);
	
	List<Veiculo> findByMarca(String marca);
}
