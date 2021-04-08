package org.codecta.services.episode;

import org.codecta.entity.Episode;

import java.util.List;

public interface EpisodeService {
    List<Episode> getEpisode(Integer id);
}
