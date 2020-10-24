package fbl.standing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fbl.standing.dto.StandingErrorResponseDTO;

/**
 * StandingExceptionAdvice.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 *
 */

@RestControllerAdvice
public class StandingExceptionHandler {

	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = StandingCommonBaseServiceException.class)
	public ResponseEntity<StandingErrorResponseDTO> handleStandingException(
			final StandingCommonBaseServiceException ex) {

		final StandingErrorResponseDTO response = new StandingErrorResponseDTO();
		response.setErrorMessage(ex.getMessage());
		response.setStatus(ex.getStatus());
		return new ResponseEntity<StandingErrorResponseDTO>(response, ex.getStatus());
	}

	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<StandingErrorResponseDTO> handleStandingException(final Throwable ex) {

		final StandingErrorResponseDTO response = new StandingErrorResponseDTO();
		response.setErrorMessage(ex.getMessage());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<StandingErrorResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
