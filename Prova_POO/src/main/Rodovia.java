package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rodovia {
     private String sigla;
    private String grauPericulosidade;
    private List<Acidente> acidentes;

    public Rodovia(String sigla, String grauPericulosidade) {
        this.sigla = sigla;
        this.grauPericulosidade = grauPericulosidade;
        this.acidentes = new ArrayList<>();
    }

    public void cadastrarAcidente(Acidente acidente) {
        this.acidentes.add(acidente);
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getGrauPericulosidade() {
        return grauPericulosidade;
    }

    public void setGrauPericulosidade(String grauPericulosidade) {
        this.grauPericulosidade = grauPericulosidade;
    }

    public List<Acidente> getAcidentes() {
        return acidentes;
    }

    public void setAcidentes(List<Acidente> acidentes) {
        this.acidentes = acidentes;
    }

    public int contarAcidentesComVitimasFatais() {
        int totalAcidentesFatais = 0;
        for (Acidente acidente : acidentes) {
            totalAcidentesFatais += acidente.getVitimasFatais();
        }
        return totalAcidentesFatais;
    }

    public int contarAcidentesComVeiculosNovos(int ano) {
        int totalAcidentesVeiculosNovos = 0;
        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.getVeiculosEnvolvidos()) {
                if (veiculo.getAnoFabricacao() == ano) {
                    totalAcidentesVeiculosNovos++;
                    break; 
                }
            }
        }
        return totalAcidentesVeiculosNovos;
    }

    public int contarAcidentesComBicicletas() {
        int totalAcidentesBicicletas = 0;
        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.getVeiculosEnvolvidos()) {
                if (veiculo instanceof Bicicleta) {
                    totalAcidentesBicicletas++;
                    break; 
                }
            }
        }
        return totalAcidentesBicicletas;
    }
    
	public static List<Rodovia> rodoviasComAcidentesNoCarnaval(List<Rodovia> of, int i) {
		return null;
	}

	public Rodovia listarAcidentesNoCarnaval() {
		return null;
	}

	public Rodovia getRodovia() {
		return null;
	}

	public Rodovia listarAcidentesNoCarnaval1() {
		return null;
	}
	
	public int contarAcidentesNoCarnaval() {
        int totalAcidentesCarnaval = 0;
        for (Acidente acidente : acidentes) {
            if (acidente.ocorreuNoCarnaval()) {
                totalAcidentesCarnaval++;
            }
        }
		return totalAcidentesCarnaval;
    }
	public void listarAcidentesComCondutorEmbriagado() {
        for (Acidente acidente : acidentes) {
            boolean condutorEmbriagado = acidente.verificarCondutorEmbriagado();
            if (condutorEmbriagado) {
                System.out.println("Acidente na rodovia " + sigla + " onde algum condutor estava embriagado:");
                System.out.println("Quantidade de vitimas fatais: " + acidente.getVitimasFatais());
            }
            
        }
    }
	public void listarAcidentesPorNivelPericulosidade() {
        System.out.println("Rodovia " + sigla);
        System.out.println("Acidentes por nivel de periculosidade:");

        for (String nivel : Arrays.asList("baixo", "medio", "alto")) {
            System.out.println("Nivel de periculosidade: " + nivel);
            for (Acidente acidente : acidentes) {
                if (acidente.getRodovia().equals(this) && acidente.getRodovia().getGrauPericulosidade().equals(nivel)) {
                    System.out.println("Acidente na rodovia " + sigla);
                    System.out.println("Quantidade de vitimas fatais: " + acidente.getVitimasFatais());
                }
            }
        }
    }
	
	public static List<Rodovia> getRodoviasNoCarnaval() {
		return getRodoviasNoCarnaval();
	}

	public static void setRodoviasNoCarnaval(List<Rodovia> rodoviasNoCarnaval) {
		Main.rodoviasNoCarnaval = rodoviasNoCarnaval;
		
		}
}



