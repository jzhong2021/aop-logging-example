package com.nexse.swat.example.servlet;

import com.nexse.swat.example.domain.Customer;
import com.nexse.swat.example.domain.Order;
import com.nexse.swat.example.domain.Product;
import com.nexse.swat.example.service.OrderService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExampleServlet extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        orderService = ctx.getBean(OrderService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Customer customer = new Customer("Arthur Dent", "The Galaxy");
        Product product = new Product(42L, "Hitchhicker's Guide to the Galaxy");
        
        Order order = orderService.order(customer, product);
        
        res.setHeader("Context-Type", "text/plain");
        PrintWriter writer = res.getWriter();
        writer.println("Thank you, your order has been received. Here it is:");
        writer.println();
        writer.println(order);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }
}
