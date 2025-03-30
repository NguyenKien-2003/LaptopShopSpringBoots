package com.hunre.edu.laptop;

import com.hunre.edu.laptop.models.Order;
import com.hunre.edu.laptop.models.enums.OrderStatus;
import com.hunre.edu.laptop.repositories.OrderRepository;
import com.hunre.edu.laptop.services.OrderService;
import com.hunre.edu.laptop.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
class LaptopApplicationTests {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;

	@Test
	void contextLoads() {
		System.out.println(orderRepository.findByStatus(OrderStatus.DONE).size());
	}

}
