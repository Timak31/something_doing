package app.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(generator = "news_id")
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "preview")
    @Type(type = "text")
    private String preview;

    @Column(name = "text_body")
    @Type(type = "text")
    private String textBody;

    @Column(name = "picture_name")
    private String pictureName;

    public News() {
    }

    public News(String title, String preview, String textBody, String pictureName) {
        this.title = title;
        this.preview = preview;
        this.textBody = textBody;
        this.pictureName = pictureName;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", preview='" + preview + '\'' +
                ", textBody='" + textBody + '\'' +
                ", pictureName='" + pictureName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}
