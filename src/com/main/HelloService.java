package com.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.main.models.UserInfo;

//Sets the path to base URL + /hello
@Path("/hello")
public class HelloService {
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	 public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }
	  */
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	 public UserInfo sayPlainTextHello() {
	    UserInfo userInfo = new UserInfo();
	    userInfo.setId(1);
	    userInfo.setName("SANDEEP");
	    return userInfo;
	  }


}
