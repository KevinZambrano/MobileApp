package cl.keanzato.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("finanzas")
public class MyApplication extends ResourceConfig{

	public MyApplication(){
		packages("cl.keanzato.app.rest");
	}
	
}
