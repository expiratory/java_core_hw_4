import marketplace.*;
import marketplace.exceptions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public enum Holidays {
        NEW_YEAR("01.01"),
        INTERNATIONAL_WOMEN_DAY("08.03"),
        DEFENDER_OF_THE_FATHERLAND_DAY("23.02");

        private final String date;

        Holidays(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }
    }

    public static void congratulateCustomers(Customer[] customers) {
        LocalDate currentDate = LocalDate.now();
        String currentDateString = currentDate.format(DateTimeFormatter.ofPattern("dd.MM"));

        for (Customer customer : customers) {
            if (customer != null) {
                if (Holidays.NEW_YEAR.getDate().equals(currentDateString)) {
                    System.out.println("Happy New Year, " + customer.getFullName() + "!");
                } else if (Holidays.INTERNATIONAL_WOMEN_DAY.getDate().equals(currentDateString)
                        && customer.getGender() == Customer.Gender.FEMALE) {
                    System.out.println("Happy International Women's Day, " + customer.getFullName() + "!");
                } else if (Holidays.DEFENDER_OF_THE_FATHERLAND_DAY.getDate().equals(currentDateString)
                        && customer.getGender() == Customer.Gender.MALE) {
                    System.out.println("Happy Defender of the Fatherland Day, " + customer.getFullName() + "!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Customer[] customers = new Customer[2];
        customers[0] = new Customer("John Doe", 25, "123-456-7890", Customer.Gender.MALE);
        customers[1] = new Customer("Jane Doe", 30, "987-654-3210", Customer.Gender.FEMALE);

        OrderItem[] orderItems = new OrderItem[5];
        orderItems[0] = new OrderItem("Item 1", 10);
        orderItems[1] = new OrderItem("Item 2", 20);
        orderItems[2] = new OrderItem("Item 3", 30);
        orderItems[3] = new OrderItem("Item 4", 40);
        orderItems[4] = new OrderItem("Item 5", 50);

        Order[] orders = new Order[5];

        Object[][] orderData = {
                {"John Doe", "123-456-7890", 25, Customer.Gender.MALE, "Item 1", 10, 2, customers, orderItems},
                {"Jane Doe", "987-654-3210", 30, Customer.Gender.FEMALE, "Item 2", 20, 3, customers, orderItems},
                {"John Doe", "123-456-7890", 25, Customer.Gender.MALE, "Item 3", 30, 1, customers, orderItems},
                {"Jane Doe1", "987-654-3210", 30, Customer.Gender.FEMALE, "Item 4", 40, -400, customers, orderItems},
                {"JohnError DoeError", "123-456-7890", 25, Customer.Gender.MALE, "Item 5", 50, 5, customers, orderItems}
        };

        int i = 0;

        for (Object[] orderParams : orderData) {
            try {
                orders[i] = Order.createOrder(
                        (String) orderParams[0],
                        (String) orderParams[1],
                        (Integer) orderParams[2],
                        (Customer.Gender) orderParams[3],
                        (String) orderParams[4],
                        (Integer) orderParams[5],
                        (Integer) orderParams[6],
                        (Customer[]) orderParams[7],
                        (OrderItem[]) orderParams[8]
                );
                i++;
            } catch (BaseMarketplaceException e) {
                System.out.println(e.getMessage());
            }
        }

        int actualSize = 0;
        for (Order order : orders) {
            if (order != null) {
                actualSize++;
            }
        }
        System.out.println(actualSize);
        congratulateCustomers(customers);
    }
}
