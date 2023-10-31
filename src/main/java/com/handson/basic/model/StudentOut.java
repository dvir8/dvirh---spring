package com.handson.basic.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.handson.basic.util.AWSService;
import com.handson.basic.util.Dates;
import org.joda.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;

@Entity
@SqlResultSetMapping(name = "StudentOut")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentOut {

    @Id
    private Long id;

    private Date createdat;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdat")
    public LocalDateTime calcCreatedAt() {
        return Dates.atLocalTime(createdat);
    }

    private String fullname;
    private Date birthdate;
    private String Emails;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("birthdate")
    public LocalDateTime calcBirthDate() {
        return Dates.atLocalTime(birthdate);
    }
    public static StudentOut of(Student student, AWSService awsService) {
        StudentOut res = new StudentOut();
        res.id = student.getId();
        res.createdat = student.getCreatedAt();
        res.fullname = student.getFullname();
        res.birthdate = student.getBirthDate();
        res.satscore = student.getSatScore();
        res.graduationscore = student.getGraduationScore();
        res.phone = student.getPhone();
        res.profilepicture = awsService.generateLink(student.getProfilePicture());
        res.Emails = student.getEmail();
        res.avgscore = null;
        return res;
    }
    private Integer satscore;
    private Double graduationscore;

    private String phone;
    private String profilepicture;
    private Double avgscore;

    public Integer getSatscore() {
        return satscore;
    }

    public Double getGraduationscore() {
        return graduationscore;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public Double getAvgscore() {
        return avgscore;
    }





    public Date getCreatedat() {
        return createdat;
    }

    public String getFullname() {
        return fullname;
    }

    public Date getBirthdate() {
        return birthdate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfilePicture() {
        return profilepicture;
    }
}