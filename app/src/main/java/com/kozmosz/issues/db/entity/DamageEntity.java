package com.kozmosz.issues.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.kozmosz.issues.db.converter.PriorityEnumConverter;
import com.kozmosz.issues.db.converter.StatusEnumConverter;
import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.model.PriorityEnum;
import com.kozmosz.issues.model.StatusEnum;

import java.util.List;

@Entity(tableName = "damage")
public class DamageEntity {

    @PrimaryKey
            (autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "priority")
    @TypeConverters({PriorityEnumConverter.class})
    private PriorityEnum priority;

    @ColumnInfo(name = "roomNumber")
    private Integer roomNumber;

    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "status")
    @TypeConverters({StatusEnumConverter.class})
    private StatusEnum status;

    @ColumnInfo(name = "reportDate")
    private Long reportDate;

    @Ignore
    private List<ToolEntity> tools;

    public DamageEntity() {
    }

    public DamageEntity(DamageDTO damageDTO) {
        setId(damageDTO.getId());
        setComment(damageDTO.getComment());
        setDescription(damageDTO.getDescription());
        setPriority(damageDTO.getPriority());
        setReportDate(damageDTO.getReportDate());
        setRoomNumber(damageDTO.getRoomNumber());
        setTitle(damageDTO.getTitle());
        setStatus(damageDTO.getStatus());
//        setTools(damageDTO.getTools());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Long getReportDate() {
        return reportDate;
    }

    public void setReportDate(Long reportDate) {
        this.reportDate = reportDate;
    }

    public List<ToolEntity> getTools() {
        return tools;
    }

    public void setTools(List<ToolEntity> tools) {
        this.tools = tools;
    }
}
