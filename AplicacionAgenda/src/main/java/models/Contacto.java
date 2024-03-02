package models;

public class Contacto {
    private String seudonimo;
    private int numTel;
    public Contacto(String seudonimo, int numeroTel) {
        this.seudonimo = seudonimo;
        this.numTel = numeroTel;
    }
    public Contacto() {
    }
    public String getSeudonimo() {
        return seudonimo;
    }
    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }
    public int getNumTel() {
        return numTel;
    }
    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "seudonimo='" + seudonimo + '\'' +
                ", numTel=" + numTel +
                '}';
    }
}
