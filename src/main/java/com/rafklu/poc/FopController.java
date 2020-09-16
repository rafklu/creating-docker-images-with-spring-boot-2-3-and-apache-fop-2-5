package com.rafklu.poc;

import java.io.File;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FopController {

    @GetMapping("/download.pdf")
    public void generate(HttpServletResponse response) {
        response.setContentType("application/pdf");

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        // Setup output
        try (OutputStream out = response.getOutputStream()) {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Source template = new StreamSource(new ClassPathResource("xml/template.xsl").getInputStream());
            Transformer transformer = factory.newTransformer(template);

            // Setup input for XSLT transformation
            Source src = new StreamSource(new ClassPathResource("xml/data.xml").getInputStream());

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            transformer.transform(src, res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
