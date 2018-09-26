package com.vlad.restapp.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    @ApiModelProperty(notes = "Book's unique ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(notes = "Book's title")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(notes = "Book's author")
    @Column(name = "author")
    private String author;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Book))
            return false;

        if (this.id == ((Book) object).getId() && this.title.equals(((Book) object).getTitle()) && this.author.equals(((Book) object).getAuthor()))
            return true;
        else
            return false;

    }

}
