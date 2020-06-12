package com.example.demo.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.entity.Room;
import com.example.demo.data.repository.RoomRepository;

@Service
public class RoomDataService {
	private final RoomRepository roomRepository;
	
	public RoomDataService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public List<Room> getRoomsList(){
		List<Room> roomList = new ArrayList<>();
        Iterator<Room> it=this.roomRepository.findAll().iterator();
        while(it.hasNext()) {
       	 roomList.add(it.next());
        }
        return roomList;
    }
	
	public Room getRoomDetails(long id){
		Room room = this.roomRepository.findById(id).orElse(null);
		return room;
	}
	
	public Room saveRoom(Room roomEntity){
        
        	roomEntity = roomRepository.save(roomEntity);
            return roomEntity;
    	}
	}
