package com.cmp4008y;


public class Main {

    public static void main(String[] args)
    {
        //===========HEADER==============
        System.out.println("\n\n\u001B[45m QUESTION 2 \u001B[0m");
        //===========HEADER==============
        new Film()
                .sortBy("duration")
                .printResult();

        //===========HEADER==============
        System.out.println("\n\n\u001B[45m QUESTION 3 \u001B[0m");
        //===========HEADER==============
        new Film()
                .sortBy("rating")
                .filterBy("genre", "Horror")
                .sliceResult(-1, 1)
                .printResult();

        //===========HEADER==============
        System.out.println("\n\n\u001B[45m QUESTION 4 \u001B[0m");
        //===========HEADER==============
        new Film()
                .sortBy("duration")
                .filterBy("certificate", "R")
                .sliceResult(-15, 15)
                .printResult();

        //===========HEADER==============
        System.out.println("\n\n\u001B[45m QUESTION 5 \u001B[0m");
        //===========HEADER==============
        new Film()
                .sortBy("titleLength")
                .sliceResult(1, 1)
                .printResult();

        //===========HEADER==============
        System.out.println("\n\n\u001B[45m QUESTION 6 \u001B[0m");
        //===========HEADER==============
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
