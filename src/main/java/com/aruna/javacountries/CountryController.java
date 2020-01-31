package com.aruna.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {

    // localhost:2021/data/names/all
    @GetMapping(value="/names/all",produces = {"application/json"})

    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(JavaCountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

    // localhost:2021/data/names/start/{letter}
    @GetMapping(value="/names/start/{letter}", produces={"application/json"})

    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCtry = JavaCountriesApplication.myCountryList
                .findCountries(c -> (c.getCountryName().toLowerCase().charAt(0)==Character.toLowerCase(letter)));

//        rtnCtry.sort((c1,c1) -> ())

        return new ResponseEntity<>(rtnCtry,HttpStatus.OK);
    }

    // localhost:2021/data/names/size/{number}
    @GetMapping(value="/names/size/{number}", produces = {"application/json"})

    public ResponseEntity<?> getCountriesGreaterOrEqualLength(@PathVariable int number)
    {
        ArrayList<Country> rtnCtrysByLength = JavaCountriesApplication.myCountryList
            .findCountries(c -> (c.getCountryName().length()>=number));

        rtnCtrysByLength.sort((c1,c2) -> (c1.getCountryName().compareTo(c2.getCountryName())));

        return new ResponseEntity<>(rtnCtrysByLength,HttpStatus.OK);
    }

    //localhost:2021/data/population/size/{people}
    @GetMapping(value="/population/size/people", produces = {"application/json"})

    public ResponseEntity<?> getPopulationBySize(@PathVariable long people)
    {
        ArrayList<Country> rtnCtrysByPopulation = JavaCountriesApplication.myCountryList
                .findCountries((c -> (c.getPopulation()>=people)));

        return new ResponseEntity<>(rtnCtrysByPopulation, HttpStatus.OK);
    }

    //localhost:2021/data/population/min
    @GetMapping(value="/population/min", produces={"application/json"})

    public ResponseEntity<?> getMinPopulation()
    {

//        Country rtnMin = JavaCountriesApplication.myCountryList.countryList.stream()
//                .min((c1,c2) -> (int)(c1.getPopulation() - c2.getPopulation()) ).get();

        return new ResponseEntity<>(JavaCountriesApplication.myCountryList.findCountryMinPopulation(), HttpStatus.OK);
    }

    //localhost:2021/data/population/max
    @GetMapping(value="/population/max", produces={"application/json"})

    public ResponseEntity<?> getMaxPopulation()
    {

        return new ResponseEntity<>(JavaCountriesApplication.myCountryList.findCountryMaxPopulation(), HttpStatus.OK);
    }

    //localhost:2021/data/age/min
    @GetMapping(value="/age/min", produces={"application/json"})

    public ResponseEntity<?> getMinAge()
    {

        return new ResponseEntity<>(JavaCountriesApplication.myCountryList.findCountryMinAge(), HttpStatus.OK);
    }

    //localhost:2021/data/age/max
    @GetMapping(value="/age/max", produces={"application/json"})

    public ResponseEntity<?> getMaxAge()
    {
        return new ResponseEntity<>(JavaCountriesApplication.myCountryList.findCountryMaxAge(), HttpStatus.OK);
    }

    //localhost:2021/data/age/age/{age}
    @GetMapping(value="/age/age/{age}", produces={"application/json"})

    public ResponseEntity<?> getAgeGreaterOrEqualAge(@PathVariable long age)
    {
        ArrayList<Country> rtnCtrysByAge = JavaCountriesApplication.myCountryList
                .findCountries((c -> (c.getMedianAge()>=age)));

        rtnCtrysByAge.sort((c1,c2) -> ((int) (c1.getMedianAge() - c2.getMedianAge())));

        // median for age
//        Integer ageLength = rtnCtrysByAge.size();
//        ArrayList<Country> medianCountry = new ArrayList<>();
//
//
//
//        if(ageLength % 2 ==0){
//            medianCountry.add(rtnCtrysByAge.get((ageLength/2)-1));
//            medianCountry.add(rtnCtrysByAge.get(ageLength/2));
//        }
//        else{
//            medianCountry.add(rtnCtrysByAge.get(ageLength));
//        }

//        System.out.println(rtnCtrysByAge);

        return new ResponseEntity<>(rtnCtrysByAge, HttpStatus.OK);
    }


    //localhost:2021/data/age/median
    @GetMapping(value="/age/median", produces = {"application/json"})

    public ResponseEntity<?> getMedianAge()
    {
        ArrayList<Country> rtnMedian = JavaCountriesApplication.myCountryList.countryList;

        rtnMedian.sort((c1,c2) -> ((int)(c1.getMedianAge()-c2.getMedianAge())));

        Integer ageLength = rtnMedian.size();
        ArrayList<Country> medianCountry = new ArrayList<>();

        medianCountry.add(rtnMedian.get((ageLength/2)));

        return new ResponseEntity<>(medianCountry,HttpStatus.OK);
    }


    //localhost:2021/data/population/median
    @GetMapping(value="/population/median", produces = {"application/json"})

    public ResponseEntity<?> getMedianPopulation()
    {
        ArrayList<Country> rtnMedian = JavaCountriesApplication.myCountryList.countryList;

        rtnMedian.sort((c1,c2) -> ((int)(c1.getPopulation()-c2.getPopulation())));

        Integer populationLength = rtnMedian.size();
        ArrayList<Country> medianPopulation = new ArrayList<>();

        medianPopulation.add(rtnMedian.get((populationLength/2)));

        return new ResponseEntity<>(medianPopulation,HttpStatus.OK);
    }
}
