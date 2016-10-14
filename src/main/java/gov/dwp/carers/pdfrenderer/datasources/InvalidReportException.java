package gov.dwp.carers.pdfrenderer.datasources;

public class InvalidReportException extends RuntimeException {
    public InvalidReportException(final String msg) {
        super(msg);
    }
}
