package com.university.boot.service;

import java.util.List;

import com.university.boot.domain.Classe;

public interface ClasseService {
	
    void salvar(Classe classe);

    void editar(Classe classe);

    void excluir(Long id);

    Classe buscarPorId(Long id);
    
    List<Classe> buscarTodos();

	boolean classeTemAlunos(Long id);

}
