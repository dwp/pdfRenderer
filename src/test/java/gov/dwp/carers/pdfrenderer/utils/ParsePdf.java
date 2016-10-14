package gov.dwp.carers.pdfrenderer.utils;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

public class ParsePdf {
    public String getPdfText(byte[] pdfcontent) {
        StringBuffer pdfText = new StringBuffer(1000);
        try {
            PdfReader pdfReader = new PdfReader(pdfcontent);
            System.out.println("PDF has:"+pdfReader.getNumberOfPages()+" pages");
            for(int n=1;n<=pdfReader.getNumberOfPages(); n++){
                Rectangle rect=pdfReader.getPageSize(1);
                RenderFilter regionFilter = new RegionTextRenderFilter(rect);
                TextExtractionStrategy strategy = new FilteredTextRenderListener(new SimpleTextExtractionStrategy(), regionFilter);
                pdfText.append(PdfTextExtractor.getTextFromPage(pdfReader, n, strategy));
            }
            pdfReader.close();
        } catch (Exception e) {
            // we just return nothing if had trouble since we only test support
        }
        return pdfText.toString();
    }
}
