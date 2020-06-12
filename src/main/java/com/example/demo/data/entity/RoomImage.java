package com.example.demo.data.entity;
import javax.persistence.*;
@Entity
@Table(name = "ROOM_IMAGES")
public class RoomImage {
    @Id
    @Column(name = "IMAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
	/*
	 * @Column(name = "IMAGE_BYTE", length = 1000) private byte[] picByte;
	 */
    @Column(name = "BASE64_VAL")
    private String base64String;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

   public void setType(String type) {
        this.type = type;
    }

	/*
	 * public byte[] getPicByte() { return picByte; }
	 * 
	 * public void setPicByte(byte[] picByte) { this.picByte = picByte; }
	 */
    
    public String getBase64Value() {
        return base64String;
    }

   public void setBase64Value(String base64String) {
        this.base64String = base64String;
    }
}