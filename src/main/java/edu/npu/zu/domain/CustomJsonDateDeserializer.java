package edu.npu.zu.domain;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.text.ParseException;

/* This class helps Jackson convert a JSON text date (string) to a Date object.
 * By adding the @JsonComponent annotation, the Deserializer is registered in the Jackson ObjectMapper in our Spring Boot application.
 * When String objects need to be converted to Date objects, this deserialize() method will be called.
 */
@JsonComponent
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Date deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
        String date = parser.getText();
        
        try {
			return dateFormat.parse(date);
		} catch (ParseException ex) {
			throw new RuntimeException(ex);
		}
	}

}

