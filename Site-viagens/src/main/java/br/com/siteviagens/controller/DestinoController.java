package br.com.siteviagens.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.siteviagens.model.Destino;
import br.com.siteviagens.repository.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("destino/listar.html");

		List<Destino> destino = destinoRepository.findAll();
		modelAndView.addObject("destino", destino);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("destino/cadastro");

		modelAndView.addObject("destino", new Destino());

		return modelAndView;
	}

	

	 @GetMapping("/{idDestino}")
	    public ModelAndView detalhar(@PathVariable Long idDestino) {
	        ModelAndView modelAndView = new ModelAndView("destino/detalhar.html");

	        @SuppressWarnings("deprecation")
			Destino destino = destinoRepository.getOne(idDestino);
	        modelAndView.addObject("destino", destino);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{idDestino}/excluir")
	    public ModelAndView excluir(@PathVariable Long idDestino) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/destino");

	        destinoRepository.deleteById(idDestino);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{idDestino}/editar")
	    public ModelAndView editar(@PathVariable Long idDestino) {
	        ModelAndView modelAndView = new ModelAndView("destino/edicao");

	        @SuppressWarnings("deprecation")
			Destino destino = destinoRepository.getOne(idDestino);
	        modelAndView.addObject("destino", destino);

	        return modelAndView;
	    }
	
	 
	 @PostMapping("/{idDestino}/editar")
	    public ModelAndView editar(Destino destino) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/destino");

	        destinoRepository.save(destino);

	        return modelAndView;
	    }
	 
	 
}