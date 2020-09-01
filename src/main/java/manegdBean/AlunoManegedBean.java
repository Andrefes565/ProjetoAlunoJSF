package manegdBean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.DaoAluno;
import models.Aluno;

@ManagedBean(name = "MBAlunos")
@ViewScoped
public class AlunoManegedBean {
	
	private Aluno aluno;

	private ListDataModel<Aluno> itens;

	public ListDataModel<Aluno> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Aluno> itens) {
		this.itens = itens;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		DaoAluno udao = new DaoAluno();

		try {

			ArrayList<Aluno> lista = udao.listar();
			itens = new ListDataModel<Aluno>(lista);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
