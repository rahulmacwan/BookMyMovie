package com.Group9.BookMyMovie.Entity;

public class TheaterEntity {

    private Integer theaterId;
    private Integer movieid;
    private String theatername;
    private String theaterAddress;
    private Integer locationid;

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }

    @Override
    public String toString() {
        return "TheaterEntity [theaterId=" + theaterId + ", movieid=" + movieid + ", theatername=" + theatername
                + ", theaterAddress=" + theaterAddress + ", locationid=" + locationid + "]";
    }

}
