package br.com.siteviagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.siteviagens.model.Passagem;
import br.com.siteviagens.repository.PassagemRepository;

@Controller
@RequestMapping("/passagem")
public class PassagemController {

	@Autowired
	private PassagemRepository passagemRepository;


// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("passagem/listar.html");

		List<Passagem> passagem = passagemRepository.findAll();
		modelAndView.addObject("passagem", passagem);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("passagem/cadastro");

		modelAndView.addObject("passagem", new Passagem());

		return modelAndView;
	}

	@GetMapping("/{idPassagem}")
	public ModelAndView detalhar(@PathVariable Long idPassagem) {
		ModelAndView modelAndView = new ModelAndView("passagem/detalhar.html");

		@SuppressWarnings("deprecation")
		Passagem passagem = passagemRepository.getOne(idPassagem);
		modelAndView.addObject("passagem", passagem);
		

		return modelAndView;
	}

	@GetMapping("/{idPassagem}/excluir")
	public ModelAndView excluir(@PathVariable Long idPassagem) {
		ModelAndView modelAndView = new ModelAndView("redirect:/passagem");


		return modelAndView;
	}

	@GetMapping("/{idPassagem}/editar")
	public ModelAndView editar(@PathVariable Long idPassagem) {
		ModelAndView modelAndView = new ModelAndView("passagem/edicao");

		@SuppressWarnings("deprecation")
		Passagem passagem = passagemRepository.getOne(idPassagem);
		modelAndView.addObject("passagem", passagem);

		return modelAndView;
	}

	@PostMapping("/{idPassagem}/editar")
	public ModelAndView editar(Passagem passagem) {
		ModelAndView modelAndView = new ModelAndView("redirect:/passagem");

		passagemRepository.save(passagem);

		return modelAndView;
	}

}