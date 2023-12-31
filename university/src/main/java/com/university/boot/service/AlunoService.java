package com.university.boot.service;

import java.util.List;

import com.university.boot.domain.Aluno;

public interface AlunoService {
	void salvar(Aluno aluno);
	
	void editar(Aluno aluno);
	
	void excluir(Long id);
	
	Aluno buscarPorId(Long id);
	
	List<Aluno> buscarTodos();
	
	
}
