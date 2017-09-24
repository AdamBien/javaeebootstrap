package com.airhacks.streaming;

import java.io.IOException;
import java.io.OutputStream;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 * @author airhacks.com
 */
@Path("streams")
@Stateless
public class StreamsResource {

    @Inject
    JsonStreamer js;

    @GET
    public Response streams() {
        StreamingOutput so = new StreamingOutput() {

            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                js.stream(output);
            }
        };
        return Response.ok(so).build();
    }
}
