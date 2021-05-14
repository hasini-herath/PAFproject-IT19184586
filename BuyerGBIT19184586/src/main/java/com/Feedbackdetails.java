package com;


import model.Feedback;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;


@Path("/feedback")
public class Feedbackdetails
{
	Feedback itemObj = new Feedback();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readfd()
		{
			return itemObj.readfd();
		}
		
		

		@POST
			@Path("/")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertfd(@FormParam("pcode") String pcode,
			 @FormParam("description") String description)
			

			{
			 String output = itemObj.insertfd(pcode, description);
			return output;
			}
}