package marketplace.exceptions;

public class InvalidOrderItemException extends BaseMarketplaceException{
    private static final String message = "Данного товара не существует";

    public InvalidOrderItemException() {
        super(message);
    }
}
