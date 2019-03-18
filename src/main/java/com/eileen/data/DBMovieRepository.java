package com.eileen.data;

import com.eileen.logic.Customer;
import com.eileen.logic.Movie;
import com.eileen.logic.MovieRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Repository
public class DBMovieRepository implements MovieRepository {

    @Override
    public List<Movie> getAllAvailableMovies() {

        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            resultSet = connection.createStatement().executeQuery("select M_TITLE, M_ID, M_MAIN_ACTOR, M_YEAR from MOVIES where M_AVAILABLE = 1;");

            return transformToMovieList(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }



    @Override
    public void rentAMovie(String customerName, String movieTitle) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            preparedStatement = connection.prepareStatement("insert into Rentals (R_Date_Rented, R_C_ID, R_M_ID) values (now(), ?, ?);");
            preparedStatement.setInt(1, getCustomerIdFromName(customerName));
            preparedStatement.setInt(2, getMovieIdFromTitle(movieTitle));
            preparedStatement.executeUpdate();
            setMovieAvailability(movieTitle,0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void returnAMovie(String customerName, String movieTitle,int cost) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = DriverManager.getConnection(createConnectionUrl());
            preparedStatement = connection.prepareStatement("update Rentals set R_COST = ?, R_Date_Returned = now() where R_M_ID =" + getMovieIdFromTitle(movieTitle)+";");
            preparedStatement.setInt(1,cost);
            preparedStatement.executeUpdate();
            setMovieAvailability(movieTitle,1);
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(connection!= null){
                    connection.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    private int getCustomerIdFromName(String customerName) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            resultSet = connection.createStatement().executeQuery("select C_ID from CUSTOMERS where C_Name = '" + customerName + "';");
            resultSet.next();
            return resultSet.getInt("C_ID");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    private void setMovieAvailability(String movieTitle,int isAvailable){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = DriverManager.getConnection(createConnectionUrl());
            preparedStatement = connection.prepareStatement("update MOVIES set M_AVAILABLE = ? where M_TITLE = ? ;");
            preparedStatement.setInt(1,isAvailable);
            preparedStatement.setString(2,movieTitle);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public LocalDate getRentalDateFromMovieTitle(String movieTitle){
        Connection connection = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(createConnectionUrl());
            resultSet = connection.createStatement().executeQuery("select R_Date_Rented from Rentals where R_M_ID =" + getMovieIdFromTitle(movieTitle));
            resultSet.next();
            return resultSet.getDate("R_Date_Rented").toLocalDate();
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String getActorWithMovie(String movie) {
        return null;
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        return null;
    }

    private int getMovieIdFromTitle(String movieTitle) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(createConnectionUrl());
            preparedStatement = connection.prepareStatement("select M_ID from MOVIES where M_Title=(?) ;");
            preparedStatement.setString(1,movieTitle);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("M_ID");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    private static String createConnectionUrl() {
        String host = "localhost";
        String dbName = "VIDEOSTORE";
        String user = "root";
        String password = "aixin321";
        return "jdbc:mysql://" + host + "/" + dbName + "?" + "user=" + user + "&password=" + password + "&useSSL=false&allowPublicKeyRetrieval=true";
    }

    private List<Movie> transformToMovieList(ResultSet resultSet) {
        List<Movie> movieList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovieID(resultSet.getInt("M_ID"));
                movie.setTitle(resultSet.getString("M_TITLE"));
                movie.setActor(resultSet.getString("M_MAIN_ACTOR"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }



}