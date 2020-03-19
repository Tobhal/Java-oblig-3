package com.company;

public abstract class CelestialBody {       // CelestialBody is abstract because we do not need to create a object of this class
    protected String name;      // The name of the planet
    protected double radius;    // The radius of the planet
    protected double mass;      // The gravoty of the planet
    protected double semiMajorAxis;
    protected double eccentricity;
    protected double orbitalPeriod;

    CelestialBody() {
    }
    CelestialBody(String name) {
        this.name = name;
    }
    CelestialBody(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }
    CelestialBody(String name, double mass, double radius) {  // Makes it posible to use constroctors with the class, so i can add parameters to the new Planet insted of setting that later
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }
    CelestialBody(String name, double mass, double radius, double semiMajorAxis) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.semiMajorAxis = semiMajorAxis;
    }
    CelestialBody(String name, double mass, double radius, double semiMajorAxis, double eccentricity) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
    }
    CelestialBody(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    public double getMassRadiusRatio() {
        return mass / radius;
    }

}
