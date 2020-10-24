package fbl.standing.dto;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * StandingCountryDTO.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingCountryDTO {

	@JsonProperty("country_id")
	private String countryId;

	@JsonProperty("country_name")
	private String countryName;

	/**
	 * @return the countryId
	 */
	public String getCountryId() {
		return countryId;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(final String countryId) {
		this.countryId = countryId;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(final String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}

}
