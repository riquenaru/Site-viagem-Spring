package br.com.siteviagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.siteviagens.model.Usuario;
import br.com.siteviagens.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("usuario/listar.html");

		List<Usuario> usuario = usuarioRepository.findAll();
		modelAndView.addObject("usuario", usuario);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("usuario/cadastro");

		modelAndView.addObject("usuario", new Usuario());

		return modelAndView;
	}

	@GetMapping("/{idUsuario}")
	public ModelAndView detalhar(@PathVariable Long idUsuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/detalhar.html");

		@SuppressWarnings("deprecation")
		Usuario usuario = usuarioRepository.getOne(idUsuario);
		modelAndView.addObject("usuario", usuario);

		return modelAndView;
	}

	@GetMapping("/{idusuario}/excluir")
	public ModelAndView excluir(@PathVariable Long idUsuario) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuario");

		usuarioRepository.deleteById(idUsuario);

		return modelAndView;
	}

	@GetMapping("/{idUsuario}/editar")
	public ModelAndView editar(@PathVariable Long idUsuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/edicao");

		@SuppressWarnings("deprecation")
		Usuario usuario = usuarioRepository.getOne(idUsuario);
		modelAndView.addObject("usuario", usuario);

		return modelAndView;
	}

	@PostMapping("/{idUsuario}/editar")
	public ModelAndView editar(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuario");

		usuarioRepository.save(usuario);

		return modelAndView;
	}

}