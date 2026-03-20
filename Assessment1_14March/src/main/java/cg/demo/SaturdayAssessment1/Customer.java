package cg.demo.SaturdayAssessment1;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "abes_customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name", nullable = false, length = 45)
	private String customerName;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();

	public Customer() {}

	public Customer(int customerId, String customerName, List<Order> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.orders = orders;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", orders=" + orders + "]";
	}


}