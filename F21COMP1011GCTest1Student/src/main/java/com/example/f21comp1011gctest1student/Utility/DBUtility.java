package com.example.f21comp1011gctest1student.Utility;

import com.example.f21comp1011gctest1student.NetflixShow;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {

        private static String user = "student";
        private static String pw = "student";
        private static String connectionURl = "jdbc:mysql://localhost:3308/javatest";

        public static ArrayList<NetflixShow> getAllNetflixShow() {
            ArrayList<NetflixShow> showArrayList = new ArrayList<>();
            String sql = "SELECT showId, type, title, rating, director,cast FROM netflix";

            try(
                    Connection conn = DriverManager.getConnection(connectionURl, user, pw);
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    ) {
                while(resultSet.next())
                {
                    String showId = resultSet.getString("showId");
                    String type = resultSet.getString("type");
                    String title = resultSet.getString("title");
                    String rating = resultSet.getString("rating");
                    String director = resultSet.getString("director");
                    String cast = resultSet.getString("cast");

                    NetflixShow netflixShow = new NetflixShow(showId,type,title,director,cast,rating);
                    showArrayList.add(netflixShow);
                }

            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }

            return showArrayList;
        }
}
