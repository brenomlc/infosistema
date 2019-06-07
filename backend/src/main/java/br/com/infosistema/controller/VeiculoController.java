package br.com.infosistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/veiculo/{id}")
	public ResponseEntity<?> veiculoPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(veiculoRepository.findById(id));
	}
	
	@GetMapping("/veiculo")
	public ResponseEntity<?> veiculoAll() {
		return ResponseEntity.ok().body(veiculoRepository.findAll());
	}
	
	@GetMapping("/veiculo/placa/{placa}")
	public ResponseEntity<?> veiculoPorPlaca(@PathVariable String placa) {
		return ResponseEntity.ok().body(veiculoRepository.findByPlaca(placa));
	}
	
	@GetMapping("/veiculo/renavam/{renavam}")
	public ResponseEntity<?> veiculoPorPlaca(@PathVariable Long renavam) {
		return ResponseEntity.ok().body(veiculoRepository.findByRenavam(renavam));
	}
	
	@GetMapping("/veiculo/modelo/{modelo}")
	public ResponseEntity<List<Veiculo>> veiculoPorModelo(@PathVariable String modelo) {
		return ResponseEntity.ok().body(veiculoRepository.findByModelo(modelo));
	}
	
	@GetMapping("/veiculo/modelo/{marca}")
	public ResponseEntity<List<Veiculo>> veiculoPorMarca(@PathVariable String marca) {
		return ResponseEntity.ok().body(veiculoRepository.findByMarca(marca));
	}
	
	@GetMapping("/veiculo/ano/{ano}")
	public ResponseEntity<List<Veiculo>> veiculoPorAno(@PathVariable Integer ano) {
		return ResponseEntity.ok().body(veiculoRepository.findByAno(ano));
	}
	
	@PostMapping("/veiculo")
	public void salvarVeiculo(@RequestBody Veiculo veiculo){
		veiculoRepository.save(veiculo);
	}
	
	@DeleteMapping("/veiculo/{id}")
	public ResponseEntity<Void> removerVeiculo(@PathVariable Long id){
		veiculoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/veiculo/update/{id}")
	public ResponseEntity<Veiculo> updateVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long id){
		veiculo.setId(id);
		
		veiculoRepository.save(veiculo);
		
		return ResponseEntity.noContent().build();
	}
}
