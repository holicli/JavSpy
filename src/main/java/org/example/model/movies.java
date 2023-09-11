package org.example.model;

import java.util.List;

public class movies {
     private String date;
     private String id;
     private String img;
     private String title;
     private List<String> tags;

     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getImg() {
          return img;
     }

     public void setImg(String img) {
          this.img = img;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public List<String> getTags() {
          return tags;
     }

     public void setTags(List<String> tags) {
          this.tags = tags;
     }
}
