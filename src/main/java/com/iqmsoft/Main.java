package com.iqmsoft;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.swagger.SwaggerArchive;

import com.iqmsoft.filter.CORSFilter;
import com.iqmsoft.rest.HelloWorldApp;
import com.iqmsoft.rest.HelloWorldResource;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
        archive.addResource(HelloWorldApp.class);
        archive.addResource(HelloWorldResource.class);
        archive.addResource(CORSFilter.class);

        SwaggerArchive swaggerArchive = archive.as(SwaggerArchive.class);
        swaggerArchive.setContextRoot("/context");
        swaggerArchive.setPrettyPrint(true);

        swarm.start();
        swarm.deploy(archive);
    }
}
