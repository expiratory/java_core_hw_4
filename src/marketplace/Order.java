package marketplace;

import marketplace.exceptions.*;

import java.util.ArrayList;

public class Order {
    public Customer customer;
    public OrderItem orderItem;
    public int quantity;

    public Order(Customer customer, OrderItem orderItem, int quantity) {
        this.customer = customer;
        this.orderItem = orderItem;
        this.quantity = quantity;
    }

    public static Order createOrder(
            String customerFullName,
            String customerPhoneNumber,
            int customerAge,
            Customer.Gender gender,
            String orderItemTitle,
            int orderItemPrice,
            int orderQuantity,
            Customer[] customers,
            OrderItem[] orderItems
    ) throws BaseMarketplaceException {
        Customer customer = new Customer(customerFullName, customerAge, customerPhoneNumber, gender);
        OrderItem orderItem = new OrderItem(orderItemTitle, orderItemPrice);

        boolean customerExists = false;
        boolean orderItemExists = false;

        for (Customer c : customers) {
            if (c.equals(customer)) {
                customerExists = true;
                break;
            }
        }

        for (OrderItem o : orderItems) {
            if (o.equals(orderItem)) {
                orderItemExists = true;
                break;
            }
        }

        ArrayList <String> exceptionMessages = new ArrayList<>();

        if (!orderItemExists) {
            exceptionMessages.add(new InvalidOrderItemException().getMessage());
        }

        if (!customerExists) {
            exceptionMessages.add(new InvalidCustomerException().getMessage());
        }

        if (orderQuantity <= 0) {
            exceptionMessages.add(new InvalidQuantityException().getMessage());
        }

        if (!exceptionMessages.isEmpty()) {
            StringBuilder finalExceptionString = new StringBuilder();

            for (String message : exceptionMessages) {
                finalExceptionString.append(message).append(" ").append(
                        customerFullName).append(" ").append(orderItemTitle).append("\n");
            }

            throw new BaseMarketplaceException(finalExceptionString.toString());
        }

        return new Order(customer, orderItem, orderQuantity);
    }
}
