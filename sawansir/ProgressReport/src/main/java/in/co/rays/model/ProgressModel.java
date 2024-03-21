package in.co.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.dto.ProgressDTO;

public class ProgressModel {
	public void add(ProgressDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();

	}

	public void update(ProgressDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();

	}

	public void delete(ProgressDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();

	}

	public List search(ProgressDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(ProgressDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				c.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getDeveloperName() != null && dto.getDeveloperName().length() > 0) {
				c.add(Restrictions.like("name", dto.getDeveloperName() + "%"));
			}

		}
		
		List list = c.list();
		tx.commit();
		session.close();

		return list;

	}

	public ProgressDTO findByPK(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("FROM ProgressDTO WHERE ID=?");
		q.setInteger(0, id);
		List list = q.list();
		ProgressDTO dto = null;
		if (list.size() > 0) {
			dto = (ProgressDTO) list.get(0);

		}
		tx.commit();
		session.close();

		return dto;

	}
	
	public List list() {
		return list();
	}
	
	


}
