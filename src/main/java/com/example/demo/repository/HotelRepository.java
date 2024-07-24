package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT h FROM Hotel h LEFT JOIN FETCH h.rooms where h.id = :id")
    Optional<Hotel> findByIdWithRooms(@Param("id") Long id);


}