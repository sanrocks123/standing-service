package fbl.standing.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * StandingErrorResponseDTO.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 *
 */

public class StandingErrorResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String errorMessage;
    private HttpStatus status;
    private String remedy;
    private String errorCode;

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @return the remedy
     */
    public String getRemedy() {
        return remedy;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @param errorMessage
     *            the errorMessage to set
     */
    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @param remedy
     *            the remedy to set
     */
    public void setRemedy(final String remedy) {
        this.remedy = remedy;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

}
