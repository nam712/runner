package com.sCore.modules.ktx.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RoomStudentDTO {
    private String roomCode;
    private String studentCode;
    private String studentFullname;
    private Date dateOfBirth;
    private String address;
    private Integer gender;
    private String phoneNumber;
    private String classroomCode;
    private String contractCode;
}
