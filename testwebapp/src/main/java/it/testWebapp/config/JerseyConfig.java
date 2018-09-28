package it.testWebapp.config;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

	@Autowired
    ApplicationContext appCtx;

//    public JerseyConfig() {
//    	packages("it.testWebapp.endpoint.config");
//        packages("it.testWebapp.endpoint");
//        register(MultiPartFeature.class);
//    }
	
	
	/**
	 * Jersey actually has a pending bug on it. This is a workaround
	 */
	@PostConstruct
    public void jerseyConfig() {
		logger.info("Rest classes found:");
        Map<String, Object> beans = appCtx.getBeansWithAnnotation(Path.class);
        for (Object o : beans.values()) {
        	logger.info(" -> " + o.getClass().getName());
            register(o);
        }
        register(MultiPartFeature.class);
    }
}
