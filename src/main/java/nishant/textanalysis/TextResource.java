package nishant.textanalysis;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/process")
public class TextResource {

    @Inject
    Template TextAnalysis;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance post(@FormParam("inputText") String inputText) {
        String responseText = processText(inputText); // Process the input text
        return TextAnalysis.data("responseText", responseText);
    }

    private String processText(String inputText) {
        // Implement your logic here to generate a response
        // For this example, let's just reverse the text
        return new StringBuilder(inputText).reverse().toString();
    }
}