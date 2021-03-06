package com.example.f21comp1011gctest1student.Utility;

import com.example.f21comp1011gctest1student.NetflixShow;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {

        private static String user = "student";
        private static String pw = "student";
        private static String connectionURl = "jdbc:mysql://localhost:3306/javatest";

        public static ArrayList<NetflixShow> getAllNetflixShow(String sType, String sRating) {
            ArrayList<NetflixShow> showArrayList = new ArrayList<>();
            String sql = "SELECT showId, type, title, rating, director,cast FROM netflix where type != ? and rating != ?";

            if (!sType.equals("All") && sRating.equals("All rating"))
                sql = "SELECT showId, type, title, rating, director,cast FROM netflix where type = ? and rating != ?";

            else if (sType.equals("All") && !sRating.equals("All rating"))
                sql = "SELECT showId, type, title, rating, director,cast FROM netflix where type != ? and rating = ?";

            else if (!sType.equals("All") && !sRating.equals("All rating"))
                sql = "SELECT showId, type, title, rating, director,cast FROM netflix where type = ? and rating = ?";


            try(
                    Connection conn = DriverManager.getConnection(connectionURl, user, pw);
                    PreparedStatement statement = conn.prepareStatement(sql);

                    ) {
                statement.setString(1, sType);
                statement.setString(2, sRating);
                ResultSet resultSet = statement.executeQuery();
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

    /*
    public static ArrayList<String> getAllRating() {
        ArrayList<String> showRatingList = new ArrayList<>();
        String sql = "SELECT rating FROM netflix";

        try(
                Connection conn = DriverManager.getConnection(connectionURl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while(resultSet.next())
            {

                String rating = resultSet.getString("rating");
                showRatingList.add(rating);
            }

        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return showRatingList;
    }

    public static ArrayList<NetflixShow> getSelectedSearch(String ratingcombo) {
        ArrayList<NetflixShow> showSelectedSearch = new ArrayList<>();
        String sql = "SELECT  showId, type, title, rating, director,cast FROM netflix WHERE rating='"+ratingcombo+"';";

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
                showSelectedSearch.add(netflixShow);
            }

        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return showSelectedSearch;
    }

    public static ArrayList<NetflixShow> getSelectedSearchMovie() {
        ArrayList<NetflixShow> showArrayList = new ArrayList<>();
        String sql = "SELECT  showId, type, title, rating, director,cast FROM netflix where type ='Movie'";

        try(
                Connection conn = DriverManager.getConnection(connectionURl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
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

    public static ArrayList<NetflixShow> getSelectedSearchTV() {
        ArrayList<NetflixShow> showArrayList = new ArrayList<>();
        String sql = "SELECT  showId, type, title, rating, director,cast FROM netflix where type ='TV Show'";

        try(
                Connection conn = DriverManager.getConnection(connectionURl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
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
    */
}
