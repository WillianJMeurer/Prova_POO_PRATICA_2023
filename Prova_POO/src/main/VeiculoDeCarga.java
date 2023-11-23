package main;

public class VeiculoDeCarga extends Veiculo {
    private double capacidadeCarga;

    public VeiculoDeCarga(int anoFabricacao, double capacidadeCarga) {
        super(anoFabricacao, capacidadeCarga);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

}
