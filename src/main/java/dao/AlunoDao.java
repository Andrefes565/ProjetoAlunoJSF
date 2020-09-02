package dao;

import java.util.List;

import javax.persistence.EntityManager;

import manegdBean.JpaResourceBean;
import models.Aluno;

public class AlunoDao {

	public void inserir(Aluno aluno) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new Exception(e);
        } finally {
            em.close();
        }
    }
	
	public static List<Aluno> listar() throws Exception {
		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<Aluno> alunos = null;

        try {
            alunos = em.createQuery("from Aluno").getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

        return alunos;
	}
	
	public void atualizar(Aluno aluno) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new Exception(e);
        } finally {
            em.close();
        }
    }
	
	public static void excluir(long matricula) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            Aluno aluno = em.find(Aluno.class, matricula);
            em.remove(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new Exception(e);
        } finally {
            em.close();
        }
    }
	
	public static Aluno selecionar(long matricula) throws Exception {
		Aluno aluno;

        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
        	aluno = em.find(Aluno.class, matricula);
        } finally {
            em.close();
        }

        return aluno;
    }
	
}
