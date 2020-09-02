package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cursos")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String areaCon;
	
	@Column(nullable = false)
	private Boolean ativo;

	@OneToMany(mappedBy="curso")
	private List<Aluno> alunos = new ArrayList<>();

	public Curso() {

	}

	public Curso(String descricao, String areaCon, Boolean ativo) {
		this.descricao = descricao;
		this.areaCon = areaCon;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAreaCon() {
		return areaCon;
	}

	public void setAreaCon(String areaCon) {
		this.areaCon = areaCon;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	
}
