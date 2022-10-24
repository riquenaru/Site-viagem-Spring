package br.com.siteviagens.controller;

import java.util.List;	


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import br.com.siteviagens.model.Login;
import br.com.siteviagens.repository.LoginRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("login/listar.html");

		List<Login> login = loginRepository.findAll();
		modelAndView.addObject("login", login);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("login/cadastro");

		modelAndView.addObject("login", new Login());

		return modelAndView;
	}

	

	 @GetMapping("/{id}")
	    public ModelAndView detalhar(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("login/detalhar.html");

	        @SuppressWarnings("deprecation")
			Login login = loginRepository.getOne(id);
	        modelAndView.addObject("login", login);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id}/excluir")
	    public ModelAndView excluir(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/login");

	        loginRepository.deleteById(id);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id}/editar")
	    public ModelAndView editar(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("login/edicao");

	        @SuppressWarnings("deprecation")
			Login login = loginRepository.getOne(id);
	        modelAndView.addObject("login", login);

	        return modelAndView;
	    }
	
	 
	 @PostMapping("/{id}/editar")
	    public ModelAndView editar(Login login) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/login");

	        loginRepository.save(login);

	        return modelAndView;
	    }
	 
	 
}