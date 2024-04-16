package nomes_pessoas;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Mauri Ranieri
 */

public class LeitorNomesJson {
    
    String caminhoArquivoJSON = "src/nomesjson.json";
    
    public String[] obterNomes(String chave) {
        String[] listaNomes = null;
        
        try (FileReader leitor = new FileReader(caminhoArquivoJSON)) {
            JsonObject objetoJson = JsonParser.parseReader(leitor).getAsJsonObject();
            JsonArray arrayNomes = obterArrayJson(objetoJson, chave);
            listaNomes = new Gson().fromJson(arrayNomes, String[].class);
            
            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
            
        return listaNomes;
    }
    
    private JsonArray obterArrayJson(JsonObject objetoJson, String chave) {
        return (objetoJson.has(chave)) ? objetoJson.get(chave).getAsJsonArray() : null;
    }
}
