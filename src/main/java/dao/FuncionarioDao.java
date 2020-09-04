package dao;

import java.util.List;

import javax.persistence.EntityManager;

import manegdBean.JpaResourceBean;
import models.Funcionario;

public class FuncionarioDao {
	
	public static void inserir(Funcionario funcionario) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new Exception(e);
        } finally {
            em.close();
        }
    }
	
	public static Funcionario selecionar(long matricula) throws Exception {
		Funcionario funcionario;

        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
        	funcionario = em.find(Funcionario.class, matricula);
        } finally {
            em.close();
        }

        return funcionario;
    }

	public static List<Funcionario> listar() throws Exception {
		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<Funcionario> funcionario = null;

        try {
        	funcionario = em.createQuery("from Funcionario").getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

        return funcionario;
	}
	
}
