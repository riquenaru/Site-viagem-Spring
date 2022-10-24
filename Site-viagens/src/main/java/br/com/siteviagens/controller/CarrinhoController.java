package br.com.siteviagens.controller;


import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.siteviagens.model.Carrinho;
import br.com.siteviagens.repository.CarrinhoRepository;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	//@Autowired
	//private PassagemRepository passagemRepository;
	
	//@Autowired
	//private UsuarioRepository usuarioRepository;

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("carrinho/listar.html");

		List<Carrinho> carrinho = carrinhoRepository.findAll();
		modelAndView.addObject("carrinho", carrinho);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("carrinho/cadastro");

		modelAndView.addObject("carrinho", new Carrinho());

		return modelAndView;
	}

	

	 @GetMapping("/{idCarrinho}")
	    public ModelAndView detalhar(@PathVariable Long idCarrinho) {
	        ModelAndView modelAndView = new ModelAndView("carrinho/detalhar.html");

	        @SuppressWarnings("deprecation")
			Carrinho carrinho = carrinhoRepository.getOne(idCarrinho);
	        modelAndView.addObject("carrinho", carrinho);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{idCarrinho}/excluir")
	    public ModelAndView excluir(@PathVariable Long idCarrinho) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");

	       carrinhoRepository.deleteById(idCarrinho);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{idCarrinho}/editar")
	    public ModelAndView editar(@PathVariable Long idCarrinho) {
	        ModelAndView modelAndView = new ModelAndView("carrinho/edicao");

	        @SuppressWarnings("deprecation")
			Carrinho carrinho = carrinhoRepository.getOne(idCarrinho);
	        modelAndView.addObject("carrinho", carrinho);

	        return modelAndView;
	    }
	
	 
	 @PostMapping("/{idCarrinho}/editar")
	    public ModelAndView editar(Carrinho carrinho) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");

	        carrinhoRepository.save(carrinho);

	        return modelAndView;
	    }
	 
	 
}