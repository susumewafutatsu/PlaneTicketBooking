package com.example.plane_ticket_booking.Model;

import java.io.Serializable;

public class Flight implements Serializable {
    private String airLineLogo;
    private String airLineName;
    private String airLineTime;
    private String classSeat;
    private String date;
    private String from;
    private String fromShort;
    private Integer numberSeat;
    private Double price;
    private String passenger;
    private String seats;
    private String reservedSeats;
    private String time;
    private String to;
    private String toShort;
    public Flight(){
    }


    @Override
    public String toString() {
        return from;
    }

    public String getAirLineLogo() {
        return airLineLogo;
    }

    public void setAirLineLogo(String airLineLogo) {
        this.airLineLogo = airLineLogo;
    }

    public String getAirLineName() {
        return airLineName;
    }

    public void setAirLineName(String airLineName) {
        this.airLineName = airLineName;
    }

    public String getAirLineTime() {
        return airLineTime;
    }

    public void setAirLineTime(String airLineTime) {
        this.airLineTime = airLineTime;
    }

    public String getClassSeat() {
        return classSeat;
    }

    public void setClassSeat(String classSeat) {
        this.classSeat = classSeat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromShort() {
        return fromShort;
    }

    public void setFromShort(String fromShort) {
        this.fromShort = fromShort;
    }

    public Integer getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(Integer numberSeat) {
        this.numberSeat = numberSeat;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(String reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToShort() {
        return toShort;
    }

    public void setToShort(String toShort) {
        this.toShort = toShort;
    }
}
