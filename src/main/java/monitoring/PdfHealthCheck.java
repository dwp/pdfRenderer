package monitoring;

import gov.dwp.carers.CADSHealthCheck;


/**
 * Created by peterwhitehead on 05/05/2016.
 */
public class PdfHealthCheck extends CADSHealthCheck {
    public PdfHealthCheck(String application, String version) {
        super(application, version);
    }

    @Override
    protected CADSHealthCheck.Result check() {
        return Result.healthy();
    }
}
