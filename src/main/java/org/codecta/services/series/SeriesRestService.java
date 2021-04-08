package org.codecta.services.series;

import org.codecta.entity.Series;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RegisterRestClient(configKey = "tvserie-api")
@Path("/singlesearch")
@ApplicationScoped
public interface SeriesRestService {

    @GET
    @Path("/shows")
    Series findTvSerie(@QueryParam("q") String title);
}
