package com.bl.minisms.model;

import java.io.Serializable;

public class StudentContact implements Serializable {

    private Long id;
    private Long stuId;
    private Long contId;

    public StudentContact(Long stuId, Long contId) {
        this.stuId = stuId;
        this.contId = contId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getContId() {
        return contId;
    }

    public void setContId(Long contId) {
        this.contId = contId;
    }
}
