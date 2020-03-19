package com.company;

import java.util.ArrayList;

import static com.company.Main.sc;

public class Planet extends NaturalSatellite {

    public Planet() {
    }
    Planet(String name) {
        super(name);
    }
    Planet(String name, double mass) {
        super(name, mass);
    }
    Planet(String name, double mass, double radius) {
        super(name, mass, radius);
    }
    Planet(String name, double mass, double radius, double semiMajorAxis) {
        super(name, mass, radius, semiMajorAxis);
    }
    Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity) {
        super(name, mass, radius, semiMajorAxis, eccentricity);
    }
    Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod);
    }
    Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody);
    }

    // TODO: Just add a arrayList for moons to the planet?
    private ArrayList<Moon> moons = new ArrayList<>();

    public void printPlanet() {   // Prints all of the plannets that is stored
        System.out.println("The planet " + name + " has a radus of: " + radius + " km and the gravity is: " + mass + "");
    }

    public double surfaceGravity() {
        return (0.00000000006674 * mass)/(Math.pow((radius * 1000), 2));
    }

    public Moon getMoon(int index) {
        return moons.get(index);
    }

    public Moon getMoon(String name) {
        for (Moon moon : moons) {
            if (moon.name.equals(name))
                return moon;
        }
        return null;
    }

    public Boolean hasMoon(String name) {
        for (Moon moon : moons) {
            if (moon.name.equals(name))
                return true;
        }
        return false;
    }

    public int numberOfMoons() {
        return moons.size();
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }

    public void printInfo() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(name + " has theas properties:");
        System.out.println("Mass: " + mass +
                "\nRadius: " + radius +
                "\nSemi Maijor Axis: " + semiMajorAxis +
                "\nEccentricity: " + eccentricity +
                "\nOrbital period: " + orbitalPeriod +
                "\nIs Orbeting: " + centralCelestialBody.getName());
        if (!moons.isEmpty()) {
            System.out.println("Have this moons:");
            for (Moon moon:moons) {
                System.out.println(moon.getName());
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void printAllInfo() {
        System.out.println(toString());
        if (!moons.isEmpty()) {
            for (Moon moon : moons) {
                System.out.println(moon.toString());
            }
        }

    }
}

/*
 */