package com.pass.cloud.common.util.http.apache;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/**
 * @author takesi
 */
public class InputStreamResponseHandler implements ResponseHandler<InputStream> {

    public static final ResponseHandler<InputStream> INSTANCE = new InputStreamResponseHandler();

    @Override
    public InputStream handleResponse(final HttpResponse response) throws IOException {
        final StatusLine statusLine = response.getStatusLine();
        final HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() >= HttpStatus.SC_MULTIPLE_CHOICES) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
        return entity == null ? null : entity.getContent();
    }

}
