package manegdBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.AlunoDao;
import dao.CursoDao;
import models.Aluno;
import models.Curso;

@ManagedBean(name = "MBAlunos")
@ViewScoped
public class AlunoBean {
	
	private Aluno aluno;
    private AlunoDao alunoDao;
    private List<Aluno> alunos;
    private Curso  curso;
    private CursoDao cursoDao = new CursoDao();
   
    
   
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
	@SuppressWarnings("static-access")
	public String inserir() {


        try {
        	Curso curso = cursoDao.selecionar(aluno.getCurso().getId());
        	if(curso.getAtivo() == false) {
        		throw new Exception("Curso Inativo!!");
        	}
        	aluno.setCurso(curso);
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

        return "/aluno/alunos.xhtml";
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

        return "/aluno/alunos.xhtml";
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

        return "/aluno/alunos.xhtml";
    }
	
	public void selecionar() {
        try {
            aluno = AlunoDao.selecionar(aluno.getMatricula());

            if (aluno == null || aluno.getMatricula() == 0) {
                aluno = new Aluno();

                throw new Exception("Aluno não encontrado.");
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
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public CursoDao getCursoDao() {
		return cursoDao;
	}
	public void setCursoDao(CursoDao cursoDao) {
		this.cursoDao = cursoDao;
	}
	
}
