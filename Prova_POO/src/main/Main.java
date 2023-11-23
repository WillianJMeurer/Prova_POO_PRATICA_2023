package main;


    import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Rodovia> acidentesNoCarnaval;
	static List<Rodovia> rodoviasNoCarnaval;

	public static void main(String[] args) {

        Rodovia br101 = new Rodovia("BR-101", "alto");
        Rodovia br116 = new Rodovia("BR-116", "médio");

        Veiculo carro = new Veiculo(2018, 0);
        Veiculo moto = new Veiculo(2020, 0);
        Veiculo caminhao = new Veiculo(2013, 1500);

        Acidente acidente1 = new Acidente(br101, 2, 3, 7);
        acidente1.adicionarVeiculoEnvolvido(carro);
        acidente1.adicionarVeiculoEnvolvido(moto);
        acidente1.adicionarVeiculoEnvolvido(caminhao);
        acidente1.adicionarVeiculoEnvolvido(new Bicicleta(2013));
        acidente1.adicionarVeiculoEnvolvido(new Bicicleta(2022));

        br101.cadastrarAcidente(acidente1);

        Acidente acidente2 = new Acidente(br116, 1, 2, 8);
        acidente2.adicionarVeiculoEnvolvido(carro);
        acidente2.adicionarVeiculoEnvolvido(new Bicicleta(2021));

        br116.cadastrarAcidente(acidente2);

        System.out.println("acidentes com bicicletas na BR-101: " + br101.contarAcidentesComBicicletas());
        System.out.println("Rodovia com mais acidentes fatais: " + (br101.contarAcidentesComVitimasFatais() > br116.contarAcidentesComVitimasFatais() ? br101.getSigla() : br116.getSigla()));
        System.out.println("acidentes com veiculos novos em 2023: " + br101.contarAcidentesComVeiculosNovos(2023));

        setRodoviasNoCarnaval(Rodovia.rodoviasComAcidentesNoCarnaval(List.of(br101, br116), 2));
        System.out.println("Rodovias com acidentes no carnaval:"+ (br101.contarAcidentesComVitimasFatais() > br116.contarAcidentesComVitimasFatais() ? br101.getSigla() : br116.getSigla()));
        br101.listarAcidentesComCondutorEmbriagado();
        br116.listarAcidentesComCondutorEmbriagado();
        
        br101.listarAcidentesPorNivelPericulosidade();
        br116.listarAcidentesPorNivelPericulosidade();
        
        List<Veiculo> veiculosCargaEnvolvidosBr101 = acidente1.listarVeiculosDeCargaEnvolvidos();
        System.out.println("Veiculos de carga envolvidos em acidente na BR-101:");
        if (veiculosCargaEnvolvidosBr101 != null) {
            for (Veiculo veiculo : veiculosCargaEnvolvidosBr101) {
                System.out.println("Veiculo de carga do ano " + veiculo.getAnoFabricacao());
            }
        } else {
            System.out.println("Nenhum veiculo de carga envolvido em acidente na BR-101.");
        }

        List<Veiculo> veiculosCargaEnvolvidosBr116 = acidente2.listarVeiculosDeCargaEnvolvidos();
        System.out.println("Veiculos de carga envolvidos em acidente na BR-116:");
        if (veiculosCargaEnvolvidosBr116 != null) {
            for (Veiculo veiculo : veiculosCargaEnvolvidosBr116) {
                System.out.println("Veiculo de carga do ano " + veiculo.getAnoFabricacao());
            }
        } else {
            System.out.println("Nenhum veiculo de carga envolvido em acidente na BR-116.");
        }
        
        Rodovia rodoviaComMaisAcidentesBicicletas = null;
        int maxAcidentesBicicletas = 0;

        for (Rodovia rodovia : Arrays.asList(br101, br116)) {
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
            System.out.println("Não tem informacoes suficientes para dizer qual a rodovia com mais acidentes de bicicleta.");
        }
        
        Rodovia rodoviaComMaisVitimasFatais = null;
        int maxVitimasFatais = 0;

        for (Rodovia rodovia : Arrays.asList(br101, br116)) {
            int vitimasFatais = rodovia.contarAcidentesComVitimasFatais();
            if (vitimasFatais > maxVitimasFatais) {
                maxVitimasFatais = vitimasFatais;
                rodoviaComMaisVitimasFatais = rodovia;
            }
        }

        if (rodoviaComMaisVitimasFatais != null) {
            System.out.println("Rodovia com mais vitimas fatais: " + rodoviaComMaisVitimasFatais.getSigla());
            System.out.println("Quantidade de vitimas fatais: " + maxVitimasFatais);
        } else {
            System.out.println("Não tem informacoes suficientes para dizer qual a rodovia com mais vitimas fatais.");
        }
        
        int totalAcidentesVeiculosNovos2013 = 0;

        for (Rodovia rodovia : Arrays.asList(br101, br116)) { 
            for (Acidente acidente : rodovia.getAcidentes()) {
                List<Veiculo> veiculosEnvolvidos = acidente.getVeiculosEnvolvidos();
                for (Veiculo veiculo : veiculosEnvolvidos) {
                    if (veiculo.getAnoFabricacao() == 2013) {
                        totalAcidentesVeiculosNovos2013++; 
                    }
                }
            }
        }

        System.out.println("quantos acidentes com veiculos fabricados em 2013: " + totalAcidentesVeiculosNovos2013);
	}

	private static void setRodoviasNoCarnaval(List<Rodovia> rodoviasComAcidentesNoCarnaval) {
		
	}

}	
