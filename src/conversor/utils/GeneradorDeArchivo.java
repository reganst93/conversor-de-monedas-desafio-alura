package conversor.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversor.model.ConversionResponse;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson (ConversionResponse resultado){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter escritura = new FileWriter("conversion_" + resultado.base_code() + "_a_" + resultado.target_code() + ".json");
            escritura.write(gson.toJson(resultado));
            escritura.close();
            System.out.println("✅ Resultado guardado en archivo JSON.");
        } catch (IOException e) {
            System.out.println("❌ No se pudo guardar el archivo: " + e.getMessage());
        }
    }
}

