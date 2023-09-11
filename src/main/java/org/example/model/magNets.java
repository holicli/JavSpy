package org.example.model;

public class magNets {
     private String id;
     private String name;
     private String link;
     private Boolean isHD;
     private String title;
     private String size;
     private Double numberSize;
     private String shareDate;
     private Boolean hasSubtitle;

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getLink() {
          return link;
     }

     public void setLink(String link) {
          this.link = link;
     }

     public Boolean getHD() {
          return isHD;
     }

     public void setHD(Boolean HD) {
          isHD = HD;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getSize() {
          return size;
     }

     public void setSize(String size) {
          this.size = size;
     }

     public Double getNumberSize() {
          return numberSize;
     }

     public void setNumberSize(Double numberSize) {
          this.numberSize = numberSize;
     }

     public String getShareDate() {
          return shareDate;
     }

     public void setShareDate(String shareDate) {
          this.shareDate = shareDate;
     }

     public Boolean getHasSubtitle() {
          return hasSubtitle;
     }

     public void setHasSubtitle(Boolean hasSubtitle) {
          this.hasSubtitle = hasSubtitle;
     }
}
