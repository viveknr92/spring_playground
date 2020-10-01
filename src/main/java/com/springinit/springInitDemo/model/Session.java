package com.springinit.springInitDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;
    @Column(name = "session_name")
    private String sessionName;
    @Column(name = "session_description")
    private String sessionDescription;
    @Column(name = "session_length")
    private Integer sessionLength;
    public Session() {
    }
    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Long getSession_id() {
        return sessionId;
    }

    public void setSession_id(Long session_id) {
        this.sessionId = session_id;
    }

    public String getSession_name() {
        return sessionName;
    }

    public void setSession_name(String session_name) {
        this.sessionName = session_name;
    }

    public String getSession_description() {
        return sessionDescription;
    }

    public void setSession_description(String session_description) {
        this.sessionDescription = session_description;
    }

    public Integer getSession_length() {
        return sessionLength;
    }

    public void setSession_length(Integer session_length) {
        this.sessionLength = session_length;
    }

    @Override
    public String toString() {
        return "Session{" +
                "session_id=" + sessionId +
                ", session_name='" + sessionName + '\'' +
                ", session_description='" + sessionDescription + '\'' +
                ", session_length=" + sessionLength +
//                ", speakers=" + speakers +
                '}';
    }
}
