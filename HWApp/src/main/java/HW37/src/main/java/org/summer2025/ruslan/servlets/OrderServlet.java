package org.summer2025.ruslan.servlets;



import org.summer2025.ruslan.entities.Order;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    private Map<Integer, Order> orders = new HashMap<>();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = mapper.readValue(req.getInputStream(), Order.class);
        orders.put(order.getId(), order);

        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(), order);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        resp.setContentType("application/json");

        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Order order = orders.get(id);
            if (order != null) {
                mapper.writeValue(resp.getOutputStream(), order);
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            mapper.writeValue(resp.getOutputStream(), orders.values());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order updatedOrder = mapper.readValue(req.getInputStream(), Order.class);
        if (orders.containsKey(updatedOrder.getId())) {
            orders.put(updatedOrder.getId(), updatedOrder);
            resp.setContentType("application/json");
            mapper.writeValue(resp.getOutputStream(), updatedOrder);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            if (orders.remove(id) != null) {
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}