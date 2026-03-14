package cg.demo.SaturdayAssessment1;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrderDAOImpl implements IorderDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();

	@Override
	public boolean addOrder(Order order, int custId) {
		// TODO Auto-generated method stub
		Customer customer = em.find(Customer.class, custId);
		if(customer == null) {
			return false;
		}
		order.setCustomer(customer);
		customer.getOrders().add(order);
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public Order getOrder(int orderId) {
		// TODO Auto-generated method stub
		return em.createQuery(
				"select o from Order o where o.orderId = :id",Order.class)
				.setParameter("id", orderId)
				.getResultStream().findFirst().orElse(null);
	}

	@Override
	public List<Order> getOrders(String custName) {
		// TODO Auto-generated method stub
		return em.createQuery(
				"select o from Order o where o.customer.customerName = :name",Order.class)
				.setParameter("name", custName).getResultList();
	}
	public void close() {
		em.close();
		emf.close();
	}

}
