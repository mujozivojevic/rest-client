package org.codecta.services.episode;


import org.codecta.entity.Episode;
import org.codecta.entity.Series;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EpisodeServiceImpl implements EpisodeService {

    @ConfigProperty(name = "episode-url")
    String episodeUrl;

    @Override
    public List<Episode> getEpisode(Integer id){
        ResteasyClient client = new ResteasyClientBuilderImpl().build();
        ResteasyWebTarget target = client.target(episodeUrl + id + "/episodes");
        Response response = target.request().get();
        List<Episode> episodeList = response.readEntity(List.class);
        response.close();
        return episodeList;
    }
}
