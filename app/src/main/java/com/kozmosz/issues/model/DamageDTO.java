package com.kozmosz.issues.model;

import com.google.gson.annotations.SerializedName;
import com.kozmosz.issues.db.entity.DamageEntity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class DamageDTO {

    @SerializedName("id")
    private Long id = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("priority")
    private PriorityEnum priority = null;

    @SerializedName("roomNumber")
    private Integer roomNumber = null;

    @SerializedName("comment")
    private String comment = null;

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("reportDate")
    private Long reportDate = null;

    @SerializedName("tools")
    private List<String> tools = new ArrayList<>();

    public DamageDTO() {
    }

    public DamageDTO(DamageEntity entity) {
        setId(entity.getId());
        setComment(entity.getComment());
        setDescription(entity.getDescription());
        setPriority(entity.getPriority());
        setReportDate(entity.getReportDate());
        setRoomNumber(entity.getRoomNumber());
        setStatus(entity.getStatus());
        setTitle(entity.getTitle());
//        setTools();
    }

    /**
     **/
    @ApiModelProperty()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     **/
    @ApiModelProperty(required = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     **/
    @ApiModelProperty(required = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     **/
    @ApiModelProperty(required = true)
    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }


    /**
     **/
    @ApiModelProperty(required = true)
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }


    /**
     **/
    @ApiModelProperty()
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     **/
    @ApiModelProperty()
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    /**
     **/
    @ApiModelProperty()
    public Long getReportDate() {
        return reportDate;
    }

    public void setReportDate(Long reportDate) {
        this.reportDate = reportDate;
    }


    /**
     **/
    @ApiModelProperty()
    public List<String> getTools() {
        return tools;
    }

    public void setTools(List<String> tools) {
        this.tools = tools;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DamageDTO damage = (DamageDTO) o;
        return id.equals(damage.id);
    }
}