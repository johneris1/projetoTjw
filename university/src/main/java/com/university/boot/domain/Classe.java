package com.university.boot.domain;

import java.util.List;

import jakarta.persistence.*;



@SuppressWarnings("serial")
@Entity
@Table(name = "CLASSES")
public class Classe extends AbstractEntity<Long> {


	
	@OneToMany(mappedBy = "classe")
	private List<Aluno> alunos;
	
	@ManyToOne
	@JoinColumn(name = "professor_id_fk")
	private Professor professor;


	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Professor getProfessor() {
		
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAluno(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
