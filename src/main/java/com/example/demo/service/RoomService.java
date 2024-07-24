package com.example.demo.service;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
       return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room Not Available"));
    }

    public List<Room> getAvailableRooms(){
        return roomRepository.findByAvailable(true);
    }

    public Room saveOrUpdateRoom(Room room){
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }

    public List<Room> getRoomsByHotelId(Long id){
        return roomRepository.findAllByHotelId(id);
    }

}
