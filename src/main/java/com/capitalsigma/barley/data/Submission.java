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
}
