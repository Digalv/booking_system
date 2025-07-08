package com.booking.booking.Repository;

import com.booking.booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    // 1) «предыдущее» бронирование по времени
     Optional<Booking> findTopByStartTimeLessThanEqualOrderByStartTimeDesc(
            LocalDateTime candidateStart
    );


     Optional<Booking> findTopByStartTimeGreaterThanEqualOrderByStartTimeAsc(
            LocalDateTime candidateEnd
    );

    default Optional<Booking> findPreviousByTime(LocalDateTime startTime){
        return findTopByStartTimeLessThanEqualOrderByStartTimeDesc(startTime);
    }
    default Optional<Booking> findNextByTime(LocalDateTime endTime){
        return findTopByStartTimeGreaterThanEqualOrderByStartTimeAsc(endTime);
    }
}
