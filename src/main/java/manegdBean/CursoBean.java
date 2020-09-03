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

@ManagedBean(name = "MBCursos")
@ViewScoped
public class CursoBean {
	
	private Curso curso;
    private CursoDao cursoDao;
    private List<Curso> cursos;
	
	@PostConstruct
    public void init() {
		cursoDao = new CursoDao();
		curso = new Curso();

        try {
        	cursos = CursoDao.listar();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
           
    }
	public String inserir() {
        try {
        	CursoDao.inserir(curso);

            cursos = CursoDao.listar();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Curso adicionado com sucesso!"));
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
        	cursoDao.atualizar(curso);

            cursos = CursoDao.listar();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Curso editado com sucesso!"));
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
            CursoDao.excluir(curso.getId());

            cursos = CursoDao.listar();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Curso removido com sucesso!"));
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
            curso = CursoDao.selecionar(curso.getId());

            if (curso == null || curso.getId() == 0) {
            	curso = new Curso();

                throw new Exception("Lembrete não encontrado.");
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

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
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	

}
