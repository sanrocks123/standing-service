package fbl.standing.dto;

import java.io.Serializable;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * StandingPositionResponseDTO.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingPositionResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("country_id")
	private String countryId;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("team_id")
	private String teamId;

	@JsonProperty("team_name")
	private String teamName;

	@JsonProperty("league_id")
	private String leagueId;

	@JsonProperty("league_name")
	private String leagueName;

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
	 * @return the leagueId
	 */
	public String getLeagueId() {
		return leagueId;
	}

	/**
	 * @return the leagueName
	 */
	public String getLeagueName() {
		return leagueName;
	}

	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
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

	/**
	 * @param leagueId the leagueId to set
	 */
	public void setLeagueId(final String leagueId) {
		this.leagueId = leagueId;
	}

	/**
	 * @param leagueName the leagueName to set
	 */
	public void setLeagueName(final String leagueName) {
		this.leagueName = leagueName;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(final String teamId) {
		this.teamId = teamId;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(final String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}

}
