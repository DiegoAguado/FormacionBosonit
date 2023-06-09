package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo:");
        String path = sc.next();
        //List<Person> list = personList(path);
        //for (Person p : lista) System.out.println(p);
        //filterAges(path);
        //filterNames(path);
        //System.out.println(filterMadrid(path));
        //System.out.println(filterBarcelona(path));
        //for (Person p : filterAges(path)) System.out.println(p);
    }

    // With the file path as parameter, this method reads the file and returns a list of people
    public static List<Person> personList(String path) throws InvalidLineFormatException {
        List<Person> l = new ArrayList();
        String name = "", town = "", line;
        int age = 0, i = 0;
        Path p = Paths.get(path);

        try {
            for (String s : Files.readAllLines(p)) {
                name = "";
                i++;
                line = s;

                if (line.indexOf(":") == -1)
                    throw new InvalidLineFormatException("Format is not correct in line " + i + ". It should be -> name:town:age.");

                name = line.substring(0, line.indexOf(":")); //Obtains name

                if (name == "" || name == " ")
                    throw new InvalidLineFormatException("Format is not correct in line " + i + ". The name is necessary.");

                line = line.substring(line.indexOf(":") + 1); //Cuts the name
                if (line.indexOf(":") != -1) {
                    town = line.substring(0, line.indexOf(":")); //If there is more data in the line it gets the town
                    line = line.substring(line.indexOf(":") + 1); //Cuts the town
                    age = (line == "" || line == " ") ? 0 : Integer.parseInt(line); //If there is a blank space age is 0 but if not, it gets the age
                } else {
                    town = line; //If there isn't more data it gets the town
                    age = 0; //and age is 0
                }

                l.add(new Person(name, town, age)); //Adds a person with the previous attributes to the list
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return l; //Returns the person list from the file
    }

    //This method returns the same list from the parameter but changes empty towns to 'unknown'
    public static List<Person> unknownTown(List<Person> list) {
        for (Person p : list) {
            if (p.getTown() == "" || p.getTown() == " ")
                p.setTown("unknown"); //If the town is empty, changes it to 'unknown'
        }

        return list; //Returns the same list but now with no empty towns
    }

    //This method returns a list of people with less than 25 years old
    public static List<Person> filterAges(String path) {
        //Converts a List to a Stream, filters by age, converts it again to a List and then uses method unknownTown() to change empty towns to 'unknown' and then returns it
        return unknownTown(personList(path).stream().filter(u -> u.getAge() < 25 && u.getAge() != 0).toList());
    }

    //This method filters a list, deleting people whose name starts with an 'A' and then prints it on screen
    public static void filterNames(String path) {
        List<Person> list = personList(path);
        List<Person> newList = list.stream().filter(u -> u.getName().indexOf("A") == 0).toList();
        //Converts a List to a Stream, filters by names, converts it again to a List and then saves the list in an auxiliar list

        for (Person p : newList) { //Travels the auxilar list
            for (Person e : list) { //Travels the original list
                if (e.equals(p)) { //Compares people from the auxiliar list with people from the original list
                    list.remove(p); //If it's the same person, it gets deleted
                    break;
                }
            }
        }

        /* Other option
         *
         * List<Person> list = personList(path);
         * for(Person p: list){
         *      if(p.getName().substring(0,1).equals("A")){
         *          people.remove(p);
         *
         *          filterNames(list);
         *          break;
         *      }
         * }
         */

        list = unknownTown(list);

        for (Person p : list) System.out.println(p); //Travels the list and prints people on screen
    }

    //This method filters the list by age and then by town, where it must be 'Madrid', and then prints the first person
    public static Person filterMadrid(String path) {
        Stream<Person> l = filterAges(path).stream(); //Filters list by age
        Optional<Person> s = l.filter(u -> u.getTown().equals("Madrid")).findFirst(); //Then filters by town and takes the first person

        //If there is, at least, 1 person  from Madrid, it printes it and if not, it prints null
        return s.isPresent() ? s.get() : null;
    }

    //This method filters by age and then by town, where it must be 'Barcelona', and then prints the first person
    public static Person filterBarcelona(String path) {
        Stream<Person> l = filterAges(path).stream(); //Filters list by age
        Optional<Person> s = l.filter(u -> u.getTown().equals("Barcelona")).findFirst(); //Then filters by town and takes the first person

        //If there is, at least, 1 person  from Barcelona, it printes it and if not, it prints null
        return s.isPresent() ? s.get() : null;
    }
}
