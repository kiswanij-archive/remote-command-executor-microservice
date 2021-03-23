package com.app;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jk.util.JKIOUtil;
import com.jk.util.config.JKConfig;
import com.jk.util.logging.JKLogger;

@Path("/commands")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Service {
	private static final String COMMAND=JKConfig.getDefaultInstance().getProperty("COMMAND1"); 

	@POST
	@Path("/exec")
	public String execute(Model model) {
		JKIOUtil.exeutCommandAndWait(null,COMMAND);
		JKIOUtil.exeutCommandAndWait(null,"cmd /c echo "+model.getName());
		return "Success";
	}
	
}