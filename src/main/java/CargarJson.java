import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.util.ArrayList;

public class CargarJson {

    public static ArrayList<Pokemon> cargarPokemon(String ruta) {

        try {
            Gson gson = new Gson();

            FileReader lector = new FileReader(ruta);

            return gson.fromJson(
                    lector,
                    new TypeToken<ArrayList<Pokemon>>(){}.getType()
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}