package org.codecta.services.episode;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.codecta.entity.Episode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
public class MockEpisodeServiceImplTest {

    @InjectMock
    EpisodeServiceImpl episodeService;

    @BeforeEach
    public void prepareMocks() {
        List<Episode> episodeList = new ArrayList<>();
        episodeList.add(new Episode("Batman","2", "2"));
        episodeList.add(new Episode("Parasite","3", "3"));


        Mockito.when(episodeService.getEpisode(81))
                .thenReturn(Collections.singletonList(episodeList.get(0)));

        Mockito.when(episodeService.getEpisode(82))
                .thenReturn(Collections.singletonList(episodeList.get(1)));
    }
    @Test
    void testBatman() {
        given()
                .pathParam("id", 82)
                .when().get("/hello/episode/{id}")
                .then()
                .statusCode(200)
                .body("[0].name", is("Parasite"));
    }

    @Test
    void testParasite() {
        given()
                .pathParam("id", 81)
                .when().get("/hello/episode/{id}")
                .then()
                .statusCode(200)
                .body("[0].name", is("Batman"));
    }



}
