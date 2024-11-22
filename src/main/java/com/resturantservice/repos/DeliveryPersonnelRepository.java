/**
 * 
 */
package com.resturantservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resturantservice.entities.DeliveryPersonnel;

@Repository
public interface DeliveryPersonnelRepository extends JpaRepository<DeliveryPersonnel, Long> {
    DeliveryPersonnel findByEmail(String email);
}
