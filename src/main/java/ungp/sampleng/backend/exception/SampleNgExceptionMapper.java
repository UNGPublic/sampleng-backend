package ungp.sampleng.backend.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SampleNgExceptionMapper implements ExceptionMapper<SampleNgException> {

    @Override
    public Response toResponse(SampleNgException e) {
        return Response.status(Response.Status.BAD_REQUEST).
                entity(e.getMessage()).
                type("text/plain").
                build();
    }
}
