package org.arquillian.example.service;

import org.arquillian.example.rest.VolumeUnitsConverter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Arquillian.class)
public class VolumeUnitsConverterResourceTest {

    // #tag::arquillian_intro_rest_test[]
    @Deployment(testable = false) //#<1>
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackages(true, VolumeUnitsConverter.class.getPackage()) //#<2>
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void should_convert_fluid_ounces_to_milliliters(@ArquillianResource URL applicationPath) {//#<3>
        given().
                baseUri(applicationPath.toString()).
                pathParam("amount", "236.5882368").
        when().
                get("/convert/volume/ml/fl/{amount}").
        then().
                assertThat().body(is(equalTo("8.0")));

    }
    // #end::arquillian_intro_rest_test[]
}