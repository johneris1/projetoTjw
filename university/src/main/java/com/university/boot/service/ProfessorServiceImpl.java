package com.university.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.boot.dao.ProfessorDao;
import com.university.boot.domain.Professor;
@Service @Transactional(readOnly = false)
public class ProfessorServiceImpl implements ProfessorService{
	@Autowired
	private ProfessorDao dao;
	@Transactional(readOnly = false)
	@Override
	public void salvar(Professor professor) {
		dao.save(professor);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void editar(Professor professor) {
		dao.update(professor);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Professor buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Professor> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean professorTemTurma(Long id) {
		if (buscarPorId(id).getClasses().isEmpty()) {
			return false;
		}
		return true;
	}

}
