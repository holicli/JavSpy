package org.example;

import com.alibaba.fastjson.JSON;
import org.example.model.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final List<String> likeList = Arrays.asList(new String[]{"河北彩花",
            "波多野結衣","美谷朱里","JULIA","明里つむぎ","森沢かな","新ありな","桃乃木かな","神宮寺ナオ","希島あいり","小花のん","篠田ゆう","楓カレン"});

    private static final List<String> ids = Arrays.asList(new String[]{"sl1",
            "2jv","reg","2de","qs6","ef2","zk9","pmv","p6v","rtn","9pj","2pv","yoy","rki","u4m"});
    public static String getRequest(String urls) {
        try {
            // 创建URL对象
            URL url = new URL(urls);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法为 GET
            connection.setRequestMethod("GET");

            // 发送 GET 请求
            int responseCode = connection.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
            String urlstr = null;
            if (Objects.equals(responseCode,200)){
                // 读取响应内容
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                urlstr = response.toString();
            }
            // 输出响应内容
//            System.out.println("Response Body: " + response.toString());

            // 关闭连接
            connection.disconnect();
            return urlstr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urls;
    }
    public static Boolean isToday(String dateStr){
        LocalDate date = LocalDate.parse(dateStr);

//        LocalDate today = LocalDate.parse("2023-09-01");

        LocalDate today = LocalDate.parse("2022-12-10");
        if (date.isAfter(today)) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean goodSize(magNets magmets){
        String sizeStr = magmets.getSize();

        // 提取数字部分
        String numberString = sizeStr.replaceAll("[^\\d.]", "");

        // 转换为double类型
        double size = Double.parseDouble(numberString);

//        LocalDate toyear = LocalDate.parse("2023-01-01");
        if (size>=2D&&size<6D){
            return true;
        }
        return false;
    }
    public static void daily(Integer page){
        String fanhaoUrl = "http://192.168.0.120:33000/api/v1/movies/";
        String request = getRequest("http://192.168.0.120:33000/api/v1/movies?page="+page+"&magnet=exist");
        if (Objects.isNull(request)){
            return;
        }
        pageResult pageresult = JSON.parseObject(request, pageResult.class);
        List<movies> moviesList = pageresult.getMovies();
        if (moviesList.size()<0){
            return;
        }
        for (movies mm: moviesList){
            if (Objects.equals("",mm.getId()) || Objects.isNull(mm.getId())){
                continue;
            }
            if (!isToday(mm.getDate())){
                break;
            }
            String details = getRequest(fanhaoUrl + mm.getId());
            if (Objects.isNull(request)){
                return;
            }
            SearchResult searchResult = JSON.parseObject(details, SearchResult.class);
            List<magNets> mms  = searchResult.getMagnets();
            if (mms.size()>0){
                magNets magNetss  = new magNets();
                String magnet = magNetss.getLink();
                String size = magNetss.getSize();
                String isIs = "0";
                for (magNets magNet: searchResult.getMagnets()){
                    if (goodSize(magNet)){
                        magNetss = magNet;
                        isIs = "1";
                        break;
                    }
                }
//                System.out.println("<tr>");
//                System.out.print("<th>"+searchResult.getId()+"</th><th>"+searchResult.getDate()+"</th><th>"+magNetss.getLink()+"</th><th>"+magNetss.getLink()+"</th>");
//                System.out.println("<th>"+"<img style='width:5.25rem;height:5.25rem;margin:0 auto;display:block;background-position:0 0' src='"+searchResult.getImg()+"'>"+"</th>");
//                System.out.println("</tr>");
                System.out.println(magNetss.getLink());
            }
        }
    }

    public static void getByType(Integer page){
        String fanhaoUrl = "http://192.168.0.120:33000/api/v1/movies/";
        String request = getRequest("http://192.168.0.120:33000/api/v1/movies?page="+page+"&filterType=genre&filterValue=7x&magnet=exist");
        if (Objects.isNull(request)){
            return;
        }
        pageResult pageresult = JSON.parseObject(request, pageResult.class);
        List<movies> moviesList = pageresult.getMovies();
        if (moviesList.size()<0){
            return;
        }
        for (movies mm: moviesList){
            if (Objects.equals("",mm.getId()) || Objects.isNull(mm.getId())){
                continue;
            }
//            if (!isToday(mm.getDate())){
//                break;
//            }
            String details = getRequest(fanhaoUrl + mm.getId());
            if (Objects.isNull(request)){
                return;
            }
            SearchResult searchResult = JSON.parseObject(details, SearchResult.class);
            if (searchResult.getMagnets().size()>0){
                magNets magNetss  = searchResult.getMagnets().get(0);
                String magnet = magNetss.getLink();
                String size = magNetss.getSize();
                String isIs = "0";
                for (magNets magNet: searchResult.getMagnets()){
                    if (goodSize(magNet)){
                        magNetss = magNet;
                        isIs = "1";
                        break;
                    }
                }
                System.out.println("<tr>");
                System.out.print("<th>"+searchResult.getId()+"</th><th>"+searchResult.getDate()+"</th><th>"+magNetss.getLink()+"</th><th>"+magNetss.getLink()+"</th>");
                System.out.println("<th>"+"<img style='width:5.25rem;height:5.25rem;margin:0 auto;display:block;background-position:0 0' src='"+searchResult.getImg()+"'>"+"</th>");
                System.out.println("</tr>");
            }
        }
    }
    public static void search(String nyName) throws UnsupportedEncodingException {
        String searchUrl = "http://192.168.0.120:33000/api/v1/movies/search?";
//        http://192.168.0.120:33000/api/v1/movies/search?keyword=%E6%B2%B3%E5%8C%97%E5%BD%A9%E8%8A%B1&page=1&magnet=exist
        String fanhaoUrl = "http://192.168.0.120:33000/api/v1/movies/";
        String encode = URLEncoder.encode(nyName, "utf-8");
        String keyword = "keyword="+encode;
        String pageStr = "&page=";
        Integer pageNum = 1;
        String isExist="&magnet=exist";
//        System.out.println(searchUrl+keyword+pageStr+pageNum+isExist);
        String request = getRequest(searchUrl+keyword+pageStr+pageNum+isExist);
        if (Objects.isNull(request)){
            return;
        }
        pageResult pageresult = JSON.parseObject(request, pageResult.class);
        List<movies> moviesList = pageresult.getMovies();
        if (moviesList.size()<0){
            return;
        }
        for (movies mm: moviesList){
            if (Objects.equals("",mm.getId()) || Objects.isNull(mm.getId())){
                continue;
            }
            if (!isToday(mm.getDate())){
                break;
            }
            String details = getRequest(fanhaoUrl + mm.getId());
            if (Objects.isNull(details)){
                return;
            }
            SearchResult searchResult = JSON.parseObject(details, SearchResult.class);
            List<genRes> genres = searchResult.getGenres();
            for (genRes gg : genres){
                if (Objects.equals(gg.getId(),"2")){
                    break;
                }
            }
            System.out.println(searchResult.getId()+"     "+searchResult.getDate()+"  "+searchResult.getMagnets().get(0).getLink());
        }
    }

    public static void getInfoById(String nyID,int pageNum) throws UnsupportedEncodingException {
        String searchUrl = "http://192.168.0.120:33000/api/v1/movies?page="+pageNum+"&filterType=star&filterValue="+nyID+"&magnet=exist";
        String fanhaoUrl = "http://192.168.0.120:33000/api/v1/movies/";
//        String encode = URLEncoder.encode(nyName, "utf-8");
//        String keyword = "keyword="+encode;
//        String pageStr = "&page=";
//        Integer pageNum = 1;
//        String isExist="&magnet=exist";
//        System.out.println(searchUrl+keyword+pageStr+pageNum+isExist);
        Boolean hasPage = false;
        String request = getRequest(searchUrl);
        if (Objects.isNull(request)){
            return;
        }
        pageResult pageresult = JSON.parseObject(request, pageResult.class);
        List<movies> moviesList = pageresult.getMovies();
        if (moviesList.size()<0){
            return;
        }
        Boolean flag = true;
        hasPage = pageresult.getPagination().getHasNextPage();
        for (movies mm: moviesList){
            if (Objects.equals("",mm.getId()) || Objects.isNull(mm.getId())){
                continue;
            }
//            if (!isToday(mm.getDate())){
//                break;
//            }
            getMovieDetail(mm.getId());
            flag = true;
        }
        if (hasPage){
            getInfoById(nyID,++pageNum);
        }
    }

    public static void getMovieDetail(String id){
        String fanhaoUrl = "http://192.168.0.120:33000/api/v1/movies/";
        String details = getRequest(fanhaoUrl + id);
        SearchResult searchResult = JSON.parseObject(details, SearchResult.class);
        if (Objects.isNull(searchResult)){
            return;
        }
        if (searchResult.getStars().size() <= 3){
            return;
        }
        List<magNets> mms  = searchResult.getMagnets();
        if (mms.size()>0){
            magNets magNetss  = new magNets();
            String magnet = magNetss.getLink();
            String size = magNetss.getSize();
            String isIs = "0";
            String linkUrl = mms.stream()
                    .map(magNets::getLink)
                    .collect(Collectors.joining(", "));
            Boolean isUncensored = linkUrl.contains("uncensored");
            Boolean isCn = linkUrl.contains("-C") || linkUrl.contains("-c") || linkUrl.contains("-CH");
            if (linkUrl.contains("uncensored") || linkUrl.contains("-C") || linkUrl.contains("-c") || linkUrl.contains("-CH")){
                for (magNets magNet: mms){
                    if (magNet.getTitle().contains("uncensored")){
                        magNetss = magNet;
                        break;
                    }
                    if (isCn && !isUncensored){
                        magNetss = magNet;
                    }
                }
            }else {
                magNetss = mms.get(0);
            }
            System.out.println(magNetss.getLink());
        }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
//        for (int page = 1;page<11;page++){
//            daily(page);
//        }
//        for (int i = 1; i <= 200; i++) {
//            String str = String.format("%03d", i);
//            String fh = "ipzz-"+str;
////            System.out.println(fh);
//            getMovieDetail(fh);
//        }
//        getMovieDetail("IPZ-891");
//          for (String ny : ids){
////              System.out.println(ny);
        String nv = "5kp,2eg,opq,okq,1ny,2mx";
        List<String> ids = Arrays.asList(new String[]{"5kp",
                "2eg","opq","okq","1ny","2mx"});
        for (String id : ids){
            System.out.println(id);
            getInfoById(id,1);
        }

//          }
//        getInfoById("rki");
//        search("楓カレン");
//        for (String ny : ids){
////              System.out.println(ny);
//            getByType(1);
//          }
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                // 定时任务的逻辑代码
//                System.out.println("定时任务执行了");
//            }
//        };
//
//        Timer timer = new Timer();
//        // 延迟 1 秒后执行任务，然后每隔 5 秒执行一次
//        timer.schedule(task, 1000, 5000);
//        daily(1);1

    }
}