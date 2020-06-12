package com.example.demo.app;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.app.service.ImageDataService;
import com.example.demo.data.entity.RoomImage;

@RestController
@RequestMapping("/roomImages")
public class ImageWSController {
	 @Autowired
	 private ImageDataService service;
	 
	 @GetMapping
	 public ResponseEntity<List<RoomImage>> getImageList(){
		 List<RoomImage> roomImgList = this.service.getRoomImagesList();
		 return new ResponseEntity<List<RoomImage>>(roomImgList, new HttpHeaders(), HttpStatus.OK);
	 }
	 
	 @PostMapping("/upload")
     public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		 System.out.println("filename: "+file.getOriginalFilename());
		 service.saveImage(file);
		 return ResponseEntity.status(HttpStatus.OK);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Resource> getById(@PathVariable("id") long id){
		 RoomImage image = service.getImage(id);
		 return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(image.getType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
	                .body(new ByteArrayResource(service.decodeString(image.getBase64Value())));
	 }
}
