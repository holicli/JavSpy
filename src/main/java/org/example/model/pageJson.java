package org.example.model;

import java.util.List;

public class pageJson {
     private movies movies;
     private pagination pagination;

     public org.example.model.movies getMovies() {
          return movies;
     }

     public void setMovies(org.example.model.movies movies) {
          this.movies = movies;
     }

     public org.example.model.pagination getPagination() {
          return pagination;
     }

     public void setPagination(org.example.model.pagination pagination) {
          this.pagination = pagination;
     }
}
