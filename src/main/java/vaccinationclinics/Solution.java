package vaccinationclinics;

import java.util.List;
import java.util.TreeSet;

public class Solution {

    static Integer vaccination_clinics(Integer cities, Integer clinics, List<Integer> population){

        TreeSet<City> ratios = new TreeSet<>();
        for (int i = 0; i < cities; i++) {
            ratios.add(new City(i, population.get(i)));
            clinics--;
        }


        while(clinics > 0) {

            City city = getCityWithMaxRatio(ratios);
            city.addClinic(1);
            ratios.add(city);
            clinics--;
        }


        return (int)Math.ceil(getCityWithMaxRatio(ratios).ratio);
    }


    static City getCityWithMaxRatio(TreeSet<City> ratios){
        return ratios.pollLast();
    }


    private static class City implements Comparable<City> {
        Integer id;
        Integer clinics = 1;
        final Integer population;
        Double ratio;

        public City(Integer id, Integer population) {
            this.id = id;
            this.population = population;
            this.ratio = this.population / (double) this.clinics;
        }
        void addClinic(Integer numberOfClinics){
            this.clinics = this.clinics + numberOfClinics;
            this.ratio = this.population / (double) this.clinics;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            City city = (City) o;

            return id.equals(city.id);
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public int compareTo(City city) {
            return ((int)(ratio - city.ratio) == 0) ? id - city.id : (int)(ratio - city.ratio);
        }
    }
}
