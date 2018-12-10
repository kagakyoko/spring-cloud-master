package com.pass.cloud.common.error;

/**
 * @author takesi
 */
public class HttpErrorException extends Exception {

    private static final long serialVersionUID = -6357149550353160810L;

    private HttpError error;

    public HttpErrorException(HttpError error) {
        super(error.toString());
        this.error = error;
    }

    public HttpErrorException(HttpError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public HttpError getError() {
        return this.error;
    }


}
