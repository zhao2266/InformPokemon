import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Pokemon> lista =
                CargarJson.cargarPokemon("src/main/resources/pokemon.json");

        Informe informe = new Informe();

        String texto = informe.generarInforme(lista);

        try {
            FileWriter escritor =
                    new FileWriter("informe_pokemon.txt");

            escritor.write(texto);
            escritor.close();

            System.out.println("Informe generado.");
        } catch (Exception e) {
            System.out.println("Error al generar el informe.");
        }
    }
}