package br.com.infosistema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.infosistema.model.Veiculo;
import br.com.infosistema.repository.VeiculoRepository;

@Controller(value = "/frontend")
public class VeiculoTemplateController {
	
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoTemplateController(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	@RequestMapping(value="/novo", method = RequestMethod.GET)
	public ModelAndView novoVeiculo(Model model) {
		model.addAttribute("veiculo", new Veiculo());
		
		return new ModelAndView("novo");
	}
	
	@RequestMapping(value="/veiculo/salvarVeiculo", method= RequestMethod.POST)
	public ModelAndView salvarVeiculo(@ModelAttribute @Valid Veiculo veiculo, final BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		veiculoRepository.save(veiculo);
		
		ModelAndView modelAndView = new ModelAndView("redirect:/frontend/novo");
		
		redirectAttributes.addFlashAttribute("msg_resultado", "Veiculo salvo com sucesso");
		
		return modelAndView;
	}
}
