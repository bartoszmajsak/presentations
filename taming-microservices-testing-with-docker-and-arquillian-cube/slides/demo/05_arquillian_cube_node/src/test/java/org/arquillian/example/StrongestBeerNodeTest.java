package org.arquillian.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

//# tag::arquillian_cube_test[]
@RunWith(Arquillian.class)
public class StrongestBeerNodeTest {

    @Deployment(testable = false) //#<1>
    public static GenericArchive createDeployment() {
        return ShrinkWrap.create(GenericArchive.class, "strongest_beer_ms.tar")
                .add(new FileAsset(new File("src/test/js/app.js")), "app.js")
                .add(new FileAsset(new File("src/test/js/package.json")), "package.json");
    }

    @Test
    public void should_find_strongest_beer(@ArquillianResource URL base) {//#<2>
        given().
                baseUri(base.toString()).
        when().
                get("/beer/strongest").
        then().
                assertThat().body("name", is(equalTo("Snake Venom")))
                            .body("abv", is(equalTo("67.5")));
    }
}
//# tag::arquillian_cube_end[]