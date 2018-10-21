[![Build Status](https://travis-ci.org/victuxbb/VaccinationClinics.svg?branch=master)](https://travis-ci.org/victuxbb/VaccinationClinics)
# Vaccination Clinics

 The World Health Organization (WHO) wants to establish a total of B vaccination clinics across N cities to immunization people agains fatal diseases.
 Every city must have at least 1 clinic, and a clinic can only vaccinate people in the same city where they live. The goal is to minimize the number of
 vaccination kits needed in the largest clinic

 For example, suppose you have:
 * 2 cities and
 * 7 clinics to be opened.
 * If 200,000 is the population of the first city and
 * 500,000 is the population of the second city, then
 * two clinics can open in the first city and
 * five in the second. This way,
 * 100,000 people can be immunized in each of the two clinics in the first city, and
 * 100,000 can be immunized in each clinic in the second city.
 * So the maximum number of people to be immunized in the largest clinic is **100,000**

 **Constraints:**
 * 1 <= N <= 500,000
 * N <= B <= 2,000,000
 * 1 <= ai <= 5,000,000

 **Input Format:**
 Two integers in the first line, **N**, the number of cities, and **B**, the total number of clinics to be opened.
 Each of the following **N** lines contains an integer **ai**, the population of city **i**.

 **Output Format:**
 One integer representing the maximum number of people to be immunized in any single clinic.


## Followed approach

* Initialize binary search tree with all the cities with 1 clinic assigned.
* Loop over clinics while are greater than 0
* Find in constant time the city with max ratio (population/clinics) and assign a clinic.
* When all clinics are assigned return the city with max ratio.

```java
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
```

## Time complexity


```
O(N log N + B log N)
```

## Tests running

```
./gradlew test
```


## Testing with 500,000 cities and 2,000,000 clinics



Just as a prove of concept I've created a test which generate random population.
It works because normaly the ratio is greater than 700,000
```java
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
```