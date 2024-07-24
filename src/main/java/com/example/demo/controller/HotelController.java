package com.example.demo.controller;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels(){
       return hotelService.getAllHotels();
    }
    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.saveOrUpdateHotel(hotel);
    }
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }
    @PutMapping("/{id}")
    public Hotel updateHotel(@RequestBody Hotel hotel, @PathVariable Long id){
        hotel.setId(id);
        return hotelService.saveOrUpdateHotel(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
    }



}
