package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.company.Main.planetSystemList;
import static com.company.Main.system;

public class ReadFile {

    static String planetSavePath = "solar_system_planets";
    static String planetSaveExtension = ".csv";
    static String planetCSVDevider = ",";
    static boolean emtySystem = false;

    public static void readFile_V1(int whatSystem) {
        planetSavePath = "solar_system_planets2";
        planetSaveExtension = ".csv";

        try {
            File file = new File(planetSavePath + planetSaveExtension);    // Finds the file path
            Scanner fileScanner = new Scanner(file);    // Scanns thrue the file that is spesefied in File and finds the content

            String[] splitFileString = fileScanner.nextLine().split(planetCSVDevider);

            if (!splitFileString[0].equals("name")) {
                CenterStar centerStar = new CenterStar(splitFileString[0], new UserInput(splitFileString[1]).getDouble(), new UserInput(splitFileString[2]).getDouble(), new UserInput(splitFileString[3]).getDouble());
                planetSystemList.get(whatSystem).setCenterStar(centerStar);
            }

            String[] stringProp = fileScanner.nextLine().split(planetCSVDevider);

            emtySystem = planetSystemList.get(whatSystem).getNumberOfPlanets() == 0;

            while (fileScanner.hasNextLine()) {
                splitFileString = fileScanner.next().split(planetCSVDevider);
                Planet planet = new Planet();

                if (emtySystem) {
                    for (int i = 0; i < stringProp.length; i++) {
                        planet.setBodyPropByName(stringProp[i], splitFileString[i]);
                    }
                    planetSystemList.get(whatSystem).addPlanetToSystem(planet);
                } else {
                    for (int i = 0; i < planetSystemList.get(whatSystem).getNumberOfPlanets(); i++) {     // This fixes the "bug" that allowd you to import multiple of the same planet.
                        if (planetSystemList.get(whatSystem).getPlanet(i).getName().equals(splitFileString[0]) && Double.toString(planetSystemList.get(whatSystem).getPlanet(i).getMass()).equals(splitFileString[1]) && Double.toString(planetSystemList.get(whatSystem).getPlanet(i).getRadius()).equals(splitFileString[2])) {       // Test if the name, radius and mass it the same, if it is the do not import the planet
                            System.out.println("Skipping planet: " + splitFileString[0]);
                        } else if (planetSystemList.get(whatSystem).getPlanet(i).getName().equals(splitFileString[0])) {        // Test if a the planet from the CSV and array has the same name
                            System.out.println();

                            System.out.println("Found " + splitFileString[0] + " in the CSV file and that planet matches " + planetSystemList.get(whatSystem).getPlanet(i).getName() + " that is already in the system.");
                            System.out.println("What planet do you want to keep?");
                            System.out.println("Planet in CSV(1): " + splitFileString[0] + "," + splitFileString[1] + "," + splitFileString[2]);
                            System.out.println("Planet in system(2): " + planetSystemList.get(whatSystem).getPlanet(i).getName() + " , " + planetSystemList.get(whatSystem).getPlanet(i).getMass() + " , " + planetSystemList.get(whatSystem).getPlanet(i).getRadius());

                            switch (new UserInput().getString()) {
                                case "csv":
                                case "CSV":
                                case "1":
                                    for (int j = 0; j < stringProp.length; j++) {
                                        planetSystemList.get(whatSystem).getPlanet(i).setBodyPropByName(stringProp[j],splitFileString[j]);
                                    }
                                    System.out.println("Changing to " + splitFileString[0] + " from the CSV");
                                    break;
                                case "2":
                                    System.out.println("Skipping " + splitFileString[0]);
                                    break;
                            }
                        }
                    }
                }
            }

            fileScanner.close();
            System.out.println("Planets Added:");
            planetSystemList.get(whatSystem).printPlanetList();
            System.out.println();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Eksisterer " + planetSavePath + planetSaveExtension + " ?");   // If the file does not exist this will be printet
            System.out.println(e.toString());   // -------------------------------------
        }
    }

    public static void readFile_V1_5(int whatSystem) {
        planetSavePath = "solar_system_planets4";
        planetSaveExtension = ".csv";
        int typePlace = 0;
        int namePlace = 0;
        int centralCelestialBodyPlace = 0;

        try {
            File file = new File(planetSavePath + planetSaveExtension);    // Finds the file path
            Scanner fileScanner = new Scanner(file);    // Scanns thrue the file that is spesefied in File and finds the content

            String[] splitFileString = fileScanner.next().split(planetCSVDevider);

            for (int i = 0; i < splitFileString.length; i++) {  // Here to save where information i am going to use later
                // TODO: Make not dependent on the things below... if I feel like it
                switch (splitFileString[i]) {
                    case "type":
                        typePlace = i;
                        break;
                    case "name":
                        namePlace = i;
                        break;
                    case "centralCelestialBody":
                        centralCelestialBodyPlace = i;
                        break;

                }
            }

            String[] stringProp = splitFileString;

            emtySystem = planetSystemList.get(whatSystem).getNumberOfPlanets() == 0;

            while (fileScanner.hasNextLine()) {
                splitFileString = fileScanner.next().split(planetCSVDevider);

                if (emtySystem) {   // If the system was emty before the import started it will not do a check if there is some of the same planets
                    switch (splitFileString[typePlace]) {
                        case "sun":
                            CenterStar centerStar = new CenterStar();
                            for (int i = 0; i < splitFileString.length; i++) {
                                if (!splitFileString[i].equals("")) {
                                    centerStar.setSunPropByName(stringProp[i], splitFileString[i]);
                                }
                            }
                            planetSystemList.get(whatSystem).setCenterStar(centerStar);
                            break;
                        case "planet":
                            Planet planet = new Planet();
                            for (int i = 0; i < splitFileString.length; i++) {
                                if (!splitFileString[i].equals("")) {
                                    planet.setBodyPropByName(stringProp[i], splitFileString[i]);
                                }
                            }
                            planetSystemList.get(whatSystem).addPlanetToSystem(planet);
                            break;
                        case "moon":
                            Moon moon = new Moon();
                            for (int i = 0; i < splitFileString.length; i++) {
                                if (!splitFileString[i].equals("")) {
                                    moon.setBodyPropByName(stringProp[i], splitFileString[i]);
                                }
                            }
                            planetSystemList.get(whatSystem).getPlanet(splitFileString[centralCelestialBodyPlace]).addMoon(moon);
                            break;
                    }
                } else {    // If the system has planets check if there is a planet with the same props
                    switch (splitFileString[typePlace]) {
                        case "sun":
                            if (planetSystemList.get(whatSystem).getCenterStar() != null) {
                                CenterStar centerStar = new CenterStar();
                                for (int i = 0; i < splitFileString.length; i++) {
                                    if (!splitFileString[i].equals("")) {
                                        centerStar.setSunPropByName(stringProp[i], splitFileString[i]);
                                    }
                                }
                                planetSystemList.get(whatSystem).setCenterStar(centerStar);
                            } else {
                                for (int i = 0; i < splitFileString.length; i++) {
                                    if (!splitFileString[i].equals("")) {
                                        planetSystemList.get(whatSystem).getCenterStar().setSunPropByName(stringProp[i], splitFileString[i]);
                                    }
                                }
                            }
                            break;
                        case "planet":
                            if (system.bodyExists(splitFileString[namePlace], PlanetSystem.Body.PLANET, splitFileString[centralCelestialBodyPlace])) {
                                for (int i = 0; i < stringProp.length; i++) {
                                    planetSystemList.get(whatSystem).getPlanet(splitFileString[namePlace]).setBodyPropByName(stringProp[i], splitFileString[i]);
                                }
                            } else {
                                Planet planet = new Planet();
                                for (int i = 0; i < splitFileString.length; i++) {
                                    if (!splitFileString[i].equals("")) {
                                        planet.setBodyPropByName(stringProp[i], splitFileString[i]);
                                    }
                                }
                                planetSystemList.get(whatSystem).addPlanetToSystem(planet);
                            }
                            break;
                        case "moon":
                            if (system.bodyExists(splitFileString[namePlace], PlanetSystem.Body.MOON, splitFileString[centralCelestialBodyPlace])) {
                                for (int i = 0; i < stringProp.length; i++) {
                                    planetSystemList.get(whatSystem).getPlanet(splitFileString[centralCelestialBodyPlace]).getMoon(namePlace).setBodyPropByName(stringProp[i], splitFileString[i]);
                                }
                            } else {
                                Moon moon = new Moon();
                                for (int i = 0; i < splitFileString.length; i++) {
                                    if (!splitFileString[i].equals("")) {
                                        moon.setBodyPropByName(stringProp[i], splitFileString[i]);
                                    }
                                }
                                planetSystemList.get(whatSystem).getPlanet(splitFileString[centralCelestialBodyPlace]).addMoon(moon);
                            }
                            break;
                    }
                }
            }
            fileScanner.close();
            System.out.println("Planets Added:");
            planetSystemList.get(whatSystem).printPlanetList();
            System.out.println();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Eksisterer " + planetSavePath + planetSaveExtension + " ?");   // If the file does not exist this will be printet
            System.out.println(e.toString());   // -------------------------------------
        }
    }

    public static void readFile_V2(int whatSystem) {
        planetSavePath = "solar_system_planets_UserSaved_test2";
        planetSaveExtension = ".txt";

        String lastBody = "";
        int lastIndent = 0;

        try {
            File file = new File(planetSavePath + planetSaveExtension);    // Finds the file path
            Scanner fileScanner = new Scanner(file);    // Scanns thrue the file that is spesefied in File and finds the content

            Planet planet = new Planet();

            // TODO: Make the reader read the line then split on :. Use the first line (0) as the property and the secont (1) as the value
            // Example Mass: 123 takes setPlanetPropByName("mass", 123);

            while (fileScanner.hasNextLine()) {
                String[] splitLine = fileScanner.nextLine().split(":");

                /*
                if (splitLine[0] != null || splitLine[1] != null) {
                    if (splitLine[1].charAt(0) == 0) {
                        System.out.print(splitLine[1].substring(1) + "\n");
                    } else {
                        System.out.print(splitLine[1] + "\n");
                    }
                }
                 */
                /*
                if (splitLine[0].equals("System Name")){
                    System.out.print(splitLine[0] + "\n");
                } else if (splitLine[0].startsWith("\t")) {
                    String[] splitProp = splitLine[0].split("\t");
                    if (splitProp[1].equals("Stars")) {
                        System.out.print(splitProp[1] + "\n");
                        lastBody = "stars";
                    } else if (splitProp[1].equals("Planets")) {
                        System.out.print(splitProp[1] + "\n");
                        lastBody = "planet";


                    }
                }
                */

                if (splitLine[0].equals("System Name")) {

                    lastIndent = 0;
                    System.out.println("new system");
                } else if (splitLine[0].contains("\t\t\t")) {

                    if (lastBody.equals("Planets")) {
                        planet.setBodyPropByName(splitLine[0].substring(3), splitLine[1].substring(1));
                    }

                    lastIndent = 3;
                    System.out.println(splitLine[0].substring(3));
                } else if (splitLine[0].contains("\t\t")) {

                    planetSystemList.get(whatSystem).addPlanetToSystem(planet);

                    planet = new Planet();


                    if (lastBody.equals("Planets")) {
                        planet.setBodyPropByName(splitLine[0].substring(2), splitLine[1].substring(1));
                    }

                    lastIndent = 2;
                    System.out.println(splitLine[0].substring(2));
                } else if (splitLine[0].contains("\t")) {

                    lastBody = splitLine[0].substring(1);

                    lastIndent = 1;
                    System.out.println(lastBody);
                }








            }



            fileScanner.close();
        }catch (Exception e) {
            System.out.println("Eksisterer " + planetSavePath + planetSaveExtension + " ?");   // If the file does not exist this will be printet
            System.out.println(e.toString());   // -------------------------------------
        }
        //TODO: Make this read the .txt file that i create in SaveFile.saveFile_V2(), can do next oblig also
    }

}
