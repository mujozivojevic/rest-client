package org.codecta;

import org.codecta.entity.Episode;
import org.codecta.entity.Series;
import org.codecta.services.greeting.GreetingService;
import org.codecta.services.episode.EpisodeService;
import org.codecta.services.series.SeriesRestService;
import org.codecta.services.series.SeriesService;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
public class GreetingResource {



    @Inject
    @RestClient
    GreetingService greetingService;

    @Inject
    @RestClient
    SeriesRestService seriesRestService;

    @Inject
    SeriesService seriesService;

    @Inject
    EpisodeService episodeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting")
    public String helloGreeting() {
        return greetingService.greeting();
    }


    @GET
    @Path("/serie/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTvSerie(@PathParam("title") String title){

        Series series = seriesService.findSeriesRest(title);
    /*  String series = seriesService.findTvSerie(title);*/
        return Response.ok(series).build();
    }

    @GET
    @Path("/episode/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEpisodes(@PathParam("id") Integer id){

        List<Episode> data = episodeService.getEpisode(id);
        return Response.ok(data).build();
    }


}