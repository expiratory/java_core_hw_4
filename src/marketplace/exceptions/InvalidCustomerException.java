package marketplace.exceptions;

public class InvalidCustomerException extends BaseMarketplaceException{
    private static final String message = "Данного пользователя не существует";

    public InvalidCustomerException() {
        super(message);
    }
}
