package com.example.demo.service;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels(){
       return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(hotel.isPresent()) {
            return hotel.get();
        }else {
            throw new RuntimeException("No hotel is present with ID" + id);
        }
    }

    public Hotel saveOrUpdateHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id){
        hotelRepository.deleteById(id);
    }

    public Hotel getHotelByIdWithRooms(Long id){
        Optional<Hotel> hotel = hotelRepository.findByIdWithRooms(id);
            return hotel.orElseThrow(() -> new RuntimeException("No hotel present with given ID" + id));
    }

}
