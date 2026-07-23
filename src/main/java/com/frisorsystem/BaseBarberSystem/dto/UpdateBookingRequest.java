package com.frisorsystem.BaseBarberSystem.dto;

public class UpdateBookingRequest {

    private String status;
    private Long timeSlotId;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }
}