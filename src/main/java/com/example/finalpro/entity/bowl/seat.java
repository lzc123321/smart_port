package com.example.finalpro.entity.bowl;

import javax.persistence.Entity;

@Entity
public class seat {
    private Integer seatid;

    private Integer occupied;

    public seat(Integer seatid,Integer occupied){
        this.seatid = seatid;
        this.occupied = occupied;
    }

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }
}
