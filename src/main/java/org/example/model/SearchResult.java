package org.example.model;

import java.util.List;

public class SearchResult {
     private String id;
     private String title;
     private String img;
     private ImageSize imageSize;
     private String date;
     private Integer videoLength;
     private direcTor director;

     private proDucer producer;

     private pubLisher publisher;
     private seRies series;

     private List<genRes> genres;

     private List<stArs> stars;

     private List<magNets> magnets;

     private List<samPles> samples;

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getImg() {
          return img;
     }

     public void setImg(String img) {
          this.img = img;
     }

     public ImageSize getImageSize() {
          return imageSize;
     }

     public void setImageSize(ImageSize imageSize) {
          this.imageSize = imageSize;
     }

     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public Integer getVideoLength() {
          return videoLength;
     }

     public void setVideoLength(Integer videoLength) {
          this.videoLength = videoLength;
     }

     public direcTor getDirector() {
          return director;
     }

     public void setDirector(direcTor director) {
          this.director = director;
     }

     public proDucer getProducer() {
          return producer;
     }

     public void setProducer(proDucer producer) {
          this.producer = producer;
     }

     public pubLisher getPublisher() {
          return publisher;
     }

     public void setPublisher(pubLisher publisher) {
          this.publisher = publisher;
     }

     public seRies getSeries() {
          return series;
     }

     public void setSeries(seRies series) {
          this.series = series;
     }

     public List<genRes> getGenres() {
          return genres;
     }

     public void setGenres(List<genRes> genres) {
          this.genres = genres;
     }

     public List<stArs> getStars() {
          return stars;
     }

     public void setStars(List<stArs> stars) {
          this.stars = stars;
     }

     public List<magNets> getMagnets() {
          return magnets;
     }

     public void setMagnets(List<magNets> magnets) {
          this.magnets = magnets;
     }

     public List<samPles> getSamples() {
          return samples;
     }

     public void setSamples(List<samPles> samples) {
          this.samples = samples;
     }
}
