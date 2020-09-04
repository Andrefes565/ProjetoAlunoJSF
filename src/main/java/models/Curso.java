package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/*
@NamedQueries({
	@NamedQuery(name = "Curso.findAll", query = "SELECT e FROM Curso e"),
	@NamedQuery(name = "Curso.findByNome", query = "SELECT e FROM Curso e WHERE e.descricao = :descricao")
})
*/
@Entity
@Table(name = "tb_cursos")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String areaCon;
	
	@Column(nullable = false)
	private Boolean ativo;

	
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos = new ArrayList<>();

	public Curso() {

	}
	

	public Curso(Long id,String descricao, String areaCon, Boolean ativo) {
		this.id = id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", descricao=" + descricao + ", areaCon=" + areaCon + ", ativo=" + ativo
				+ ", alunos=" + alunos + "]";
	}
	

	
}
