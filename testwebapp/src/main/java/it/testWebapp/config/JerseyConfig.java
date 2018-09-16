package it.testWebapp.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
    	packages("it.testWebapp.endpoint.config");
        packages("it.testWebapp.endpoint");
        register(MultiPartFeature.class);
    }
}
