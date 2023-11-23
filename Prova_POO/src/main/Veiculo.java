package main;

public class Veiculo {
    private int anoFabricacao;
    private double carga;

    public Veiculo(int anoFabricacao, double carga) {
        this.anoFabricacao = anoFabricacao;
        this.carga = carga;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
} 
