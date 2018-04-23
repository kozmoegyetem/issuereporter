package hu.viktorkozma.issuereport.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class Issue {

    @SerializedName("id")
    private Long id = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("comment")
    private String comment = null;


    @SerializedName("description")
    private String description = null;




    public enum StatusEnum {
        @SerializedName("escalated")
        ESCALATED("escalated"),

        @SerializedName("closed")
        CLOSED("closed");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("reportDate")
    private Long reportDate = null;

    @SerializedName("tools")
    private List<String> tools = new ArrayList<String>();


    /**
     **/
    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     **/
    @ApiModelProperty(required = true, value = "")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     **/
    @ApiModelProperty(required = true, value = "")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    /**
     **/
    @ApiModelProperty(value = "")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public Long getReportDate() {
        return reportDate;
    }

    public void setReportDate(Long reportDate) {
        this.reportDate = reportDate;
    }


    /**
     **/
    @ApiModelProperty(value = "")
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
        Issue issue = (Issue) o;
        return id.equals(issue.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Damage {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    reportDate: ").append(toIndentedString(reportDate)).append("\n");
        sb.append("    tools: ").append(toIndentedString(tools)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
