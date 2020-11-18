package com.cmp4008y;


public class Main {

    public static void main(String[] args)
    {
        // Question 2
        new Film()
                .sortBy("duration")
                .printResult();
        System.out.println("\n\n\n"); //separator

        // Question 3
        new Film()
                .sortBy("rating")
                .filterBy("genre", "Horror")
                .sliceResult(-1, 1)
                .printResult();
        System.out.println("\n\n\n"); //separator

        // Question 4
        new Film()
                .sortBy("duration")
                .filterBy("certificate", "R")
                .sliceResult(-15, 15)
                .printResult();
        System.out.println("\n\n\n");

        // Question 5
        new Film()
                .sortBy("titleLength")
                .sliceResult(1, 1)
                .printResult();
        System.out.println("\n\n\n"); //separator

        // Question 6
        String oldestFilmYear = new Film()
                .sortBy("year")
                .sliceResult(1, 1)
                .getValueOf("year").get(0);
        String newestFilmYear = new Film()
                .sortBy("year")
                .sliceResult(-1, 1)
                .getValueOf("year").get(0);
        int yearDifference = Integer.parseInt(newestFilmYear) - Integer.parseInt(oldestFilmYear);
        System.out.println(yearDifference);

    }
}
