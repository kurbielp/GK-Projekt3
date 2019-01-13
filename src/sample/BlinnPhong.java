package sample;

public class BlinnPhong {
    //zastosowanie modelu blinnaphonga
    public static double bphong(Vector V,Vector L,Vector N,Point p, double m, double ip, double kd, double ks){
        V.normalize();
        L.normalize();
        N.normalize();

        Vector H = V.caluclateH(L);
        H.normalize();

        double NdotL = saturate(N.dot(L)); //(L o N)
        double NdotH = saturate(N.dot(H)); //(N o H)

        double wynik = kd * NdotL * ip + ks * Math.pow(NdotH, m) * ip ;

        return saturate(wynik);
    }
// sprawdzanie czy nie wychodzi poza zakres 0 1
    private static double saturate(double x){
        if(x < 0)
            return 0;
        if(x > 1)
            return 1;
        return x;

    }
}
