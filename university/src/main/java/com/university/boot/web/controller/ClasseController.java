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


import com.university.boot.domain.Classe;
import com.university.boot.domain.Professor;
import com.university.boot.service.ClasseService;
import com.university.boot.service.ProfessorService;

@Controller
@RequestMapping("/classe")
public class ClasseController {
	
	@Autowired
	private ClasseService service;
	@Autowired
	private ProfessorService professorService;

	@GetMapping("/cadastrar")
	public String cadastrar(Classe classe) {
		return "classe/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("classes", service.buscarTodos());
		return "classe/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar( Classe classe, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			System.out.println(result);
			return "classe/cadastro";
		}
		
		service.salvar(classe);
		attr.addFlashAttribute("success", "Classe inserida com sucesso.");
		return "redirect:/classe/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("classe", service.buscarPorId(id));
		return "classe/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar( Classe classe, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "classe/cadastro";
		}
		
		service.editar(classe);
		attr.addFlashAttribute("success", "Classe editada com sucesso.");
		return "redirect:/classe/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if (service.classeTemAlunos(id)) {
			model.addAttribute("fail", "Classe não removida. Possui Aluno(s) vinculado(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Classe excluída com sucesso.");
		}
		
		return listar(model);
	}
	
	@ModelAttribute("professores")
	public List<Professor> professores() {
		return professorService.buscarTodos();
	}
	
	
}
