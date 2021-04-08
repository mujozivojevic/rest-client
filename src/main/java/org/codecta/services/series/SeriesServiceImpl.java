package org.codecta.services.series;

import org.codecta.entity.Series;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class SeriesServiceImpl implements SeriesService {

    @ConfigProperty(name = "tvserie-url")
    String tvSerieUrl;

    @RestClient
    SeriesRestService seriesRestService;

    @Override
    public Series findTvSerie(String title){
        ResteasyClient client = new ResteasyClientBuilderImpl().build();
        ResteasyWebTarget target = client.target(tvSerieUrl + title);
        Response response = target.request().get();
        Series tvData = response.readEntity(Series.class);
        response.close();
        return tvData;
    }

    public Series findSeriesRest(String title){
        Series series = seriesRestService.findTvSerie(title);
        return series;
    }

    public String getSerieName(String title){
        Series series = seriesRestService.findTvSerie(title);
        return series.getName();
    }
}
