package br.com.infosistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.infosistema.model.Veiculo;
import br.com.infosistema.repository.VeiculoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VeiculoController {

	private VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoController(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	@GetMapping("/veiculo")
	public ResponseEntity<?> veiculoAll() {
		return ResponseEntity.ok().body(veiculoRepository.findAll());
	}
	
	@GetMapping("/veiculo/{id}")
	public ResponseEntity<?> veiculoPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(veiculoRepository.findById(id));
	}
	
	@PostMapping("/veiculo")
	public void salvarVeiculo(@RequestBody Veiculo veiculo){
		veiculoRepository.save(veiculo);
	}
	
	@DeleteMapping("/veiculo/{id}")
	public void removerVeiculo(@PathVariable Long id){
		veiculoRepository.deleteById(id);
	}
}
