package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alunos")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Integer matricula;
	private String nome;
	private String curso;
	private String email;
	private String telefone;
	private String observacao;
	
	public Aluno() {
		
	}

	public Aluno(Integer matricula, String nome, String curso, String email, String telefone, String observacao) {

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.email = email;
		this.telefone = telefone;
		this.observacao = observacao;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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
	
	
	
}
