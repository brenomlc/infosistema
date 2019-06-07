package br.com.infosistema.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.infosistema.model.Veiculo;
import br.com.infosistema.repository.VeiculoRepository;

@RestController
public class VeiculoRestController {

	private VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoRestController(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	@GetMapping("/veiculo/placa/{placa}")
	public ResponseEntity<?> veiculoPorPlaca(@PathVariable String placa) {
		return ResponseEntity.ok().body(veiculoRepository.findByPlaca(placa));
	}
	
	@GetMapping("/veiculo/renavam/{renavam}")
	public ResponseEntity<?> veiculoPorPlaca(@PathVariable Integer renavam) {
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
	
	@PostMapping("/veiculo/novoVeiculo")
	public ResponseEntity<Void> novoVeiculo(@RequestBody Veiculo veiculo){
		veiculoRepository.save(veiculo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/veiculo/placa/{placa}").buildAndExpand(veiculo.getPlaca()).toUri();
		
		return ResponseEntity.created(uri).build();
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
