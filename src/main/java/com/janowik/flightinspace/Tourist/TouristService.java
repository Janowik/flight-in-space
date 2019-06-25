package com.janowik.flightinspace.Tourist;

import com.janowik.flightinspace.Model.Tourist;
import org.springframework.stereotype.Service;

@Service("touristService")
public interface TouristService {
    void saveTourist(Tourist tourist);
    void deleteTourist(Long id);
    void updateTourist(Long id, Tourist tourist);
    Tourist findTouristById(Long id);
}
