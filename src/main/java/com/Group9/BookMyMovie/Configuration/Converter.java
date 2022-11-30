package com.Group9.BookMyMovie.Configuration;

import com.Group9.BookMyMovie.Model.SeatSelectionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Converter {

    public List<SeatSelectionModel> converttoModel(List<String> listofseats) {

        List<SeatSelectionModel> listofseatsModel = new ArrayList<>();
        System.out.println(listofseats.get(0));
        if (listofseats.get(0).contains("{") && listofseats.get(0).contains("}")) {
            for (String seats : listofseats) {
                System.out.println("seats:" + seats);
                SeatSelectionModel seatmodel = new SeatSelectionModel();
                seatmodel.setTheaterID(Integer.valueOf(getTagsvalues(seats, "theaterID")));
                seatmodel.setMovieID(Integer.valueOf(getTagsvalues(seats, "movieID")));
                seatmodel.setShowID(Integer.valueOf(getTagsvalues(seats, "showID")));
                seatmodel.setSeat(Integer.valueOf(getTagsvalues(seats, "seat")));
                seatmodel.setFlag(Integer.valueOf(getTagsvalues(seats, "flag")));
                listofseatsModel.add(seatmodel);
                System.out.println(listofseatsModel);
            }

        } else {
            SeatSelectionModel seatmodel = new SeatSelectionModel();
            for (String seats : listofseats) {

                if (seats.contains("theaterID")) {
                    seatmodel.setTheaterID(Integer.valueOf(getTagsvalues(seats, "theaterID")));
                }
                if (seats.contains("movieID")) {
                    seatmodel.setMovieID(Integer.valueOf(getTagsvalues(seats, "movieID")));
                }
                if (seats.contains("showID")) {
                    seatmodel.setShowID(Integer.valueOf(getTagsvalues(seats, "showID")));
                }
                if (seats.contains("seat")) {
                    seatmodel.setSeat(Integer.valueOf(getTagsvalues(seats, "seat")));
                }
                if (seats.contains("flag")) {
                    seatmodel.setFlag(Integer.valueOf(getTagsvalues(seats, "flag")));
                }
            }
            
            listofseatsModel.add(seatmodel);

        }

        return listofseatsModel;
    }

    public String getTagsvalues(String input, String tagName) {

        String tagvalue = "";
        Pattern TAG_REGEX = Pattern.compile("\"" + tagName + "\":\"(.*?)\"", Pattern.DOTALL);


        Matcher matcher = TAG_REGEX.matcher(input);
        while (matcher.find()) {

            tagvalue = matcher.group(1);
        }

        return tagvalue;
    }

}
