package com.resturantservice.entities;

import java.sql.Timestamp;

import javax.persistence.*;


@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
    
    @OneToOne
    @JoinColumn(name = "orderitemid")
    private OrderItem orderitem;

    @OneToOne
    @JoinColumn(name = "restaurantid")
    private Restaurant restaurant;
    
    @OneToOne
    @JoinColumn(name = "deliverypersonnelid", nullable = true)
    private DeliveryPersonnel deliverypersonnel;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    private Timestamp createdat;
    
    @Column(nullable = true)
    private Timestamp deliveredat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public DeliveryPersonnel getDeliverypersonnel() {
		return deliverypersonnel;
	}

	public void setDeliverypersonnel(DeliveryPersonnel deliverypersonnel) {
		this.deliverypersonnel = deliverypersonnel;
	}

	public Timestamp getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Timestamp createdat) {
		this.createdat = createdat;
	}

	public Timestamp getDeliveredat() {
		return deliveredat;
	}

	public void setDeliveredat(Timestamp deliveredat) {
		this.deliveredat = deliveredat;
	}

	public OrderItem getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(OrderItem orderitem) {
		this.orderitem = orderitem;
	}
    
    
}

