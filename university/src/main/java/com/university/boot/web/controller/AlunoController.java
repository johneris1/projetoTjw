package com.university.boot.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.university.boot.domain.Aluno;
import com.university.boot.domain.Classe;
import com.university.boot.domain.UF;
import com.university.boot.service.AlunoService;
import com.university.boot.service.ClasseService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	@Autowired
	private ClasseService classe;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "aluno/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("alunos", service.buscarTodos());
		return "aluno/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar( Aluno aluno, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "aluno/cadastro";
		}
		
		service.salvar(aluno);
		attr.addFlashAttribute("success", "Aluno inserido com sucesso.");
		return "redirect:/aluno/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("aluno", service.buscarPorId(id));
		return "aluno/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar( Aluno aluno, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "aluno/cadastro";
		}
		
		service.editar(aluno);
		attr.addFlashAttribute("success", "Aluno editado com sucesso.");
		return "redirect:/aluno/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("success", "Aluno removido com sucesso.");
		return "redirect:/aluno/listar";
	}	
	
	
	@ModelAttribute("classes")
	public List<Classe> classes() {
		return classe.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
