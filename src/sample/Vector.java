package sample;

public class Vector {

    //współrzędne
    private double x;
    private double y;
    private double z;

    //konstruktor
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //gettery i settery
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    //długość wektora
    public double length(){
        return Math.sqrt(Math.pow(x,2) +Math.pow(y,2)+Math.pow(z,2));
    }

    //mnożenie skalarne wektorów
    public double dot(Vector v){
        return x*v.x + y*v.y + z*v.z;
    }

    // mnozenie przez liczbe
    public void mulitply (double k){
        x = x*k;
        y = y*k;
        z = z*k;
    }

    //normalizacja wektora
    public void normalize(){
        this.mulitply(1/length());
    }

    //wektor h potrzebny do modelu blinna phonga
    public Vector caluclateH(Vector v){
        Vector temp = new Vector(x,y,z);
        double k = v.length() / temp.length();
        temp.mulitply(k);
        Vector x = new Vector(v.x - temp.y,v.y - temp.y,v.z - temp.z);

        double xb = temp.x + x.x/2;
        double yb = temp.y + x.y/2;
        double zb = temp.z + x.z/2;
        return new Vector(xb,yb,zb);
    }
}
