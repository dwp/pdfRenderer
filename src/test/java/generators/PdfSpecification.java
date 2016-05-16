package generators;

import java.io.File;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
public class PdfSpecification extends FileHelper {
    public SuccessOrFailure deleteAndGeneratePDF(String pdfFileLocation, String xml, PdfGenerator pdfGenerator) throws Exception {
        deleteFile(pdfFileLocation);
        return generatePDF(pdfFileLocation, xml, pdfGenerator);
    }

    public void testGeneratorResultIsSuccess(String pdfFileLocation, String xml, PdfGenerator pdfGenerator) throws Exception {
        SuccessOrFailure generatorResult = deleteAndGeneratePDF(pdfFileLocation, xml, pdfGenerator);
        assertThat(generatorResult, is(instanceOf(GenerationSuccess.class)));
    }

    public void testOutputFileExists(String pdfFileLocation, String xml, PdfGenerator pdfGenerator) throws Exception {
        deleteAndGeneratePDF(pdfFileLocation, xml, pdfGenerator);
        File pdfFile = new File(pdfFileLocation);
        assertThat(pdfFile.exists(), is(true));
    }
}
