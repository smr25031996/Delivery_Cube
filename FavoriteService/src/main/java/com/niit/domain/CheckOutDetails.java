package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Document
public class CheckOutDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private User user;
    private Order order;
    private Billing billingDetails;

    public CheckOutDetails() {
    }


    public CheckOutDetails(int orderId, User user, Order order, Billing billingDetails) {
        this.orderId = orderId;
        this.user = user;
        this.order = order;
        this.billingDetails = billingDetails;
    }

    @Override
    public String toString() {
        return "CheckOutDetails{" + "orderId=" + orderId + ", user=" + user + ", order=" + order + ", billingDetails=" + billingDetails + '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Billing getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Billing billingDetails) {
        this.billingDetails = billingDetails;
    }

}
