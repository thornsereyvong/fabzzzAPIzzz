package com.balancika.hrms.app.tool;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Date> {

 @Override
    public void serialize(Date date, JsonGenerator jGen, SerializerProvider arg2) throws 
        IOException, JsonProcessingException {      

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fDate = sdf.format(date);

        jGen.writeString(fDate);
    }
}