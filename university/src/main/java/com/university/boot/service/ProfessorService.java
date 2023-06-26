package com.university.boot.service;

import java.util.List;
import com.university.boot.domain.Professor;

public interface ProfessorService {
	void salvar(Professor professor);
	
	void editar(Professor professor);
	
	void excluir(Long id);
	
	Professor buscarPorId(Long id);
	
	List<Professor> buscarTodos();
	
	boolean professorTemTurma(Long id);
}
