package sample.hibernate;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestController {

	private Session session;
	
	private Temp temp;
	
	@Before
	public void before() {
		temp = getTemp();

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
	}
	
	@Test
	public void test() {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(temp);
//		session.merge(temp);
//		session.save(temp);
//		session.delete(temp);
		transaction.commit();
		System.out.println(session.contains(temp));
		
//		Object o = session.load(Temp.class, "71a7f96f-cdd2-46be-9e21-93f74b587853");
//		System.out.println(((Temp)o).getId());
	}
	
	@After
	public void after() {
		if(session != null) {
			session.close();
		}
	}
	
	public Temp getTemp() {
		String id = UUID.randomUUID().toString();
		System.out.println("id="+id);
		Temp t = new Temp();
		t.setId(id);
		return t;
	}
	
//	@RequestMapping("/")
//	@ResponseBody
//	public String save() {
//		String id = UUID.randomUUID().toString();
//		logger.info("get test, id="+id);
//		Temp t = new Temp();
//		t.setId(id);
//		tempDao.save(t);
//		return "";
//	}
	
}

@Entity
@Table(name = "temp")
class Temp {

    @Id
    @Column(name = "id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
