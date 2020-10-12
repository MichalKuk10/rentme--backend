package com.codecool.dao;
import com.codecool.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface ReservationRepository extends JpaRepository<Reservation, Long> {

        Reservation getReservationsById(long id);

        Reservation deleteReservationById(long id);

    List<Reservation> findReservationByUser (Long appUserId);
}
