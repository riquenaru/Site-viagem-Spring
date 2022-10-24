package br.com.siteviagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {
	@GetMapping("/")
	public String Home() {
		return "Index";
	}
	
		@GetMapping("/Promocoes")
		public String Promocoes() {
			return "Promocoes";
		}
		
		@GetMapping("/Contato")
		public String Contato() {
			return "Contato";
		}
		
		@GetMapping("/Destino")
		public String Destino() {
			return "Destino";
		}
		
		@GetMapping("/Cadastro")
		public String Cadastro() {
			return "Cadastro";
		}
		
		@GetMapping("/Adm")
		public String Adm() {
			return "Adm";
		}
		
		@GetMapping("/Login")
		public String Login() {
			return "Login";
		}



	

	 
	 
}