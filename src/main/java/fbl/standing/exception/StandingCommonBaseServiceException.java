package fbl.standing.exception;

import org.springframework.http.HttpStatus;

/**
 * StandingCommonBaseServiceException.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 *
 */

public class StandingCommonBaseServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = "Oops! something went wrong here";
	private final HttpStatus status;
	private Throwable throwable;

	/**
	 * 
	 */
	public StandingCommonBaseServiceException(final String message, final HttpStatus status) {
		super(message);
		this.message = message;
		this.status = status;
	}

	/**
	 * @param string
	 * @param internalServerError
	 * @param e
	 */
	public StandingCommonBaseServiceException(final String message, final HttpStatus status, final Throwable th) {
		this(message, status);
		this.throwable = th;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}

}
