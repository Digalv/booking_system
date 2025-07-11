package com.booking.booking.Repository;

import com.booking.booking.models.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfferingRepository extends JpaRepository<Offering, UUID> {
    Optional<Offering> findById(UUID id);
    boolean existsByTitle(String title);
}
