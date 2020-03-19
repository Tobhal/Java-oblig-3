package com.company;

import java.util.List;
import java.io.File;
import java.io.FileWriter;

import static com.company.Main.createCenterStar;

public class SaveFile {

    static String planetSavePath = "solar_system_planets";
    static String planetSaveExtension = ".csv";
    static String planetCSVDevider = ",";

    public static void saveFile_V1(List<PlanetSystem> planetSystems) {
        planetSaveExtension = ".csv";
        try {
            File file = new File(planetSavePath + "_UserSaved" + planetSaveExtension);    // Creates the file
            FileWriter fileWriter = new FileWriter(file);   // Starts a new file Writer on the file

            fileWriter.write("name,mass,radius,semiMajorAxis,eccentricity,orbitalPeriod,centralCelestialBody,type");  // Adds the headers

            for (PlanetSystem planetSystem : planetSystems) {
                fileWriter.write("\n");
                fileWriter.write(planetSystem.getCenterStar().getName() + planetCSVDevider +
                        planetSystem.getCenterStar().getMass() + planetCSVDevider +
                        planetSystem.getCenterStar().getRadius() + planetCSVDevider +
                        planetSystem.getCenterStar().getEffectiveTemp() +
                        "sun");

                for (int j = 0; j < planetSystems.get(0).getNumberOfPlanets(); j++) {   // Print all planets
                    fileWriter.write("\n");
                    fileWriter.write(planetSystems.get(0).getPlanet(j).getName() + planetCSVDevider +
                            planetSystem.getPlanet(j).getMass() + planetCSVDevider +
                            planetSystem.getPlanet(j).getRadius() + planetCSVDevider +
                            planetSystem.getPlanet(j).getSemiMajorAxis() + planetCSVDevider +
                            planetSystem.getPlanet(j).getEccentricity() + planetCSVDevider +
                            planetSystem.getPlanet(j).getOrbitalPeriod() + planetCSVDevider +
                            planetSystem.getPlanet(j).getCentralCelestialBody().getName() + planetCSVDevider +
                            "planet");

                    for (int k = 0; k < planetSystems.get(0).getPlanet(j).numberOfMoons(); k++) {
                        fileWriter.write("\n");
                        fileWriter.write(planetSystems.get(0).getPlanet(j).getMoon(k).getName() + planetCSVDevider +
                                planetSystem.getPlanet(j).getMoon(k).getMass() + planetCSVDevider +
                                planetSystem.getPlanet(j).getMoon(k).getRadius() + planetCSVDevider +
                                planetSystem.getPlanet(j).getMoon(k).getSemiMajorAxis() + planetCSVDevider +
                                planetSystem.getPlanet(j).getMoon(k).getEccentricity() + planetCSVDevider +
                                planetSystem.getPlanet(j).getMoon(k).getOrbitalPeriod() + planetCSVDevider +
                                planetSystem.getPlanet(j).getMoon(k).getCentralCelestialBody().getName() + planetCSVDevider +
                                "moon");
                    }
                }
            }

            fileWriter.flush();   // Remoes the buffer of characters
            fileWriter.close();   // Close the fileWriter afther the it is flushed

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void saveFile_V2(List<PlanetSystem> planetSystems) {
        planetSaveExtension = ".txt";
        try {
            File file = new File(planetSavePath + "_UserSaved_test" + planetSaveExtension);
            FileWriter fileWriter = new FileWriter(file);

            for (int i = 0; i < planetSystems.size(); i++) {
                fileWriter.write(planetSystems.get(i).getName() + "\n");

                fileWriter.write("  " + "Stars:\n");

                if (planetSystems.get(i).getCenterStar() == null) {
                    createCenterStar(i);
                }

                fileWriter.write("    " + "Name: " + planetSystems.get(i).getCenterStar().getName() + "\n");

                fileWriter.write("      " + "Mass: " + planetSystems.get(i).getCenterStar().getMass() + "\n");
                fileWriter.write("      " + "Radius: " + planetSystems.get(i).getCenterStar().getRadius() + "\n");
                fileWriter.write("      " + "Effective Temprature: " + planetSystems.get(i).getCenterStar().getEffectiveTemp() + "\n");

                fileWriter.write("  " + "Planets:\n");

                for (int l = 0; l < planetSystems.get(i).getNumberOfPlanets(); l++) {    // Prints the planets
                    fileWriter.write("    " + "Name: " + planetSystems.get(i).getPlanet(l).getName() + "\n");

                    fileWriter.write("      " + "Mass: " + planetSystems.get(i).getPlanet(l).getMass() + "\n");
                    fileWriter.write("      " + "Radius: " + planetSystems.get(i).getPlanet(l).getRadius() + "\n");
                    fileWriter.write("      " + "Radius: " + planetSystems.get(i).getPlanet(l).getRadius() + "\n");
                    fileWriter.write("\t" + "Radius: " + planetSystems.get(i).getPlanet(l).getRadius() + "\n");
                }

                fileWriter.write("\n");
            }

            fileWriter.flush();   // Remoes the buffer of characters
            fileWriter.close();   // Close the fileWriter afther the it is flushed

        } catch (Exception e) { }
    }

    public static void saveFile_V2_5(List<PlanetSystem> planetSystems) {
        planetSaveExtension = ".txt";
        try {
            File file = new File(planetSavePath + "_UserSaved_test2" + planetSaveExtension);
            FileWriter fileWriter = new FileWriter(file);

            for (int i = 0; i < planetSystems.size(); i++) {
                fileWriter.write("System Name: " + planetSystems.get(i).getName() + "\n");

                fileWriter.write("\t" + "Stars:\n");

                if (planetSystems.get(i).getCenterStar() == null) {
                    createCenterStar(i);
                }

                fileWriter.write("\t\t" + "Name: " + planetSystems.get(i).getCenterStar().getName() + "\n");

                fileWriter.write("\t\t\t" + "Mass: " + planetSystems.get(i).getCenterStar().getMass() + "\n");
                fileWriter.write("\t\t\t" + "Radius: " + planetSystems.get(i).getCenterStar().getRadius() + "\n");
                fileWriter.write("\t\t\t" + "Effective Temprature: " + planetSystems.get(i).getCenterStar().getEffectiveTemp() + "\n");

                fileWriter.write("\t" + "Planets:\n");

                for (int l = 0; l < planetSystems.get(i).getNumberOfPlanets(); l++) {    // Prints the planets
                    fileWriter.write("\t\t" + "Name: " + planetSystems.get(i).getPlanet(l).getName() + "\n");

                    fileWriter.write("\t\t\t" + "Mass: " + planetSystems.get(i).getPlanet(l).getMass() + "\n");
                    fileWriter.write("\t\t\t" + "Radius: " + planetSystems.get(i).getPlanet(l).getRadius() + "\n");
                    fileWriter.write("\t\t\t" + "Semi MajorAxis: " + planetSystems.get(i).getPlanet(l).getSemiMajorAxis() + "\n");
                    fileWriter.write("\t\t\t" + "Eccentricity: " + planetSystems.get(i).getPlanet(l).getEccentricity() + "\n");
                    fileWriter.write("\t\t\t" + "Orbital Period: " + planetSystems.get(i).getPlanet(l).getOrbitalPeriod() + "\n");
                }

                fileWriter.write("\n");
            }

            fileWriter.flush();   // Remoes the buffer of characters
            fileWriter.close();   // Close the fileWriter afther the it is flushed

        } catch (Exception e) { }
    }

}