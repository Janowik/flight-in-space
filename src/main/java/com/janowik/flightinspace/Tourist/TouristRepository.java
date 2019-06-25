package com.janowik.flightinspace.Tourist;

import com.janowik.flightinspace.Model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {
    Tourist findTouristById(Long id);
}
