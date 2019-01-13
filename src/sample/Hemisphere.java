package sample;

import java.awt.*;
import java.util.ArrayList;

public class Hemisphere {

    public double distanceFromViewport = 130.0;
    private ArrayList<Point> points;
    private double radius;
    private double distance;
    private Dimension dimension;

    //konstruktor
    public Hemisphere(double radius , Dimension dimension, double distance){
        this.dimension = dimension;
        this.distance = distance;
        this.radius = radius;
        this.create();
    }

//sprawdza czy punkt zawiera się w półkolu
    private boolean isContainsPonts(double x, double y){

        double a = 1;
        double b = -2*distance;
        double c = Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(distance, 2) - Math.pow(radius, 2);

        double delta = Math.pow(b, 2) - 4*a*c;

        if(delta < 0)
            return false;
        else
            return true;
    }

    //tworzy półkule z punktów
    private void create(){
        points = new ArrayList<Point>();
        double a,b,c,delta;

        for(int x = 0; x < dimension.width ;x++)
            for(int y = 0; y < dimension.height ; y++){
                if(isContainsPonts(x - dimension.width/2, y-dimension.height/2)) {
                    a = 1;
                    b = -2*distance;
                    c = Math.pow((x - dimension.width/2), 2) + Math.pow((y-dimension.height/2), 2) + Math.pow(distance, 2) - Math.pow(radius, 2);
                    delta = Math.pow(b, 2) - 4*a*c;

                    points.add(new Point(x - dimension.width/2, y-dimension.height/2, (-b - Math.sqrt(delta))/2*a, dimension));
                }
            }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }


    public Vector normal(Point point){
        return new Vector(point.getX(),point.getY(),point.getZ() - distanceFromViewport);
    }
}
