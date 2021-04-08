package org.codecta.services.series;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.codecta.entity.Series;
import org.codecta.services.greeting.GreetingService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MockSeriesServiceImplTest  {

    @InjectMock
    SeriesServiceImpl seriesService;

    @BeforeEach
    public void setup() {

        Mockito.when(seriesService.findTvSerie("Parasite")).thenReturn(new Series(Long.valueOf(192),"Parasite", "Korean"));
        Mockito.when(seriesService.findSeriesRest("Superman")).thenReturn(new Series(Long.valueOf(192),"Superman", "English"));


        SeriesServiceImpl mock = Mockito.mock(SeriesServiceImpl.class);
        Mockito.when(mock.findSeriesRest("Batman"))
                .thenReturn(new Series(Long.valueOf(192),"Batman","English"));
        Mockito.when(mock.findSeriesRest("Saw"))
                .thenReturn(new Series(Long.valueOf(192),"Saw","English"));
        QuarkusMock.installMockForType(mock, SeriesServiceImpl.class);
    }

    @Test
    public void testNameParasite() {
        Assertions.assertEquals("Parasite", seriesService.findTvSerie("Parasite").getName());
        Assertions.assertEquals("Superman", seriesService.findSeriesRest("Superman").getName());
    }

    @Test
    public void testSeriesEndPoint() {
        given()
                .when().get("/hello/serie/Batman")
                .then()
                .statusCode(200)
                .body("name", is("Batman"))
                .body("id",is(192))
                .body("language", is("English"));
 }

    @Test
    public void testSawEndPoint() {
        given()
                .when().get("/hello/serie/Saw")
                .then()
                .statusCode(200)
                .body("name", is("Saw"))
                .body("id",is(192))
                .body("language", is("English"));
    }


}
