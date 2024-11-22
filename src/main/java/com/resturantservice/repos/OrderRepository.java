package com.resturantservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.resturantservice.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
	List<Orders> findByCustomerId(Long customerId);
	List<Orders> findByRestaurantId(Long restaurantId);
	List<Orders> findByStatus(String status);
	
	@Query("SELECT o.restaurant.name, COUNT(o) FROM Orders o GROUP BY o.restaurant.name")
    List<Object[]> findMostPopularRestaurants();

    //@Query("SELECT AVG(TIMESTAMPDIFF(SECOND, o.createdat, o.deliveredat)) FROM Orders o WHERE o.deliveredat IS NOT NULL")
    //Double findAverageDeliveryTime();

    @Query("SELECT o.status, COUNT(o) FROM Orders o GROUP BY o.status")
    List<Object[]> findOrderStatusCounts();
}
