package dao;

import java.util.List;

import javax.persistence.EntityManager;

import manegdBean.JpaResourceBean;

import models.Curso;

public class CursoDao {
	public static void inserir(Curso curso) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new Exception(e);
        } finally {
            em.close();
        }
    }
	public static List<Curso> listar() throws Exception {
		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<Curso> cursos = null;

        try {
        	cursos = em.createQuery("from tb_cursos").getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

        return cursos;
	}
	public void atualizar(Curso curso) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new Exception(e);
        } finally {
            em.close();
        }
    }
	
	public static void excluir(long id) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            Curso curso = em.find(Curso.class, id);
            em.remove(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new Exception(e);
        } finally {
            em.close();
        }
    }
}
