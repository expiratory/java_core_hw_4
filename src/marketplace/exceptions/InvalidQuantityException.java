package marketplace.exceptions;

public class InvalidQuantityException extends BaseMarketplaceException{
    private static final String message = "Количество должно быть положительным целым числом";

    public InvalidQuantityException() {
        super(message);
    }
}
