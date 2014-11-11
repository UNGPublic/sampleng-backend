package ungp.sampleng.backend.exception;

public class SampleNgException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SampleNgException() {
    }

    public SampleNgException(String message) {
        super(message);
    }

    public SampleNgException(String message, Throwable cause) {
        super(message, cause);
    }

    public SampleNgException(Throwable cause) {
        super(cause);
    }

    public SampleNgException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

