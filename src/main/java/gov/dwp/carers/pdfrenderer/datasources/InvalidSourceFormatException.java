package gov.dwp.carers.pdfrenderer.datasources;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
public class InvalidSourceFormatException extends RuntimeException {
    public InvalidSourceFormatException(final String msg) {
        super(msg);
    }
}
