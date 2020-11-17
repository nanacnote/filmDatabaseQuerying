package com.cmp4008y;

import java.util.*;

public class Film {

    private final ArrayList<HashMap<String, String>> filmCollection;
    private final ArrayList<HashMap<String, String>> mutableFilmCollection;


    public Film()
    {
        // create an instance of the FilmDatabase class and immediately get its filmCollection attribute
        this.filmCollection = new FilmDatabase().filmCollection;
        this.mutableFilmCollection = new ArrayList<>();
    }

    private String toString(HashMap<String, String> filmHashMap)
    {
        return filmHashMap.get("title") + ","
                + filmHashMap.get("year") + ","
                + filmHashMap.get("certificate") + ","
                + filmHashMap.get("genre") + ","
                + filmHashMap.get("duration") + ","
                + filmHashMap.get("rating");
    }

    public Film sortBy(String section)
    {
        ArrayList<HashMap<String, String>> copyOfFilmCollection = new ArrayList<>(this.mutableFilmCollection.isEmpty() ? this.filmCollection : this.mutableFilmCollection);

        this.mutableFilmCollection.clear();

        copyOfFilmCollection.sort(new CustomComparator(section));
        this.mutableFilmCollection.addAll(copyOfFilmCollection);

        return this;
    }

    public Film filterBy(String section, String filterValue)
    {
        ArrayList<HashMap<String, String>> copyOfFilmCollection = new ArrayList<>(this.mutableFilmCollection.isEmpty() ? this.filmCollection : this.mutableFilmCollection);

        this.mutableFilmCollection.clear();

        for (HashMap<String, String> film : copyOfFilmCollection)
        {
            String quotesTrimmer = film.get(section).replace("\"", "");
            Set<String> multipleFilterValues = Set.of(quotesTrimmer.split("/"));

            if (multipleFilterValues.contains(filterValue))
            {
                this.mutableFilmCollection.add(film);
            }

        }
        return this;
    }

    public Film sliceResult(String fromInclusive, String toInclusive)
    {
        int from = Integer.parseInt(fromInclusive);
        int to = Integer.parseInt(toInclusive);

        ArrayList<HashMap<String, String>> copyOfFilmCollection = new ArrayList<>(this.mutableFilmCollection.isEmpty() ? this.filmCollection : this.mutableFilmCollection);

        this.mutableFilmCollection.clear();

        if (from < 0)
        {
            Collections.reverse(copyOfFilmCollection);
            from *= -1;
        }

        if (to == 0)
        {
            to = copyOfFilmCollection.size();
        }

        if (from == 0 || from > copyOfFilmCollection.size() || to > copyOfFilmCollection.size())
            throw new IllegalArgumentException("Either the \"from\" or \"to\" parameter is out of range");

        for (int i = from - 1; i < to; i++)
        {
            this.mutableFilmCollection.add(copyOfFilmCollection.get(i));
        }

        return this;
    }

    public ArrayList<String> getValueOf(String section)
    {

        if (!this.mutableFilmCollection.isEmpty())
        {
            ArrayList<String> valuesList = new ArrayList<>();

            for (HashMap<String, String> film : this.mutableFilmCollection)
            {
                valuesList.add(film.get(section));
            }
            return valuesList;
        }
        return new ArrayList<>();
    }

    public void printResult()
    {

        for (HashMap<String, String> film : this.mutableFilmCollection)
        {
            System.out.println(toString(film));
        }

    }

    static class CustomComparator implements Comparator<HashMap<String, String>> {

        private final String key;

        private CustomComparator(String key)
        {
            this.key = key;
        }


        @Override
        public int compare(HashMap<String, String> o1, HashMap<String, String> o2)
        {
            if (key.equals("duration") || key.equals("year"))
            {
                int first = Integer.parseInt(o1.get(key));
                int second = Integer.parseInt(o2.get(key));
                return Integer.compare(first, second);
            }
            if (key.equals("rating"))
            {
                double first = Double.parseDouble(o1.get(key));
                double second = Double.parseDouble(o2.get(key));
                return Double.compare(first, second);
            }
            if (key.equals("titleLength"))
            {
                int first = o1.get("title").length();
                int second = o2.get("title").length();
                return Integer.compare(first, second);
            }
            return o1.get(key).compareTo(o2.get(key));
        }
    }

}