package main;


import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Rodovia> acidentesNoCarnaval;
    static List<Rodovia> rodoviasNoCarnaval;

    public static void main(String[] args) {
        Rodovia br140 = new Rodovia("BR-140", "alto");
        Rodovia br120 = new Rodovia("BR-120", "médio");

        Veiculo carro = new Veiculo(2018, 0);
        Veiculo moto = new Veiculo(2020, 0);
        Veiculo caminhao = new Veiculo(2013, 1500);

        Acidente acidente1 = new Acidente(br140, 2, 3, 7);
        acidente1.adicionarVeiculoEnvolvido(carro);
        acidente1.adicionarVeiculoEnvolvido(moto);
        acidente1.adicionarVeiculoEnvolvido(caminhao);
        acidente1.adicionarVeiculoEnvolvido(new Bicicleta(2013));
        acidente1.adicionarVeiculoEnvolvido(new Bicicleta(2022));

        br140.cadastrarAcidente(acidente1);

        Acidente acidente2 = new Acidente(br120, 1, 2, 8);
        acidente2.adicionarVeiculoEnvolvido(carro);
        acidente2.adicionarVeiculoEnvolvido(new Bicicleta(2021));

        br120.cadastrarAcidente(acidente2);

        System.out.println("Acidentes com bicicletas na BR-140: " + br140.contarAcidentesComBicicletas());
        System.out.println("Rodovia com mais acidentes fatais: " + (br140.contarAcidentesComVitimasFatais() > br120.contarAcidentesComVitimasFatais() ? br140.getSigla() : br120.getSigla()));
        System.out.println("Acidentes com veículos novos em 2023: " + br140.contarAcidentesComVeiculosNovos(2023));

        setRodoviasNoCarnaval(Rodovia.rodoviasComAcidentesNoCarnaval(Arrays.asList(br140, br120), 2));
        System.out.println("Rodovias com acidentes no carnaval: " + (br140.contarAcidentesComVitimasFatais() > br120.contarAcidentesComVitimasFatais() ? br140.getSigla() : br120.getSigla()));
        br140.listarAcidentesComCondutorEmbriagado();
        br120.listarAcidentesComCondutorEmbriagado();

        br140.listarAcidentesPorNivelPericulosidade();
        br120.listarAcidentesPorNivelPericulosidade();

        List<Veiculo> veiculosCargaEnvolvidosBr140 = acidente1.listarVeiculosDeCargaEnvolvidos();
        System.out.println("Veículos de carga envolvidos em acidente na BR-140:");
        if (veiculosCargaEnvolvidosBr140 != null) {
            for (Veiculo veiculo : veiculosCargaEnvolvidosBr140) {
                System.out.println("Veículo de carga do ano " + veiculo.getAnoFabricacao());
            }
        } else {
            System.out.println("Nenhum veículo de carga envolvido em acidente na BR-140.");
        }

        List<Veiculo> veiculosCargaEnvolvidosBr120 = acidente2.listarVeiculosDeCargaEnvolvidos();
        System.out.println("Veículos de carga envolvidos em acidente na BR-120:");
        if (veiculosCargaEnvolvidosBr120 != null) {
            for (Veiculo veiculo : veiculosCargaEnvolvidosBr120) {
                System.out.println("Veículo de carga do ano " + veiculo.getAnoFabricacao());
            }
        } else {
            System.out.println("Nenhum veículo de carga envolvido em acidente na BR-120.");
        }

        Rodovia rodoviaComMaisAcidentesBicicletas = null;
        int maxAcidentesBicicletas = 0;

        for (Rodovia rodovia : Arrays.asList(br140, br120)) {
            int acidentesComBicicletas = rodovia.contarAcidentesComBicicletas();
            if (acidentesComBicicletas > maxAcidentesBicicletas) {
                maxAcidentesBicicletas = acidentesComBicicletas;
                rodoviaComMaisAcidentesBicicletas = rodovia;
            }
        }

        if (rodoviaComMaisAcidentesBicicletas != null) {
            System.out.println("Rodovia com mais acidentes envolvendo bicicletas: " + rodoviaComMaisAcidentesBicicletas.getSigla());
            System.out.println("Quantidade de acidentes com bicicletas: " + maxAcidentesBicicletas);
        } else {
            System.out.println("Não há informações suficientes para dizer qual a rodovia com mais acidentes de bicicleta.");
        }

        Rodovia rodoviaComMaisVitimasFatais = null;
        int maxVitimasFatais = 0;

        for (Rodovia rodovia : Arrays.asList(br140, br120)) {
            int vitimasFatais = rodovia.contarAcidentesComVitimasFatais();
            if (vitimasFatais > maxVitimasFatais) {
                maxVitimasFatais = vitimasFatais;
                rodoviaComMaisVitimasFatais = rodovia;
            }
        }

        if (rodoviaComMaisVitimasFatais != null) {
            System.out.println("Rodovia com mais vítimas fatais: " + rodoviaComMaisVitimasFatais.getSigla());
            System.out.println("Quantidade de vítimas fatais: " + maxVitimasFatais);
        } else {
            System.out.println("Não há informações suficientes para dizer qual a rodovia com mais vítimas fatais.");
        }

        int totalAcidentesVeiculosNovos2013 = 0;

        for (Rodovia rodovia : Arrays.asList(br140, br120)) {
            for (Acidente acidente : rodovia.getAcidentes()) {
                List<Veiculo> veiculosEnvolvidos = acidente.getVeiculosEnvolvidos();
                for (Veiculo veiculo : veiculosEnvolvidos) {
                    if (veiculo.getAnoFabricacao() == 2013) {
                        totalAcidentesVeiculosNovos2013++;
                    }
                }
            }
        }

        System.out.println("Quantidade de acidentes com veículos fabricados em 2013: " + totalAcidentesVeiculosNovos2013);
    }

    private static void setRodoviasNoCarnaval(List<Rodovia> rodoviasComAcidentesNoCarnaval) {
        rodoviasNoCarnaval = rodoviasComAcidentesNoCarnaval;
    }
}
