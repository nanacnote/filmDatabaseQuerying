package com.cmp4008y;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class reads line by line data from the film.txt found in the root folder of this project.
 *
 * @author [Owusu K](https://github.com/nanacnote)
 */
public class FilmDatabase {

    // FilmDatabase attribute
    public final ArrayList<HashMap<String, String>> filmCollection = new ArrayList<>();

    /**
     * Constructor method which initialises the FilmDatabase class by getting data from the film.txt file
     * and converting the individual film entries into a hashMap which is assigned to the filmCollections attribute.
     */
    public FilmDatabase()
    {
        this.readFilmFile();
    }


    /**
     * Reads in the film.txt file line by line and passes each line to the filmEntryParser() method.
     */
    private void readFilmFile()
    {
        try
        {
            File filmFile = new File("film.txt");
            Scanner fileReader = new Scanner(filmFile);
            while (fileReader.hasNextLine())
            {
                String filmEntry = fileReader.nextLine();

                // pass the current line as a string to the filmEntryParser() to be parsed as appropriate
                // check javadoc comments on filmEntryParser() method for details on how this parser works
                filmEntryParser(filmEntry);
            }
            fileReader.close();
        } catch (FileNotFoundException error)
        {
            error.printStackTrace();
        }
    }

    /**
     * Takes in a string param value and parses it to become a HasMap with standardised key identifiers
     *
     * @param filmEntry entry of film read in from film.txt (this string contains information on 'title',
     *                  'year of release', 'certificate of audience suitability', 'genre', 'duration' and
     *                  'viewer rating' )
     */
    private void filmEntryParser(String filmEntry)
    {
        // convert String to array of String
        String[] entry = filmEntry.split(",");

        // This if block helps prevent corrupted film entries from being parsed
        // it does this by checking if the length of the entry after split
        // is equal to 6 ie the sections every film entry needs to have.
        if (entry.length == 6)
        {
            // Convert String array to HashMap with standardised key values
            HashMap<String, String> filmEntryMap = new HashMap<>();
            filmEntryMap.put("title", entry[0]);
            filmEntryMap.put("year", entry[1]);
            filmEntryMap.put("certificate", entry[2]);
            filmEntryMap.put("genre", entry[3]);
            filmEntryMap.put("duration", entry[4]);
            filmEntryMap.put("rating", entry[5]);

            // add the film entry to the filmDatabase attribute
            filmCollection.add(filmEntryMap);
        }
    }

}
