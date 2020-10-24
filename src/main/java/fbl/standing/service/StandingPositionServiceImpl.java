package fbl.standing.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fbl.standing.dto.StandingCountryDTO;
import fbl.standing.dto.StandingPositionRequestDTO;
import fbl.standing.dto.StandingPositionResponseDTO;
import fbl.standing.repository.StandingPositionRepository;

/**
 * StandingPositionServiceImpl.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 *
 */

@Service
public class StandingPositionServiceImpl implements StandingPositionService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private StandingPositionRepository positionRepo;

    /**
     *
     */
    @Override
    public StandingPositionResponseDTO findPosition(final StandingPositionRequestDTO request) {

        final Optional<StandingCountryDTO> country = positionRepo.getCountries().stream()
                .filter(c -> c.getCountryName().equalsIgnoreCase(request.getCountryName())).findAny();

        if (!country.isPresent()) {
            log.debug("findPosition, country {} not found", request.getCountryName());
            return null;
        }

        final Optional<StandingPositionResponseDTO> leagues = positionRepo
                .getLeaguesByCountryId(country.get().getCountryId()).stream()
                .filter(l -> l.getLeagueName().equalsIgnoreCase(request.getLeagueName())).findAny();

        if (!leagues.isPresent()) {
            log.debug("findPosition, leagues {} not found", request.getLeagueName());
            return null;
        }

        // season(leagueName) -> seasonName

        final Optional<StandingPositionResponseDTO> standing = positionRepo
                .getStandingsByLeagueId(leagues.get().getLeagueId()).stream()
                .filter(i -> i.getCountryName().equalsIgnoreCase(request.getCountryName())
                        && i.getLeagueName().equalsIgnoreCase(request.getLeagueName())
                        && i.getTeamName().equalsIgnoreCase(request.getTeamName()))
                .findAny();

        if (!standing.isPresent()) {
            log.debug("findPosition, standing not found");
            return null;
        }

        standing.get().setCountryId(country.get().getCountryId());
        log.debug("findPosition, result: {}", standing);

        return standing.get();
    }

}
