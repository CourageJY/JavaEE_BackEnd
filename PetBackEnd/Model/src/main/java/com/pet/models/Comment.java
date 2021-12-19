package com.pet.models;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "comment", indexes = {
        @Index(name = "user_ID", columnList = "user_ID")
})
@Entity
public class Comment {
    @EmbeddedId
    private CommentId id;

    @Column(name = "time")
    private Instant time;

    @Column(name = "content", length = 100)
    private String content;

    @Column(name = "status", length = 6)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public CommentId getId() {
        return id;
    }

    public void setId(CommentId id) {
        this.id = id;
    }
}