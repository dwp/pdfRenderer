package generators;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
public class PdfContentMatching extends PdfSpecification {
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    String seperator = "\\r?\\n|\\r";
    String space = " ";

    public void testContentForCircsVersion(String version, int testNumber, PdfGenerator pdfGenerator, Function<String, List<String>> generateTestData) throws Exception {
        logger.info("testContentForCircsVersion for version:" + version + " test case number:" + testNumber);
        String pdfFileLocation = version + "_functionalTestCase" + testNumber + "_circs_contentTestPDF.pdf";
        String textCaseXml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/circs/c3_functional" + testNumber + "_circs.xml").toURI())));
        deleteFile(pdfFileLocation);
        testContentMatches(pdfFileLocation, textCaseXml, pdfGenerator, generateTestData);
    }

    public void testContentForClaimVersion(String version, int testNumber, PdfGenerator pdfGenerator, Function<String, List<String>> generateTestData) throws Exception {
        logger.info("testContentForClaimVersion for version:" + version + " test case number:" + testNumber);
        String pdfFileLocation = version + "_functionalTestCase" + testNumber + "_contentTestPDF.pdf";
        String textCaseXml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/claim/c3_functional" + testNumber + ".xml").toURI())));
        deleteFile(pdfFileLocation);
        testContentMatches(pdfFileLocation, textCaseXml, pdfGenerator, generateTestData);
    }

    public String getPDFContent(String pdfFileLocation) throws Exception {
        PdfReader reader = new PdfReader(pdfFileLocation);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);

        List<String> content = new ArrayList<>();
        for (int i=1; i <= reader.getNumberOfPages(); i++) {
            SimpleTextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            String text = strategy.getResultantText();
            text = cleanPdfContent(text, i);
            content.add(text.trim());
        }
        reader.close();

        return String.join(" ",content).toLowerCase()
                .replaceAll(seperator, space) //Replacing new lines for spaces
                .replaceAll(" service version : 0\\.[0-9]{2}  ",""); //Removing the header from the pdf -> text conversion because it interfered with field values
    }

    public String cleanPdfContent(String text, Integer pageNumber) {
        String[] textArray = text.split(seperator);
        for (int i=0; i < textArray.length; i++){
            String dataItem = textArray[i];
            if (pageNumber > 1 && (dataItem.startsWith("Date Received:") || dataItem.startsWith("Transaction:") || dataItem.startsWith("service version :"))){
                textArray[i] = " ";
            }
            if (dataItem.startsWith("Page")){
                textArray[i]= "";
            }
        }
        return String.join(space, textArray);
    }

    public boolean foundMustBeTrue(List<String> testData, String totalContent) {
        boolean found = true;
        for (String x : testData) {
            boolean found1 = totalContent.toLowerCase().contains(x.toLowerCase());
            if (!found1) {
                found1 = matchIndividualContent(x.toLowerCase(), totalContent.toLowerCase());
            }
            if (!found1) {
                logger.error("TotalContent " + totalContent);
                logger.error("*** Generated ....:" + x.toLowerCase());
                logger.error("*** Failed to find:" + x.toLowerCase());
                logger.debug("*** End ***");
                found = found1;
            }
        }
        return found;
    }

    public boolean matchIndividualContent (String data, String totalContent) {
        boolean matchFound = true;
        String textAccumulator = "";

        String[] dataArray = data.split(" ");
        for (int i = 0; i < dataArray.length-1; i++) {
            String dataItem = dataArray[i];
            textAccumulator = textAccumulator.concat(dataItem).concat(" ");
            boolean result = totalContent.toLowerCase().contains(textAccumulator);
            if (!result) {
                textAccumulator = textAccumulator.replace(dataItem, dataArray[dataArray.length-1]);
                if (!totalContent.toLowerCase().contains(textAccumulator)){
                    return false;
                }
                return checkTailText(totalContent, dataArray, i);
            }
        }
        return matchFound;
    }

    public boolean checkTailText(String totalContent, String[] dataArray, int i) {
        String tailText = "";
        for (int j = i; j < dataArray.length-1; j++) {
            tailText = tailText.concat(dataArray[j]).concat(" ");
        }
        return totalContent.toLowerCase().contains(tailText);
    }

    public void testContentMatches(String pdfFileLocation, String testCaseXml, PdfGenerator pdfGenerator, Function<String, List<String>> generateTestData) throws Exception {
        testOutputFileExists(pdfFileLocation, testCaseXml, pdfGenerator);
        String totalContent = getPDFContent(pdfFileLocation).replaceAll("\\s+", " ");
        List<String> testData = generateTestData.apply(testCaseXml);
        assertThat(foundMustBeTrue(testData, totalContent), is(true));
        deleteFile(pdfFileLocation);
    }
}
