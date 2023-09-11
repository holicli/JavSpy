package org.example.model;

import java.util.List;

public class pagination {
     private Integer currentPage;
     private Boolean hasNextPage;
     private Integer nextPage;
     private List<Integer> pages;

     public Integer getCurrentPage() {
          return currentPage;
     }

     public void setCurrentPage(Integer currentPage) {
          this.currentPage = currentPage;
     }

     public Boolean getHasNextPage() {
          return hasNextPage;
     }

     public void setHasNextPage(Boolean hasNextPage) {
          this.hasNextPage = hasNextPage;
     }

     public Integer getNextPage() {
          return nextPage;
     }

     public void setNextPage(Integer nextPage) {
          this.nextPage = nextPage;
     }

     public List<Integer> getPages() {
          return pages;
     }

     public void setPages(List<Integer> pages) {
          this.pages = pages;
     }
}
