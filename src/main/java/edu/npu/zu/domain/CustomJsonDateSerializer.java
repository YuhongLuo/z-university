package edu.npu.zu.domain;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* This class helps Jackson convert a Date object to a formatted date string.
 * By adding the @JsonComponent annotation, the serializer is registered in the Jackson ObjectMapper in our Spring Boot application.
 * When Strings need to be converted to Date objects, this serialize() method will be called.
 */
@JsonComponent
public class CustomJsonDateSerializer extends JsonSerializer<Date> {
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    
	/*  Given a Date object, produce a formatted text string for the date  */
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider serProv) throws IOException,
			JsonProcessingException 
	{
		formatter.setTimeZone(TimeZone.getTimeZone( "UTC" ));
		String formattedDate = formatter.format(date);
		gen.writeString(formattedDate);
	}
	
}
