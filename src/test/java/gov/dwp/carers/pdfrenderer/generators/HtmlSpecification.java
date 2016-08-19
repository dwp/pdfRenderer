package gov.dwp.carers.pdfrenderer.generators;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
public class HtmlSpecification extends FileHelper {
    public void createAndGenerateCircsHtml(final String version, final int testNumber, final HtmlGenerator htmlGenerator) throws Exception {
        final String fileLocation = "functionalTestCase" + testNumber + "_circs_testGeneratorResultIsSuccess.html";
        final String source = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/circs/c3_functional" + testNumber + "_circs.xml").toURI())));
        deleteFile(fileLocation);
        assertThat(generateHTML(fileLocation, source, htmlGenerator), is(instanceOf(GenerationSuccess.class)));
        deleteFile(fileLocation);
    }

    public void createAndGenerateClaimHtml(final String version, final int testNumber, final HtmlGenerator htmlGenerator) throws Exception {
        final String fileLocation = "functionalTestCase" + testNumber + "_testGeneratorResultIsSuccess.html";
        final String source = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/claim/c3_functional" + testNumber + ".xml").toURI())));
        deleteFile(fileLocation);
        assertThat(generateHTML(fileLocation, source, htmlGenerator), is(instanceOf(GenerationSuccess.class)));
        deleteFile(fileLocation);
    }
}
