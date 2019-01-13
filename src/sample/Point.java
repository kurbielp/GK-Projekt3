package sample;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Point implements Shape {

    private Rectangle2D.Double area;

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

        area = new Rectangle2D.Double(x + dimension.width/2,y+dimension.height/2,1,1);
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


    @Override
    public boolean contains(Point2D p) {
        return area.contains(p);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return area.contains(r);
    }

    @Override
    public boolean contains(double x, double y) {
        return area.contains(x,y);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return area.contains(x,y,w,h);
    }

    @Override
    public Rectangle getBounds() {
        return area.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return area.getBounds2D();
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return area.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return area.getPathIterator(at,flatness);
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return area.intersects(r);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return area.intersects(x, y, w, h);
    }
}
