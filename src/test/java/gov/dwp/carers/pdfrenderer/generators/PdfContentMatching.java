package gov.dwp.carers.pdfrenderer.generators;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportGenerator.class);

    private static final String SEPARATER = "\\r?\\n|\\r";
    private static final String SPACE = " ";

    public void contentForCircsVersion(final String version, final int testNumber, final PdfGenerator pdfGenerator, final Function<String, List<String>> generateTestData) throws Exception {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("contentForCircsVersion for version:" + version + " test case number:" + testNumber);
        }
        final String pdfFileLocation = version + "_functionalTestCase" + testNumber + "_circs_contentTestPDF.pdf";
        final String textCaseXml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/circs/c3_functional" + testNumber + "_circs.xml").toURI())));
        deleteFile(pdfFileLocation);
        contentMatches(pdfFileLocation, textCaseXml, pdfGenerator, generateTestData);
    }

    public void contentForClaimVersion(final String version, final int testNumber, final PdfGenerator pdfGenerator, final Function<String, List<String>> generateTestData) throws Exception {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("contentForClaimVersion for version:" + version + " test case number:" + testNumber);
        }
        final String pdfFileLocation = version + "_functionalTestCase" + testNumber + "_contentTestPDF.pdf";
        final String textCaseXml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + version + "/claim/c3_functional" + testNumber + ".xml").toURI())));
        deleteFile(pdfFileLocation);
        contentMatches(pdfFileLocation, textCaseXml, pdfGenerator, generateTestData);
    }

    public String getPDFContent(final String pdfFileLocation) throws Exception {
        final PdfReader reader = new PdfReader(pdfFileLocation);
        final PdfReaderContentParser parser = new PdfReaderContentParser(reader);

        final List<String> content = new ArrayList<>();
        for (int i=1; i <= reader.getNumberOfPages(); i++) {
            final SimpleTextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            String text = strategy.getResultantText();
            text = cleanPdfContent(text, i);
            content.add(text.trim());
        }
        reader.close();

        return String.join(" ",content);
    }

    public String cleanPdfContent(final String text, final Integer pageNumber) {
        String[] textArray = text.split(SEPARATER);
        for (int i=0; i < textArray.length; i++){
            final String dataItem = textArray[i];
            if (pageNumber > 1 && (dataItem.startsWith("Date Received:") || dataItem.startsWith("Transaction:") || dataItem.startsWith("Service Version :"))){
                if (textArray.length > 1 && dataItem.startsWith("Date Received:")) {
                    textArray[i+1] = " ";
                }
                textArray[i] = " ";
            }
            if (dataItem.startsWith("Page")) {
                textArray[i]= "";
            }
        }
        return String.join(SPACE, textArray);
    }

        public boolean foundMustBeTrue(final List<String> testData, final String totalContent) {
        boolean found = true;
        for (final String x : testData) {
            boolean found1 = totalContent.toLowerCase().contains(x.toLowerCase());
            if (!found1) {
                found1 = matchIndividualContent(x.toLowerCase(), totalContent.toLowerCase());
            }
            if (!found1) {
                LOGGER.error("TotalContent " + totalContent);
                LOGGER.error("*** Generated ....:" + x.toLowerCase());
                LOGGER.error("*** Failed to find:" + x.toLowerCase());
                LOGGER.error("*** End ***");
                found = found1;
            }
        }
        return found;
    }

    public boolean matchIndividualContent(final String data, final String totalContent) {
        String textAccumulator = "";
        boolean rtn = true;
        final String[] dataArray = data.split(" ");
        for (int i = 0; i < dataArray.length-1; i++) {
            textAccumulator = textAccumulator.concat(dataArray[i]).concat(" ");
            final boolean result = totalContent.toLowerCase().contains(textAccumulator);
            if (!result) {
                textAccumulator = textAccumulator.replace(dataArray[i], dataArray[dataArray.length-1]);
                if (!totalContent.toLowerCase().contains(textAccumulator)) {
                    rtn = false;
                    break;
                }
                rtn = checkTailText(totalContent, dataArray, i);
                break;
            }
        }
        return rtn;
    }

    public boolean checkTailText(final String totalContent, final String[] dataArray, final int i) {
        String tailText = "";
        for (int j = i; j < dataArray.length-1; j++) {
            tailText = tailText.concat(dataArray[j]).concat(" ");
        }
        return totalContent.toLowerCase().contains(tailText);
    }

    public void contentMatches(final String pdfFileLocation, final String testCaseXml, final PdfGenerator pdfGenerator, final Function<String, List<String>> generateTestData) throws Exception {
        outputFileExists(pdfFileLocation, testCaseXml, pdfGenerator);
        final String totalContent = getPDFContent(pdfFileLocation).replaceAll("\\s+", " ");
        final List<String> testData = generateTestData.apply(testCaseXml);
        assertThat(foundMustBeTrue(testData, totalContent), is(true));
        deleteFile(pdfFileLocation);
    }
}
