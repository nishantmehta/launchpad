package nishant.textanalysis;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.w3c.dom.Text;

import java.util.Date;

@Path("/hello")
public class TextAnalysisResource {


    @Inject
    Template TextAnalysis;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return TextAnalysis.data("name", "Guest")
                .data("currentTime", new Date());
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance post(@FormParam("name") String name) {
        return TextAnalysis.data("name", name)
                .data("currentTime", new Date());
    }
}
