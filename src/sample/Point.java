package sample;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Point {


    private double x;
    private double y;
    private double z;

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    Dimension dimension;

    public Point(double x, double y , double z , Dimension dimension){
        this.x = x;
        this.y = y;
        this.z = z;
        this.dimension = dimension;

    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor(double p){

        int v =  (int) (255 * p);
        if(v < 0)
            v = 0;
        else if( v > 255)
            v = 255;

        return new Color(v,v,v);
    }


}
