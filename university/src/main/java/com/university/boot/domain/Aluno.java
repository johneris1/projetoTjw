package com.university.boot.domain;



import jakarta.persistence.*;




@SuppressWarnings("serial")
@Entity
@Table(name = "ALUNOS")
public class Aluno extends AbstractEntity<Long> {

	

	@ManyToOne
	@JoinColumn(name = "classe_id_fk")
	private Classe classe;



	@Column(nullable = false, unique = true)
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	


	
	




}
