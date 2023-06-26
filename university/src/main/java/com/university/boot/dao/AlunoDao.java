package com.university.boot.dao;


import java.util.List;


import com.university.boot.domain.Aluno;

public interface AlunoDao {
    
	void save(Aluno aluno);

    void update(Aluno aluno);

    void delete(Long id);

   Aluno findById(Long id);

    List<Aluno> findAll();
    


}
