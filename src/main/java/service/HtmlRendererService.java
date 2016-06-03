package service;

import generators.HtmlGenerator;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class HtmlRendererService extends RendererService {
    private HtmlGenerator reportGenerator;

    public String generateHtml(String xmlBody) {
        return outputHtmlGeneration(xmlBody, reportGenerator);
    }

    @Inject
    public void setHtmlGenerator(HtmlGenerator htmlGenerator) {
        this.reportGenerator = htmlGenerator;
    }
}
