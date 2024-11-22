/**
 * 
 */
package com.resturantservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantservice.dto.OrderRequest;
import com.resturantservice.entities.Customer;
import com.resturantservice.entities.Orders;
import com.resturantservice.entities.OrderStatus;
import com.resturantservice.entities.Restaurant;
import com.resturantservice.entities.User;
import com.resturantservice.repos.OrderRepository;
import com.resturantservice.repos.RestaurantRepository;

/**
 * 
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Orders placeOrder(OrderRequest orderRequest) {
        // Create and save an order
        Orders order = new Orders();

        Restaurant restaurant = new Restaurant();
        restaurant.setId(orderRequest.getRestaurantId());
        Customer customer = new Customer();
        order.setCustomer(customer);
        order.setRestaurant(restaurant);	
        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Other service methods for handling orders
}

