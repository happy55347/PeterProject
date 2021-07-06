package com.jimmy.jimmyhomepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;


//@RestController
@Controller
@SpringBootApplication

public class JimmyHomePageApplication {

    public static void main(String[] args) {
        SpringApplication.run(JimmyHomePageApplication.class, args);
    }

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/highschool")
    public String highschool (){
        return "Highschool";
    }


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/springPrj/add")
//    @CrossOrigin
    public String AddComments(@ModelAttribute Comment comment, Model model) {
//        AddComment(commentValue);
        comment = commentRepository.save(comment);
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("commentsList", comments);
        return "springPrj";
    }

    @GetMapping("/home")
    public String toHomeView() {
        return "index";
    }

    @GetMapping("/comment")
    public String toCommentView(Model model) {
        model.addAttribute("comment", new Comment());
//        GetComment(commentValue);
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("commentsList", comments);
        return "springPrj";
    }


//    public void AddComment(String commentValue) {
//        try {
//            Connection conn= connectDB();
//
//            Calendar calendar = Calendar.getInstance();
//            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//
//            String query = " insert into comment (date, comment)"
//                    + " values (?, ?)";
//
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setDate(1, startDate);
//            preparedStmt.setString(2,commentValue);
//
//            preparedStmt.execute();
//
//            conn.close();
//        }
//        catch (Exception e)
//        {
//            System.err.println("Got an exception!");
//            System.err.println(e.getMessage());
//        }
//    }
//
//
//
//    public Connection connectDB() {
//        try {
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//        }
//        catch (ClassNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        try{
//            String myUrl = "jdbc:mysql://localhost:3306/comment";
//            Connection conn = DriverManager.getConnection(myUrl, "root", "@Mysql12345");
//            return conn;
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public void GetComment(String commentValue) {
//
//        Connection conn = connectDB();
//        Calendar calendar = Calendar.getInstance();
//        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//
//        try {
//            String query = " insert into comment (date, comment)"
//                    + " values (?, ?)";
//
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setDate(1, startDate);
//            preparedStmt.setString(2, commentValue);
//
//            preparedStmt.execute();
//
//            conn.close();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }

}