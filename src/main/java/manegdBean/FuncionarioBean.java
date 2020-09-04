package manegdBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.FuncionarioDao;
import models.Funcionario;

@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionario;
	private FuncionarioDao funcionarioDao;

	private List<Funcionario> funcionarios;

	@PostConstruct
	public void init() {
		funcionarioDao = new FuncionarioDao();
		funcionario = new Funcionario();

		try {
			funcionarios = FuncionarioDao.listar();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			context.getExternalContext().getFlash().setKeepMessages(true);
		}

	}

	public String inserir() {

		try {
			FuncionarioDao.inserir(funcionario);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Funcionario adicionado com sucesso!"));
			context.getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			context.getExternalContext().getFlash().setKeepMessages(true);
		}

		return "/login/login.xhtml";
	}

	public String logar() {
		try {
			Funcionario funcionariolog = FuncionarioDao.selecionar(funcionario.getMatricula());

			if (funcionariolog.getSenha().equals(funcionario.getSenha())) {
				return "home";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/login/login.xhtml";
	}

	public void selecionar() {
		try {
			funcionario = FuncionarioDao.selecionar(funcionario.getMatricula());

			if (funcionario == null || funcionario.getMatricula() == 0) {
				funcionario = new Funcionario();

				throw new Exception("Funcionario não encontrado.");
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

}
