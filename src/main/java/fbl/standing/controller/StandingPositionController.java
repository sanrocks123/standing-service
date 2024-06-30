package fbl.standing.controller;

import fbl.standing.dto.StandingPositionRequestDTO;
import fbl.standing.dto.StandingPositionResponseDTO;
import fbl.standing.service.StandingPositionService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * StandingPositionController.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class StandingPositionController {

    @Autowired private StandingPositionService positionSvc;

    /**
     * @return
     */
    @GetMapping("/position")
    public ResponseEntity<StandingPositionResponseDTO> findPosition(
            @RequestParam final String countryName,
            @RequestParam final String leagueName,
            @RequestParam final String teamName) {

        final StandingPositionRequestDTO request =
                new StandingPositionRequestDTO(countryName, leagueName, teamName);

        final StandingPositionResponseDTO response = positionSvc.findPosition(request);
        return new ResponseEntity<>(
                response, Objects.isNull(response) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
}
