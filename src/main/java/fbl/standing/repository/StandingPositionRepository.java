package fbl.standing.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fbl.standing.dto.StandingCountryDTO;
import fbl.standing.dto.StandingPositionResponseDTO;
import fbl.standing.exception.StandingCommonBaseServiceException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * StandingPositionRepository.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 */
@Repository
public class StandingPositionRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired private RestTemplate restSvc;

    @Value("${fbl.footbal.api}")
    private String footballAPI;

    private final Object lock = new Object();
    private List<StandingCountryDTO> countries = null;

    /**
     * countries looks to be fixed and so can be lazily loaded at runtime and reused in every API
     * call.
     *
     * <p>If we make this as singleton, we then get tightly coupled to football API service and can
     * have cascading effects on our service. So if football API service is down, our service would
     * fail to startup impacting other APIs too
     *
     * <p>Making this runtime lazy load avoids this dependency and ensure service startups quickly
     * with no startup dependencies
     *
     * @return
     */
    public List<StandingCountryDTO> getCountries() {

        if (Objects.isNull(countries)) {
            synchronized (lock) {
                if (Objects.isNull(countries)) {

                    final String url = String.format("%s&action=get_countries", footballAPI);
                    final String apiResponse = restSvc.getForObject(url, String.class);

                    log.debug(
                            "getCountries, apiResponse: {}", new JSONArray(apiResponse).toString());

                    try {
                        countries =
                                new ObjectMapper()
                                        .readValue(
                                                apiResponse,
                                                new TypeReference<List<StandingCountryDTO>>() {});
                        log.debug("getCountries, result: {} {}", countries.size(), countries);

                    } catch (final IOException e) {
                        throw new StandingCommonBaseServiceException(
                                "json object conversion error",
                                HttpStatus.INTERNAL_SERVER_ERROR,
                                e);
                    }
                }
            }
        }
        return countries;
    }

    /**
     * Get Leagues BY Country ID
     *
     * @param countryId
     * @return
     */
    public List<StandingPositionResponseDTO> getLeaguesByCountryId(final String countryId) {
        final String url =
                String.format("%s&action=get_leagues&country_id=%s", footballAPI, countryId);
        final String apiResponse = restSvc.getForObject(url, String.class);
        log.debug("getLeaguesByCountryId, apiResponse: {}", new JSONArray(apiResponse).toString());

        try {
            final List<StandingPositionResponseDTO> leagues =
                    new ObjectMapper()
                            .readValue(
                                    apiResponse,
                                    new TypeReference<List<StandingPositionResponseDTO>>() {});

            log.debug(
                    "getLeaguesByCountryId, countryId: {}, leagues: {} {}",
                    countryId,
                    leagues.size(),
                    leagues);
            return leagues;

        } catch (final IOException e) {
            throw new StandingCommonBaseServiceException(
                    "json object conversion error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    /**
     * Get Standings by League ID
     *
     * @param request
     * @return
     */
    public List<StandingPositionResponseDTO> getStandingsByLeagueId(final String leagueId) {

        final String url =
                String.format("%s&action=get_standings&league_id=%s", footballAPI, leagueId);
        final String apiResponse = restSvc.getForObject(url, String.class);
        log.debug("getStandingsByLeagueId, apiResponse: {}", new JSONArray(apiResponse).toString());

        try {
            final List<StandingPositionResponseDTO> standings =
                    new ObjectMapper()
                            .readValue(
                                    apiResponse,
                                    new TypeReference<List<StandingPositionResponseDTO>>() {});

            log.debug(
                    "getStandingsByLeagueId, leagueId: {}, standings: {} {}",
                    leagueId,
                    standings.size(),
                    standings);
            return standings;

        } catch (final IOException e) {
            throw new StandingCommonBaseServiceException(
                    "json object conversion error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
}
