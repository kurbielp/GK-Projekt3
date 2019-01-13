package sample;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class RysownikScene {

    //parametry dla kazdego z materiałów
    Hemisphere hemisphere;
    Integer material;
    //natezenie w swiatla w punkcie
    public double ip = 1.0;
    //natezenie w swiatla w otoczeniu

    public double ia = 0.1;

    public static int PLASTIK = 0;
    public static int KREDA = 1;
    public static int DREWNO = 2;
    public static int METAL = 3;
    //współczynnik odbicia światła od otoczenia
    public static double[] ka = {0.45, 0.8, 0.5, 0.1};
    ////współczynnik odbicia światła rozproszonego
    public static double[] kd = {0.9, 0.9, 0.6, 0.4};
    ////współczynnik odbicia światła kierunkowego
    public static double[] ks = {0.2, 0.01, 0.4, 0.6};
    //współczynnik gładkości
    public static double[] m = {50, 25, 10, 100};

    //wspórzedne promienia
    public double xL = -70;
    public double yL = -70;
    public double zL = 40;

    public Canvas getCanvas() {
        return canvas;
    }
    public static double[] getKa() {
        return ka;
    }

    public static double[] getKd() {
        return kd;
    }

    public static double[] getKs() {
        return ks;
    }

    public static double[] getM() {
        return m;
    }


    Canvas canvas;
//metoda rysujaca
    public RysownikScene(Integer material,double ip,double ia) {
        Hemisphere obiekt = new Hemisphere(100, new Dimension(200, 200), 150);
        this.hemisphere = obiekt;
        this.material = material;
        this.ip = ip;
        this.ia = ia;
        canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //dla kazdego punktu znajdującego się w półkuli oblicz kolor na podstawie bilina phonga
        for (Point punkt : hemisphere.getPoints()) {
            double fong = this.ip * BlinnPhong.bphong(new Vector(0, 0, -punkt.getZ()),
                    new Vector(this.xL - punkt.getX(),
                            this.yL - punkt.getY(),
                            this.zL - punkt.getZ()),
                    hemisphere.normal(punkt),
                    punkt,
                    m[material], this.ip, kd[material], ks[material]);
            double a = this.ia * ka[material];

            Double check = new Double(fong);
            if (check.equals(Double.NaN)) {
                fong = 0;
            }
            double res = fong + a;

            int v = (int) (255 * res);
            if (v < 0)
                v = 0;
            else if (v > 255)
                v = 255;

            javafx.scene.paint.Color c= Color.rgb(v, v, v);;
            /*
            switch (material) {
                case 0:
                    c = Color.rgb(1/3*v, 2/3*v, v);
                    break;
                case 1:
                    c = Color.rgb(v,1/3*v, 2/3*v);
                    break;
                case 2:
                    c = Color.rgb(1/3*v, v,2/3*v);
                    break;
                case 3:
                    c = Color.rgb(v, v, v);
                    break;
                default:
                    c = Color.rgb(v, v, v);
                    break;
            }
            */
            //g2d.setColor(punkt.getColor(res));
            //g2d.setColor(Color.yellow);
            //g2d.draw(punkt);
            gc.setFill(c);
            gc.fillRect(punkt.getX() + punkt.getDimension().width / 2, punkt.getY() + punkt.getDimension().height / 2, 1, 1);
        }
    }
}
