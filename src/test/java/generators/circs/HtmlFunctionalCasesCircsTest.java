package generators.circs;

import controllers.PdfServiceApplication;
import generators.HtmlGenerator;
import generators.HtmlSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;


/**
 * Created by peterwhitehead on 09/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
public class HtmlFunctionalCasesCircsTest extends HtmlSpecification {
    @Inject
    private HtmlGenerator htmlGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Test
    public void changeOfCircumstancesFunctionalCases() throws Exception {
        File allFiles = new File(jrxmlLocation);
        Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                for (int i = 1; i <= 13; i++) {
                    createAndGenerateCircsHtml(folder.getName(), i, htmlGenerator);
                }

                for (int i = 20; i <= 37; i++) {
                    createAndGenerateCircsHtml(folder.getName(), i, htmlGenerator);
                }
            } catch (Exception e) { throw new RuntimeException(e); }
        });
    }
}
