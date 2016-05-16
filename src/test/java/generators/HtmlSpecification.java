package generators;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
public class HtmlSpecification extends FileHelper {
    public SuccessOrFailure createAndGenerateCircsHtml(String version, int testNumber, HtmlGenerator htmlGenerator) throws Exception {
        String fileLocation = "functionalTestCase" + testNumber + "_circs_testGeneratorResultIsSuccess.html";
        String source = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/circs/c3_functional" + testNumber + "_circs.xml").toURI())));
        deleteFile(fileLocation);
        return generateHTML(fileLocation, source, htmlGenerator);
    }

    public SuccessOrFailure createAndGenerateClaimHtml(String version, int testNumber, HtmlGenerator htmlGenerator) throws Exception {
        String fileLocation = "functionalTestCase" + testNumber + "_testGeneratorResultIsSuccess.html";
        String source = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/claim/c3_functional" + testNumber + ".xml").toURI())));
        deleteFile(fileLocation);
        return generateHTML(fileLocation, source, htmlGenerator);
    }
}
