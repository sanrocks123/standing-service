package fbl.standing.service;

import fbl.standing.dto.StandingPositionRequestDTO;
import fbl.standing.dto.StandingPositionResponseDTO;

/**
 * StandingPositionService.java created on Sep 13, 2020
 *
 * @author sanjeevkumar.saxena
 * @since 1.0
 */
public interface StandingPositionService {

    /**
     * @param request
     * @return
     */
    StandingPositionResponseDTO findPosition(StandingPositionRequestDTO request);
}
