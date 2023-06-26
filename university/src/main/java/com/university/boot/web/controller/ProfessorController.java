package com.university.boot.web.controller;




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

import com.university.boot.domain.Professor;
import com.university.boot.domain.UF;
import com.university.boot.service.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;

	@GetMapping("/cadastrar")
	public String cadastrar(Professor professor) {
		return "professor/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("professores", professorService.buscarTodos());
		return "professor/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Professor professor, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "professor/cadastro";
		}
		
		professorService.salvar(professor);
		attr.addFlashAttribute("success", "Professor inserido com sucesso.");
		return "redirect:/professor/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("professor", professorService.buscarPorId(id));
		return "professor/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar( Professor professor, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "professor/cadastro";
		}	
		
		professorService.editar(professor);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/professor/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (professorService.professorTemTurma(id)) {
			attr.addFlashAttribute("fail", "Professor não excluido. Tem classe(s) vinculada(s).");
		} else {
			professorService.excluir(id);
			attr.addFlashAttribute("success", "Professor excluido com sucesso.");
		}
		return "redirect:/professor/listar";
	}
	
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
