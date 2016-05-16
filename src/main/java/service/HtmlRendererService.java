package service;

import generators.HtmlGenerator;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class HtmlRendererService extends RendererService {
    @Inject
    private HtmlGenerator reportGenerator;

    public String generateHtml(String xmlBody) {
        return outputGeneration(xmlBody, reportGenerator);
    }
}
