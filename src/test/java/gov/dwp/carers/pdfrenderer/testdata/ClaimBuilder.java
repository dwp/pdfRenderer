package gov.dwp.carers.pdfrenderer.testdata;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
public class ClaimBuilder {
    public final static String LATEST_VERSION = "0.24";

    public static String goodClaim() throws URISyntaxException, IOException {
        return new String(Files.readAllBytes(Paths.get(Thread.currentThread().getContextClassLoader().getResource("goodClaim.xml").toURI())));
    }

    public static String badClaim() {
        final String badClaim = "<DWPBody xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" xmlns=\"http://www.govtalk.gov.uk/dwp/carers-allowance\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd\"> <Version>" + ClaimBuilder.LATEST_VERSION + "</Version><DWPCATransaction><TransactionId>NFM33DB</TransactionId><DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated></DWPCATransaction></DWPBody>";
        return badClaim;
    }
}
