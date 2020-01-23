package com.example.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = -4552926567394597316L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int orderId;
	protected Date orderdate;
	protected Date expecteddate;
	protected String orderedby;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "orderid", referencedColumnName = "id")
	protected List<ItemDetails> itemdetails;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	protected UserDetails userDetailsEntity;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getExpecteddate() {
		return expecteddate;
	}

	public void setExpecteddate(Date expecteddate) {
		this.expecteddate = expecteddate;
	}

	public String getOrderedby() {
		return orderedby;
	}

	public void setOrderedby(String orderedby) {
		this.orderedby = orderedby;
	}

	public List<ItemDetails> getItemdetails() {
		return itemdetails;
	}

	public void setItemdetails(List<ItemDetails> itemdetails) {
		this.itemdetails = itemdetails;
	}

	public UserDetails getUserDetailsEntity() {
		return userDetailsEntity;
	}

	public void setUserDetailsEntity(UserDetails userDetailsEntity) {
		this.userDetailsEntity = userDetailsEntity;
	}

	@Override
	public String toString() {
		return "OrderDetailsEntity [orderId=" + orderId + ", orderdate=" + orderdate + ", expecteddate=" + expecteddate
				+ ", orderedby=" + orderedby + ", itemdetails=" + itemdetails + ", userDetailsEntity="
				+ userDetailsEntity + "]";
	}

}
