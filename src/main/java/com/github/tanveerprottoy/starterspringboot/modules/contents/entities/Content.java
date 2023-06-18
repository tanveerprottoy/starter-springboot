package com.github.tanveerprottoy.starterspringboot.modules.contents.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String detail;

    public Content() {
    }

    @Override
    public String toString() {
        return String.format(
                "Content[id=%d, title='%s', detail='%s']",
                id, title, detail);
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }    
}
