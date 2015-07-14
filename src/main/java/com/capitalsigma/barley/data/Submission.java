package com.capitalsigma.barley.data;

import java.util.Date;

/**
 * Created by patrick on 7/14/15.
 */
public class Submission {
    public enum SubmissionType {
        SelfPost,
        LinkPost;
    }

    private int id;
    private int commentCount;
    private Date date;
    private int upVotes;
    private int downVotes;
    private Date lastEditDate; // nullable
    private int views;
    private String userName;
    private String subverse;
    private String thumbnail;
    private String title;
    private SubmissionType type;
    private String url;
    private String content;
    private String formattedContent;

    public Submission() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Submission that = (Submission) o;

        if (id != that.id) return false;
        if (commentCount != that.commentCount) return false;
        if (upVotes != that.upVotes) return false;
        if (downVotes != that.downVotes) return false;
        if (views != that.views) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (lastEditDate != null ? !lastEditDate.equals(that.lastEditDate) : that.lastEditDate != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (subverse != null ? !subverse.equals(that.subverse) : that.subverse != null) return false;
        if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (type != that.type) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return !(formattedContent != null ? !formattedContent.equals(
                that.formattedContent) : that.formattedContent != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + commentCount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + upVotes;
        result = 31 * result + downVotes;
        result = 31 * result + (lastEditDate != null ? lastEditDate.hashCode() : 0);
        result = 31 * result + views;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (subverse != null ? subverse.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (formattedContent != null ? formattedContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "id=" + id +
                ", commentCount=" + commentCount +
                ", date=" + date +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", lastEditDate=" + lastEditDate +
                ", views=" + views +
                ", userName='" + userName + '\'' +
                ", subverse='" + subverse + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", formattedContent='" + formattedContent + '\'' +
                '}';
    }
}
