/**
 * 
 */
package com.resturantservice.entities;

import javax.persistence.*;

@Entity
@Table(name="deliverypersonnel")
public class DeliveryPersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String contactdetails;
    private String vehicletype;
    private boolean available;
    
    @OneToOne
    @JoinColumn(name = "userid")
    private User user;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContactdetails() {
		return contactdetails;
	}
	public void setContactdetails(String contactdetails) {
		this.contactdetails = contactdetails;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	

}

