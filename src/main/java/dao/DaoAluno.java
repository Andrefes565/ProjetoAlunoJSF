package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jpaUtil.HibernateUtil;

public class DaoAluno<Aluno> {
	private EntityManager entityManager = HibernateUtil.geEntityManager();

	public void salvar(Aluno aluno) {
		EntityTransaction transaction = entityManager.getTransaction(); //Obejto de transação
		transaction.begin();// Inicia uma transação
		entityManager.persist(aluno);// Salva no banco de dados
		transaction.commit();// Grava no banco de dados
	}
	
	public Aluno updateMerge(Aluno aluno) { // Salva ou Atualiza
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Aluno entidadeSalva = entityManager.merge(aluno);//Salva, atualiza e retorna o objeto
		transaction.commit();

		return entidadeSalva;
	}
	
	public Aluno pesquisar(Aluno aluno) {
		Object id = HibernateUtil.getPrimaryKey(aluno);
		Aluno e = (Aluno) entityManager.find(aluno.getClass(), id);
		return e;

	}
	
	public Aluno pesquisar(Long id, Aluno aluno) {
		entityManager.clear();
		Aluno aluno = entityManager.createQuery("from " + aluno.getSimpleName() + " where id = " + id).getSingleResult();
		return aluno;

	}
	
	public void deletarPoId(Aluno entidade) throws Exception{
		Object id = HibernateUtil.getPrimaryKey(entidade); // Obtem o ID do objeto PK
		EntityTransaction transaction = entityManager.getTransaction();// Obejeto de transação
		transaction.begin();// Começa uma Transação no banco de dados

		entityManager
				.createNativeQuery(
						"delete from " + entidade.getClass(). // Monta a Query para delete
						getSimpleName().toLowerCase() + " where id =" + id)
				.executeUpdate(); // Executa o delete no banco de dados
		transaction.commit();// Grava alteração no banco

	}
	public List<Aluno> listar(Aluno aluno) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Aluno> lista = entityManager.
				createQuery("from " + aluno.getNome())//Cria a queru de consulta
				.getResultList();// Retorna a lista de objetos consultados
		transaction.commit();

		return lista;
	}
}
