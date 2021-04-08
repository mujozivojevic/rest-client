package org.codecta.services.series;

import org.codecta.entity.Series;

public interface SeriesService {
    Series findTvSerie(String title);
    Series findSeriesRest(String title);
    String getSerieName(String title);

}
