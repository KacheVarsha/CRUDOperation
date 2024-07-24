package com.example.demo.controller;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms(){
       return roomService.getAllRooms();
    }
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }
    @PostMapping
    public Room addRoom(@RequestBody Room room){
        return roomService.saveOrUpdateRoom(room);
    }
    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable Long id){
        room.setId(id);
        return roomService.saveOrUpdateRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
    }

    /*@GetMapping("/roomById/{roomId}")
    public List<Room> getHotelRoomsByHotelId(@PathVariable Long roomId) {
        List<Room> rooms = roomService.getRoomsByHotelId(roomId);
        if (!rooms.isEmpty()) {
            return rooms;
        } else {
            throw new RuntimeException("No Room present with" + +roomId);
        }
    }*/

    @GetMapping("/hotel-id/{hotelId}")
    public List<Room> getHotelWithRoomsByIdHotelId(@PathVariable Long hotelId){
        List<Room> rooms = roomService.getRoomsByHotelId(hotelId);
        if(!CollectionUtils.isEmpty(rooms)){
            return rooms;
        }
        else{
            throw new RuntimeException("No hotel present with" + + hotelId );
        }
    }


}
