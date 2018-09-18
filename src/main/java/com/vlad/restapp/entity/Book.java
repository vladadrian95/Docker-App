package com.vlad.restapp.entity;

import io.swagger.annotations.ApiModelProperty;

public class Book {

    @ApiModelProperty(notes = "Book's unique ID")
    private int id;
    @ApiModelProperty(notes = "Book's title")
    private String title;
    @ApiModelProperty(notes = "Book's author")
    private String author;

    public int getId() {
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

    public int hashCode() {

        return this.id * 3 + this.title.hashCode() * 5 + this.author.hashCode() * 7;

    }

}
