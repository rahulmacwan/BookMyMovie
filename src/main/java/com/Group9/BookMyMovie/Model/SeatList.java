package com.Group9.BookMyMovie.Model;

import java.util.List;

public class SeatList {

    public List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SeatList [list=" + list + "]";
    }

}
