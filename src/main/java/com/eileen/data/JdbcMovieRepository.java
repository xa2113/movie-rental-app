package com.eileen.data;

import com.eileen.logic.Customer;
import com.eileen.logic.Movie;
import com.eileen.logic.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class JdbcMovieRepository implements MovieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Movie> getAllAvailableMovies() {

        List<Movie> movieList = jdbcTemplate.query(
                "SELECT * FROM MOVIES where M_Available = 1", new MovieRowMapper());

        return movieList;
    }

    @Override
    public void rentAMovie(String customer, String movieTitle) {
        int customerID = getCustomerIdFromName(customer);
        int movieID = getMovieIdFromMovieTitle(movieTitle);
        String query = "insert into Rentals (R_Date_Rented, R_C_ID, R_M_ID) values (now(),"
                + customerID + "," + movieID + ");";
        jdbcTemplate.execute(query);
        changeMovieAvailability(movieID,0);
    }

    private void changeMovieAvailability(int movieID, int isAvailable) {
        String query = "update MOVIES set M_AVAILABLE = " + isAvailable + " where M_TITLE = " + movieID;
        jdbcTemplate.execute(query);

    }

    private int getMovieIdFromMovieTitle(String movieTitle) {

        String query = "Select M_ID from MOVIES where M_Title = ?";
        return jdbcTemplate.queryForObject(query,new Object[]{movieTitle}, Integer.class);
    }

    @Override
    public void returnAMovie(String customer, String movieTitle, int cost) {
        String query = "update Rentals set R_COST = " + cost + ", R_Date_Returned = now() where R_M_ID =" + getMovieIdFromMovieTitle(movieTitle);
        jdbcTemplate.execute(query);
    }

    @Override
    public LocalDate getRentalDateFromMovieTitle(String movieTitle) {
        String query = "select R_Date_Rented from Rentals where R_Date_Returned is null AND R_M_ID = ?";
        int movieId = getMovieIdFromMovieTitle(movieTitle);
        return jdbcTemplate.queryForObject(query,new Object[]{movieId}, LocalDate.class);

    }

    @Override
    public String getActorWithMovie(String movieTitle) {
        String query = "select M_MAIN_ACTOR from Movies where M_Title = ?";
        return jdbcTemplate.queryForObject(query,new Object[]{movieTitle},String.class);
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        String query = "insert into Customers (C_NAME, C_ADDRESS) values (?,?);";
        jdbcTemplate.update(query,customer.getCustomerName(),customer.getCustomerAddress());
        return jdbcTemplate.queryForObject("select * from customers where C_NAME = ?",new Object[]{customer.getCustomerName()},new customerRowMapper());
    }

    private static class MovieRowMapper implements RowMapper<Movie> {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();
            movie.setMovieID(rs.getInt("M_ID"));
            movie.setTitle(rs.getString("M_TITLE"));
            movie.setActor(rs.getString("M_MAIN_ACTOR"));
            return movie;
        }
    }

    private int getCustomerIdFromName(String customerName) {

        String query = "Select C_ID from Customers where C_Name = ?";
        return jdbcTemplate.queryForObject(query,new Object[]{customerName}, Integer.class);
    }


    private static class customerRowMapper implements  RowMapper<Customer>{

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerID(rs.getInt("C_ID"));
            customer.setCustomerName(rs.getString("C_NAME"));
            customer.setCustomerAddress(rs.getString("C_ADDRESS"));
            return customer;
        }
    }
}
