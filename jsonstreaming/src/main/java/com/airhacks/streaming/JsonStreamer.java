package com.airhacks.streaming;

import java.io.OutputStream;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.stream.JsonGenerator;

/**
 * @author airhacks.com
 */
@Stateless
public class JsonStreamer {

    public void stream(OutputStream stream) {
        JsonGenerator generator = Json.createGenerator(stream);
        generator.writeStartObject();
        for (int i = 0; i < 1000; i++) {
            generator.write("key" + i, "value" + i);
        }
        generator.writeEnd();
        generator.flush();
        generator.close();
    }

}
