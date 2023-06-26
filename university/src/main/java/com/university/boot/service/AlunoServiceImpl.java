package com.university.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.boot.dao.AlunoDao;
import com.university.boot.domain.Aluno;



import org.springframework.transaction.annotation.Transactional;
@Service @Transactional(readOnly = true)
public class AlunoServiceImpl implements AlunoService {
	
@Autowired
private AlunoDao dao;

@Transactional(readOnly = false)
	@Override
	public void salvar(Aluno aluno) {
		dao.save(aluno);
		
	}
@Transactional(readOnly = false)
	@Override
	public void editar(Aluno aluno) {
		dao.update(aluno);
		
	}
@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}
@Transactional(readOnly = true)
	@Override
	public Aluno buscarPorId(Long id) {
		return dao.findById(id);
	}
@Transactional(readOnly = true)
	@Override
	public List<Aluno> buscarTodos() {
		return dao.findAll();
	}

}
