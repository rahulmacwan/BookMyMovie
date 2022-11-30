package com.Group9.BookMyMovie.Entity;

public class SeatSelectionEntity {

    private Integer theaterID;
    private Integer movieID;
    private Integer showID;
    private Integer seat;
    private Integer flag;

    public Integer getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Integer theaterID) {
        this.theaterID = theaterID;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public Integer getShowID() {
        return showID;
    }

    public void setShowID(Integer showID) {
        this.showID = showID;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "SeatSelectionEntity [theaterID=" + theaterID + ", movieID=" + movieID + ", showID=" + showID + ", seat="
                + seat + ", flag=" + flag + "]";
    }

}
