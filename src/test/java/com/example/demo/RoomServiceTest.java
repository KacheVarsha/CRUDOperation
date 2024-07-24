package com.example.demo;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;
    @InjectMocks
    private RoomService roomService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetAllRoom(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1L,101,"standard", 100.0,true));
        rooms.add(new Room(2L,102,"standard",500.0,false));
        when(roomRepository.findAll()).thenReturn(rooms);
        List<Room> result =  roomService.getAllRooms();

       assertEquals(2, result.size());
       assertEquals(102, result.get(1).getRoomNumber());
       assertEquals(100.0, result.get(0).getPrice());
       assertNotEquals(3L, result.get(0).getId());
    }
    @Test
    public void testGetRoomById(){
        Room room = new Room(1L,101,"standard", 100.0,true);
        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));

        Room result = roomService.getRoomById(1L);
        assertEquals(1L, result.getId());
        assertNotEquals(200.0, result.getRoomNumber());
    }
    @Test
    public void testSaveOrUpdateRoom(){
        Room room = new Room(1L,101,"standard", 100.0,true);
        when(roomRepository.save(room)).thenReturn(room);

        Room result = roomService.saveOrUpdateRoom(room);
        assertEquals(101, result.getRoomNumber());

    }
}
