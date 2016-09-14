package dataSources;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
public class InvalidSourceFormatException extends RuntimeException {
    public InvalidSourceFormatException(String msg) {
        super(msg);
    }
}
