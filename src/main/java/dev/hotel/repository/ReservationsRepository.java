package dev.hotel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Reservation;

public interface ReservationsRepository extends JpaRepository<Reservation, UUID> {

}
