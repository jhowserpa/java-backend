package br.com.javabackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.javabackend.model.Professores;
import br.com.javabackend.util.HibernateUtil;

public class ProfessoresDAO {

	public Long inserir(Professores professores) {
		// professores.setCodigo("01");
		// professores.setNome("Jhow Serpa");
		// ;
		// professores.setEmail("jonataserpa@gmail.com");
		// ;
		// professores.setFone("(35)99743-3853");
		// ;

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(professores);
		t.commit();
		return professores.getId();
	}

	public void alterar(Professores chamado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.merge(chamado);
		t.commit();
	}

	public void excluir(long id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Professores c = selecionar(id);

		Transaction t = s.beginTransaction();
		s.delete(c);
		t.commit();
	}

	public Professores selecionar(long id) {
		return (Professores) HibernateUtil.getSessionFactory().openSession().get(Professores.class, id);
	}

	public List<Professores> listar() {
		return (List<Professores>) HibernateUtil.getSessionFactory().openSession().createQuery("from Professores")
				.list();
	}

}
