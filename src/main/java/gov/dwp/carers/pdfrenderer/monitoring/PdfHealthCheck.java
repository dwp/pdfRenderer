package gov.dwp.carers.pdfrenderer.monitoring;

import gov.dwp.carers.CADSHealthCheck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 05/05/2016.
 */
@Component
public class PdfHealthCheck extends CADSHealthCheck {
    @Inject
    public PdfHealthCheck(final @Value("${application.name}") String applicationName,
                          final @Value("${application.version}") String applicationVersion) {
        super(applicationName, applicationVersion.replace("-SNAPSHOT", ""), "-check");
    }

    @Override
    protected CADSHealthCheck.Result check() {
        return Result.healthy();
    }
}
