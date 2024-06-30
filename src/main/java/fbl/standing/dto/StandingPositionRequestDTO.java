package fbl.standing.dto;

/**
 * StandingPositionRequestDTO.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 */
public class StandingPositionRequestDTO {

    private String countryName;
    private String leagueName;
    private String teamName;

    /**
     * @param countryName
     * @param leagueName
     * @param teamName
     */
    public StandingPositionRequestDTO(String countryName, String leagueName, String teamName) {
        this.countryName = countryName;
        this.leagueName = leagueName;
        this.teamName = teamName;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @return the leagueName
     */
    public String getLeagueName() {
        return leagueName;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @param leagueName the leagueName to set
     */
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
