package marketplace;

import java.util.Objects;

public class OrderItem {
    public String title;
    public int price;

    public OrderItem(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return price == orderItem.price && Objects.equals(title, orderItem.title);
    }
}
