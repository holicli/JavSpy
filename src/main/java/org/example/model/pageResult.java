package org.example.model;

import java.util.List;

public class pageResult {
     private List<movies> movies;

     private pagination pagination;

     public List<org.example.model.movies> getMovies() {
          return movies;
     }

     public void setMovies(List<org.example.model.movies> movies) {
          this.movies = movies;
     }

     public org.example.model.pagination getPagination() {
          return pagination;
     }

     public void setPagination(org.example.model.pagination pagination) {
          this.pagination = pagination;
     }
}
