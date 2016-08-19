package gov.dwp.carers.pdfrenderer.generators;

import java.io.File;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
public class PdfSpecification extends FileHelper {
    public SuccessOrFailure deleteAndGeneratePDF(final String pdfFileLocation, final String xml, final PdfGenerator pdfGenerator) throws Exception {
        deleteFile(pdfFileLocation);
        return generatePDF(pdfFileLocation, xml, pdfGenerator);
    }

    public void generatorResultIsSuccess(final String pdfFileLocation, final String xml, final PdfGenerator pdfGenerator) throws Exception {
        final SuccessOrFailure generatorResult = deleteAndGeneratePDF(pdfFileLocation, xml, pdfGenerator);
        assertThat(generatorResult, is(instanceOf(GenerationSuccess.class)));
        deleteFile(pdfFileLocation);
    }

    public void outputFileExists(final String pdfFileLocation, final String xml, final PdfGenerator pdfGenerator) throws Exception {
        deleteAndGeneratePDF(pdfFileLocation, xml, pdfGenerator);
        final File pdfFile = new File(pdfFileLocation);
        assertThat(pdfFile.exists(), is(true));
    }
}
