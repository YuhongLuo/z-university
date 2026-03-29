package edu.npu.zu.resthandlers;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.stereotype.Component;
import edu.npu.zu.exceptions.InvalidAcctExResolver;
import edu.npu.zu.exceptions.UnknownResourceExResolver;

import javax.annotation.PostConstruct;

@Component
public class JerseyRestApplicationConfig extends ResourceConfig {

    public JerseyRestApplicationConfig() {
        // 1. Scan your handlers
        packages("edu.npu.zu.resthandlers");

        // 2. Register Jackson for both XML and JSON support
        register(JacksonFeature.class);

        // 3. Register your custom features and resolvers
        register(DeclarativeLinkingFeature.class);
        register(InvalidAcctExResolver.class);
        register(UnknownResourceExResolver.class);
    }
    
    @PostConstruct
    public void init() {
        // Additional initialization if needed
    }

}
