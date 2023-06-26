package com.university.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.university.boot.dao.ClasseDao;
import com.university.boot.domain.Classe;

@Service @Transactional(readOnly = false)
public class ClasseServiceImpl implements ClasseService {
	@Autowired
	private ClasseDao dao;
	@Override
	public void salvar(Classe classe) {
		dao.save(classe);
		
	}

	@Override
	public void editar(Classe classe) {
		dao.update(classe);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Classe buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Classe> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean classeTemAlunos(Long id) {
		if (buscarPorId(id).getAlunos().isEmpty()) {
			return false;
		}
		return true;
	}

}
