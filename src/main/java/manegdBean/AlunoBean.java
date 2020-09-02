package manegdBean;

import java.util.List;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.AlunoDao;
import models.Aluno;

@ManagedBean(name = "MBAlunos")
@ViewScoped
public class AlunoBean {
	
	private Aluno aluno;
    private AlunoDao alunoDao;
    private List<Aluno> alunos;
	
	@PostConstruct
    public void init() {
        alunoDao = new AlunoDao();
        aluno = new Aluno();

        try {
            alunos = AlunoDao.listar();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
           
    }
	public String inserir() {
        try {
        	alunoDao.inserir(aluno);

            alunos = AlunoDao.listar();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aluno adicionado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "home";
    }
	
	public String atualizar() {
        try {
        	alunoDao.atualizar(aluno);

            alunos = AlunoDao.listar();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aluno editado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "home";
    }
	
	public String excluir() {
        try {
            AlunoDao.excluir(aluno.getMatricula());

            alunos = AlunoDao.listar();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aluno removido com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "home";
    }
	
	public void selecionar() {
        try {
            aluno = AlunoDao.selecionar(aluno.getMatricula());

            if (aluno == null || aluno.getMatricula() == 0) {
                aluno = new Aluno();

                throw new Exception("Lembrete não encontrado.");
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
	
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public AlunoDao getAlunoDao() {
		return alunoDao;
	}
	public void setAlunoDao(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	

}
