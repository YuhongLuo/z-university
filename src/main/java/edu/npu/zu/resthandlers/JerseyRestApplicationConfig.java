package edu.npu.zu.resthandlers;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.springframework.stereotype.Component;
import edu.npu.zu.exceptions.InvalidAcctExResolver;
import edu.npu.zu.exceptions.UnknownResourceExResolver;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JerseyRestApplicationConfig extends ResourceConfig {

    public JerseyRestApplicationConfig() {
        // Register the resource handler class directly
        register(StudentRestHandler.class);

        // Register support for JSON (Jackson)
        register(JacksonFeature.class);

        // Register Features
        register(DeclarativeLinkingFeature.class);
        
        // Register Exception Mappers
        register(InvalidAcctExResolver.class);
        register(UnknownResourceExResolver.class);
        
        // Add logging for debugging purposes
        register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), 
                 Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
    }

}
