package org.codecta.services.series;

import com.google.inject.Inject;
import io.quarkus.test.junit.QuarkusTest;
import org.codecta.services.series.SeriesServiceImpl;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
public class SeriesServiceTest {

    @Inject
    @RestClient
    SeriesRestService seriesService;


    @Test
    public void testParasite(){
        Assertions.assertEquals("Batman", seriesService.findTvSerie("Batman").getName());
    }

    @Test
    public void testSeriesEndPoint() {
        given()
                .when().get("http://localhost:8099/api/serie/girls")
                .then()
                .statusCode(200)
                .body(is("Batman"));
    }
}
