package data;

public class Kdistance {
    private double distancia;
    private String vecinos;

    public Kdistance(){
        distancia = '0';
        vecinos = "Desconocido";
    }

    public Kdistance(double distance, String neighbors){
        distancia = distance;
        vecinos = neighbors;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getVecinos() {
        return vecinos;
    }

    public void setVecinos(String vecinos) {
        this.vecinos = vecinos;
    }
}
