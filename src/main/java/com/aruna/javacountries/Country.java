package com.aruna.javacountries;

public class Country
{
    private String countryName;
    private long population;
    private long landMass;
    private int medianAge;

    public Country(String countryName, long population, long landMass, int medianAge) {
        this.countryName = countryName;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

//    public Country() {
//        this.countryName = "";
//        this.population = 0;
//        this.landMass = 0;
//        this.medianAge = 0;
//    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandMass() {
        return landMass;
    }

    public void setLandMass(long landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", population=" + population +
                ", landMass=" + landMass +
                ", medianAge=" + medianAge +
                '}';
    }
}
