package com.neu.entity;

public class GuestRoom {
private Integer id;
private String roomid;
private RoomType roomtype;
private Storey storey;
private Double price;
private Double dis;
private Double vipdis;
private Double svipdis;
private String roomstate;

public GuestRoom() {
	super();
	// TODO Auto-generated constructor stub
}
public GuestRoom(Integer id, String roomid, RoomType roomtype, Storey storey, Double price, Double dis, Double vipdis,
		Double svipdis, String roomstate) {
	super();
	this.id = id;
	this.roomid = roomid;
	this.roomtype = roomtype;
	this.storey = storey;
	this.price = price;
	this.dis = dis;
	this.vipdis = vipdis;
	this.svipdis = svipdis;
	this.roomstate = roomstate;
	
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getRoomid() {
	return roomid;
}
public void setRoomid(String roomid) {
	this.roomid = roomid;
}
public RoomType getRoomtype() {
	return roomtype;
}
public void setRoomtype(RoomType roomtype) {
	this.roomtype = roomtype;
}
public Storey getStorey() {
	return storey;
}
public void setStorey(Storey storey) {
	this.storey = storey;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Double getDis() {
	return dis;
}
public void setDis(Double dis) {
	this.dis = dis;
}
public Double getVipdis() {
	return vipdis;
}
public void setVipdis(Double vipdis) {
	this.vipdis = vipdis;
}
public Double getSvipdis() {
	return svipdis;
}
public void setSvipdis(Double svipdis) {
	this.svipdis = svipdis;
}
public String getRoomstate() {
	return roomstate;
}
public void setRoomstate(String roomstate) {
	this.roomstate = roomstate;
}
@Override
public String toString() {
	return "GuestRoom [id=" + id + ", roomid=" + roomid + ", roomtype=" + roomtype + ", storey=" + storey + ", price="
			+ price + ", dis=" + dis + ", vipdis=" + vipdis + ", svipdis=" + svipdis + ", roomstate=" + roomstate + "]";
}



}
