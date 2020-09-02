package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_alunos")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long matricula;
	
    @Column(nullable = false)
	private String nome;
    @Column(nullable = false)
	private String email;
    @Column(nullable = false)
	private String telefone;
    @Column(nullable = false)
	private String observacao;

    @ManyToOne
    @JoinColumn(name="curso_aluno")
	private Curso curso;

	public Aluno() {

	}

	public Aluno(Long matricula, String nome, String email, String telefone, String observacao, Curso curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.observacao = observacao;
		this.curso = curso;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
