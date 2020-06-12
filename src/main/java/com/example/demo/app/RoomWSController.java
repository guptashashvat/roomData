package com.example.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.service.RoomDataService;
import com.example.demo.data.entity.Room;

@RestController
@RequestMapping("/rooms")
public class RoomWSController{
    @Autowired
    private RoomDataService service;

    @GetMapping
    public ResponseEntity<List<Room>> getRoomsList(){
		List<Room> roomList = service.getRoomsList();
        return new ResponseEntity<List<Room>>(roomList, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable("id") long id){
		Room room = service.getRoomDetails(id);
        return new ResponseEntity<Room>(room, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Room> createRoom(@RequestBody Room roomEntity){
		Room room = service.saveRoom(roomEntity);
        return new ResponseEntity<Room>(room, new HttpHeaders(), HttpStatus.OK);
    }
}

