package cg.demo.SaturdayAssessment1;

import java.util.List;

public interface IorderDAO {

	public boolean addOrder(Order order, int custId);
	public Order getOrder(int orderId);
	public List<Order> getOrders(String custName);
}