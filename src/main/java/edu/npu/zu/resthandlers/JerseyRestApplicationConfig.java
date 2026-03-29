package edu.npu.zu.resthandlers;

/*
import java.util.HashSet;

import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;

import edu.npu.zu.exceptions.InvalidAcctExResolver;
import edu.npu.zu.exceptions.UnknownResourceExResolver;

/*   See class UnivAppConfig for configuring the Jersey servlet (what was previously in the web.xml file)   */
/*
public class JerseyRestApplicationConfig extends Application {
//public class JerseyRestApplicationConfig extends ResourceConfig {
	private Set<Class<?>> restClassSet = new HashSet<Class<?>>();
	
	public JerseyRestApplicationConfig() {
		/* AuthorizationFilter is a servlet filter that could automatically perform authorization on all incoming requests */
		//restClassSet.add(AuthorizationFilter.class);
		//restClassSet.add(JacksonFeature.class);  // Now configured automatically by Spring Boot
	/*	restClassSet.add(StudentRestHandler.class);   // All handler classes must be registered
		restClassSet.add(InvalidAcctExResolver.class);  // All exception resolver classes should be registered
		restClassSet.add(UnknownResourceExResolver.class);
		restClassSet.add(DeclarativeLinkingFeature.class);  // Needed for @InjectLinks and @InjectLink

        restClassSet.add(org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider.App.class);
        restClassSet.add(org.glassfish.jersey.jaxb.internal.XmlRootElementProvider.App.class);
       // restClassSet.add(org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider.class);
    }
	
	public Set<Class<?>> getClasses() {
		return restClassSet;
	}
}*/



import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import edu.npu.zu.exceptions.InvalidAcctExResolver;
import edu.npu.zu.exceptions.UnknownResourceExResolver;

public class JerseyRestApplicationConfig extends ResourceConfig {

    public JerseyRestApplicationConfig() {
        // 1. Scan your handlers
        packages("edu.npu.zu.resthandlers");

        // 2. FORCE register the XML providers (this fixes the 406)
        register(org.glassfish.jersey.moxy.xml.MoxyXmlFeature.class);
        // If the line above doesn't compile, use this instead:
        // register(org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider.App.class);

        // 3. Register your custom features
        register(DeclarativeLinkingFeature.class);
        register(InvalidAcctExResolver.class);
        register(UnknownResourceExResolver.class);
    }

}

