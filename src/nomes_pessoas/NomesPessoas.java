package nomes_pessoas;

/**
 * @author Mauri Ranieri
 */

public class NomesPessoas {
    
    private final String[] nomesMasculinos;
    private final String[] nomesFemininos;
    private final String[] sobrenomes;
    
    public NomesPessoas() {
        this.nomesMasculinos = new LeitorNomesJson().obterNomes("nomes masculinos");
        this.nomesFemininos = new LeitorNomesJson().obterNomes("nomes femininos");
        this.sobrenomes = new LeitorNomesJson().obterNomes("sobrenomes");   
    }
    
    public boolean arraysEstaoNulosOuVazios() {
        return nomesMasculinos == null || nomesMasculinos.length == 0 ||
               nomesFemininos == null || nomesFemininos.length == 0 ||
               sobrenomes == null || sobrenomes.length == 0;
    }
    
    public String gerarNome(String escolha) {
        if(arraysEstaoNulosOuVazios()) {
            return "Arrays de nomes ou sobrenomes nulos ou vazios";
        }
        
        String sobrenome = sobrenomes[(int) (Math.random() * sobrenomes.length)];
        
        switch(escolha) {
            case "nomes masculinos":
                return gerarNomeMasculino(sobrenome);
            case "nomes femininos":
                return gerarNomeFeminino(sobrenome);
            default:
                throw new IllegalArgumentException("Escolha inv�lida! -> " + escolha);
        }
    }

    private String gerarNomeMasculino(String sobrenome) {
        String nomeM = nomesMasculinos[(int) (Math.random() * nomesMasculinos.length)];
        return nomeM + " " + sobrenome;
    }

    private String gerarNomeFeminino(String sobrenome) {
        String nomeF = nomesFemininos[(int) (Math.random() * nomesFemininos.length)];
        return nomeF + " " + sobrenome;
    }
    
    private String lerNomes(String[] listaNomes) {
        if(listaNomes == null || listaNomes.length == 0) {
            return "vazio ou nulo";
        }    
        
        String nomesConcatenados = "";
        int tamanho = listaNomes.length;
        
        for(int i = 0; i < tamanho - 1; i++) {
            nomesConcatenados += listaNomes[i] + ", ";
        }
        nomesConcatenados += listaNomes[tamanho - 1];
        
        return nomesConcatenados;
    }
    
    @Override
    public String toString() {
        return "NomesPessoas {nomes masculinos=[" + lerNomes(this.nomesMasculinos) + 
                          "], nomes femininos=[" + lerNomes(this.nomesFemininos) +
                          "], sobrenomes=[" + lerNomes(this.sobrenomes) + "]}";
    }
}
