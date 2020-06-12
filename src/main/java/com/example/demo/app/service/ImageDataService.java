package com.example.demo.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.data.entity.RoomImage;
import com.example.demo.data.repository.ImageRepository;

@Service
public class ImageDataService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public List<RoomImage> getRoomImagesList(){
		List<RoomImage> roomImagesList = new ArrayList<>();
        Iterator<RoomImage> it=this.imageRepository.findAll().iterator();
        while(it.hasNext()) {
        	roomImagesList.add(it.next());
        }
        return roomImagesList;
    }
	
	public void saveImage(MultipartFile file) throws IOException{
		 String encodedString = encodeString(file.getBytes());
	     RoomImage img = new RoomImage();
	     img.setName(file.getOriginalFilename());
	     img.setType(file.getContentType());
	     img.setBase64Value(encodedString);
	     imageRepository.save(img);
	}
	
	public RoomImage getImage(long id) {
		RoomImage img = imageRepository.findById(id).orElse(null);
		return img;
	}	
	
	public String encodeString(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}

	public byte[] decodeString(String encodedString) {
		return Base64.getDecoder().decode(encodedString);
	}
}
