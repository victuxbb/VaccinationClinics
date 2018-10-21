package vaccinationclinics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void vaccination_clinics() {
        Integer givenCities = 2;
        Integer givenClinics = 7;
        List<Integer> givenPopulation = new ArrayList<Integer>(){{
            add(200000);
            add(500000);
        }};


        assertEquals(Integer.valueOf(100000), Solution.vaccination_clinics(givenCities,givenClinics,givenPopulation));

    }


    @Test
    public void vaccination_clinics2() {
        Integer givenCities = 2;
        Integer givenClinics = 3;
        List<Integer> givenPopulation = new ArrayList<Integer>(){{
            add(3698173);
            add(1435143);
        }};
        assertEquals(Integer.valueOf(1849087), Solution.vaccination_clinics(givenCities,givenClinics,givenPopulation));

    }


    @Test
    public void vaccination_clinics3() {
        Integer givenCities = 10;
        Integer givenClinics = 38;
        List<Integer> givenPopulation = new ArrayList<Integer>(){{
            add(962725);
            add(744473);
            add(1883667);
            add(3980182);
            add(4566733);
            add(2433589);
            add(1347670);
            add(3346447);
            add(2831489);
            add(272829);
        }};
        assertEquals(Integer.valueOf(669290), Solution.vaccination_clinics(givenCities,givenClinics,givenPopulation));

    }


    @Test
    public void vaccination_clinics4() {
        Integer givenCities = 15;
        Integer givenClinics = 76;
        List<Integer> givenPopulation = new ArrayList<Integer>(){{
            add(2261427);
            add(359149);
            add(4820519);
            add(703064);
            add(2787085);
            add(2822378);
            add(1669172);
            add(1378943);
            add(3896068);
            add(1359914);
            add(4031467);
            add(2810237);
            add(212899);
            add(3297550);
            add(3266279);
        }};
        assertEquals(Integer.valueOf(535614), Solution.vaccination_clinics(givenCities,givenClinics,givenPopulation));

    }


    @Test
    public void vaccination_clinics_with_big_fucking_numbers() {
        Integer givenCities = 500000;
        Integer givenClinics = 2000000;
        List<Integer> givenPopulation = new ArrayList<Integer>(){{
            for (int i = 0; i < givenCities; i++) {
                int min = 1;
                int max = 5000000;
                add(new Random().nextInt((max-min) + 1) + min);
            }
        }};
        assertTrue(Solution.vaccination_clinics(givenCities,givenClinics,givenPopulation) > 700000);

    }
}