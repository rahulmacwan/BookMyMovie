package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.ILocationModel;
import com.Group9.BookMyMovie.Model.LocationModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class BookMyMovieLocationTests {
    @Mock
    LocationModel loactionmodel;
    ILocationModel locationModel;

    public BookMyMovieLocationTests() {
    }

    @Before
    public void setUp() {

        locationModel = mock(LocationModel.class);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void checkEmptyLocationList() {
        List<LocationModel> listLocationModel = null;

        assertNull(listLocationModel);
    }

    @Test
    public void getValidLocation() {

        List<LocationModel> listLocationModel = new ArrayList<>();

        LocationModel locationModel1 = new LocationModel();
        locationModel1.setLocationid(101);
        locationModel1.setLocationName("Halifax");

        LocationModel locationModel2 = new LocationModel();
        locationModel2.setLocationid(102);
        locationModel2.setLocationName("Bedford");

        LocationModel locationModel3 = new LocationModel();
        locationModel3.setLocationid(103);
        locationModel3.setLocationName("Dartmouth");

        LocationModel locationModel4 = new LocationModel();
        locationModel4.setLocationid(104);
        locationModel4.setLocationName("Sydney");

        LocationModel locationModel5 = new LocationModel();
        locationModel5.setLocationid(105);
        locationModel5.setLocationName("Truro");

        LocationModel locationModel6 = new LocationModel();
        locationModel6.setLocationid(106);
        locationModel6.setLocationName("Lunenberg");

        LocationModel locationModel7 = new LocationModel();
        locationModel7.setLocationid(107);
        locationModel7.setLocationName("Shellburne");

        LocationModel locationModel8 = new LocationModel();
        locationModel8.setLocationid(108);
        locationModel8.setLocationName("Kentville");

        listLocationModel.add(locationModel1);
        listLocationModel.add(locationModel2);
        listLocationModel.add(locationModel3);
        listLocationModel.add(locationModel4);
        listLocationModel.add(locationModel5);
        listLocationModel.add(locationModel6);
        listLocationModel.add(locationModel7);
        listLocationModel.add(locationModel8);

        when(locationModel.getLocation()).thenReturn(listLocationModel);

        assertNotNull(listLocationModel);
        assertEquals(locationModel.getLocation(), listLocationModel);
    }

    @Test
    public void getInvalidLocation() {

        List<LocationModel> listLocationModel = new ArrayList<>();

        LocationModel locationModel1 = new LocationModel();
        locationModel1.setLocationid(101);
        locationModel1.setLocationName("Toronto");

        LocationModel locationModel2 = new LocationModel();
        locationModel2.setLocationid(102);
        locationModel2.setLocationName("Montreal");

        LocationModel locationModel3 = new LocationModel();
        locationModel3.setLocationid(103);
        locationModel3.setLocationName("Calgiri");

        LocationModel locationModel4 = new LocationModel();
        locationModel4.setLocationid(104);
        locationModel4.setLocationName("Alberta");

        LocationModel locationModel5 = new LocationModel();
        locationModel5.setLocationid(105);
        locationModel5.setLocationName("BritishColumbia");

        LocationModel locationModel6 = new LocationModel();
        locationModel6.setLocationid(106);
        locationModel6.setLocationName("Manitoba");

        LocationModel locationModel7 = new LocationModel();
        locationModel7.setLocationid(107);
        locationModel7.setLocationName("Yukon");

        LocationModel locationModel8 = new LocationModel();
        locationModel8.setLocationid(108);
        locationModel8.setLocationName("Nunavut");

        listLocationModel.add(locationModel1);
        listLocationModel.add(locationModel2);
        listLocationModel.add(locationModel3);
        listLocationModel.add(locationModel4);
        listLocationModel.add(locationModel5);
        listLocationModel.add(locationModel6);
        listLocationModel.add(locationModel7);
        listLocationModel.add(locationModel8);

        when(locationModel.getLocation()).thenReturn(listLocationModel);

        assertNotNull(listLocationModel);
        assertEquals(locationModel.getLocation(), listLocationModel);

    }
}
