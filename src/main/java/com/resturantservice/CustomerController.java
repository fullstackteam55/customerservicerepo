/**
 * 
 */
package com.resturantservice;

/**
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resturantservice.entities.Customer;
import com.resturantservice.entities.MenuItem;
import com.resturantservice.entities.Orders;
import com.resturantservice.entities.Restaurant;
import com.resturantservice.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/v1/customers")
@Tag(name = "Customer API", description = "Endpoints for managing customers and Customer Functionalities")
public class CustomerController extends ResponseController{
	
    @Autowired
    private CustomerService customerService;
    
    @GetMapping(value="/{customerid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get customer by customerid", description = "Retrieve details of a specific customer by its customerid.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the customer details."),
        @ApiResponse(responseCode = "404", description = "Customer not found."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> getCustomer(@PathVariable Long customerid) {
        try {
        	Optional<Customer> customer= customerService.getCustomer(customerid);
        	return handleResponse(customer.get());
        }
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }

    // Register
    @PostMapping(value="/register",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register a Customer", description = "Register the Customer Details.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created the customer details."),
        @ApiResponse(responseCode = "400", description = "Invalid Customer data supplied."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> register(@RequestBody Customer customer) {
    	try {
         Customer customerRegistered = customerService.register(customer);
         return handleResponse(customerRegistered);
    	}
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }

    // Login
    @PostMapping(value="/login",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Login a Customer", description = "Authenticate a Customer by EmailId and Password, Returns Bearer Token")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully logged in the customer."),
        @ApiResponse(responseCode = "400", description = "Invalid Credentials data supplied."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> login(String username, String password) {
        try {
        	String customerLogin = customerService.login(username,password);
            return handleResponse(customerLogin);
        }
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }

    // Browse Restaurants
    @GetMapping(value="/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Browse Restaurants", description = "Browse Restaurants and its Menus.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the restaurant details."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> browseRestaurants() {
        try {
        	List<Restaurant> restaurants = customerService.browseRestaurants();
        	return handleResponse(restaurants);
        }
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }

    // Search Menus
    @GetMapping(value="/menus/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Search Menus", description = "Search Menus and its details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully searched the menus."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> searchMenu(@RequestParam String keyword) {
        try {
        	List<MenuItem> menuItems = customerService.searchMenu(keyword);
        	return handleResponse(menuItems);
        }
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }

    // Place an Order
    @PostMapping(value="/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Place an Order", description = "Place and Order with OrderItems")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully placed an Order."),
        @ApiResponse(responseCode = "400", description = "Invalid Order data supplied."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> placeOrder(@RequestBody Orders order) {
        try {
        	Orders orderPlaced = customerService.placeOrder(order);
        	return handleResponse(orderPlaced);
        }
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }

    // Track Orders
    @GetMapping(value="/orders/track/{customerid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Track Order by customerid", description = "Track Order by customerid and its status")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully tracked an Order."),
        @ApiResponse(responseCode = "404", description = "Order Not Found by customerid."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> trackOrders(@PathVariable Long customerid) {
        try {
        	List<Orders> trackOrdersList = customerService.trackOrders(customerid);
        	return handleResponse(trackOrdersList);
        }
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }

    // View Order History
    @GetMapping(value="/orders/history/{customerid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "View Order history by customerid", description = "View Order history by customerid")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully viewed Order history."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<Object> getOrderHistory(@PathVariable Long customerid) {
        try {
        	List<Orders> orderHistory = customerService.getOrderHistory(customerid);
        	return handleResponse(orderHistory);
        }
    	catch(Exception ex) {
    		return handleError(ex);
    	}
    }
}

