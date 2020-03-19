package com.company;

public class Moon extends NaturalSatellite {
    // TODO: Add things...
    public Moon() {
    }
    Moon(String name) {
        super(name);
    }
    Moon(String name, double mass) {
        super(name, mass);
    }
    Moon(String name, double mass, double radius) {
        super(name, mass, radius);
    }
    Moon(String name, double mass, double radius, double semiMajorAxis) {
        super(name, mass, radius, semiMajorAxis);
    }
    Moon(String name, double mass, double radius, double semiMajorAxis, double eccentricity) {
        super(name, mass, radius, semiMajorAxis, eccentricity);
    }
    Moon(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod);
    }
    Moon(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, String centralCelestialBody) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody);
    }

    public void printAllInfo() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(name + " has theas properties:");
        System.out.println("Mass: " + mass +
                "\nRadius: " + radius +
                "\nSemi Maijor Axis: " + semiMajorAxis +
                "\nEccentricity: " + eccentricity +
                "\nOrbital period: " + orbitalPeriod +
                "\nIs Orbeting: " + centralCelestialBody.getName());
        System.out.println("--------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Mass: " + mass + " | Radius: " + radius + "\n" +
                "Semi Maijor Axis: " + semiMajorAxis + " | Eccentricity: " + eccentricity + " | Orbital Period: " + orbitalPeriod + "\n" +
                "Orbering: " + centralCelestialBody;
    }
}
