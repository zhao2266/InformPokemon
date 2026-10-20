import java.util.*;

public class Informe {

    public String generarInforme(ArrayList<Pokemon> lista) {

        int total = lista.size();

        int sumaNiveles = 0;
        int sumaPs = 0;

        Pokemon mayorNivel = lista.get(0);
        Pokemon mayorPs = lista.get(0);

        HashMap<String, ArrayList<String>> porTipo = new HashMap<>();

        for (Pokemon p : lista) {

            sumaNiveles += p.getNivel();
            sumaPs += p.getPs();

            if (p.getNivel() > mayorNivel.getNivel()) {
                mayorNivel = p;
            }

            if (p.getPs() > mayorPs.getPs()) {
                mayorPs = p;
            }

            if (!porTipo.containsKey(p.getTipo())) {
                porTipo.put(p.getTipo(), new ArrayList<String>());
            }

            porTipo.get(p.getTipo()).add(p.getNombre());
        }

        double nivelMedio = (double) sumaNiveles / total;
        double psMedio = (double) sumaPs / total;

        String texto = "";
        texto += "=========================\n";
        texto += " INFORME DE POKEMON\n";
        texto += "=========================\n";
        texto += "Total de Pokemon: " + total + "\n";
        texto += "Nivel medio: " + nivelMedio + "\n";
        texto += "PS medios: " + psMedio + "\n\n";

        texto += "Pokemon con mayor nivel:\n";
        texto += mayorNivel.getNombre() + " (" + mayorNivel.getNivel() + ")\n\n";

        texto += "Pokemon con mas PS:\n";
        texto += mayorPs.getNombre() + " (" + mayorPs.getPs() + ")\n\n";

        texto += "-------------------------\n";
        texto += "POKEMON POR TIPO\n";
        texto += "-------------------------\n";

        for (String tipo : porTipo.keySet()) {

            texto += "\n" + tipo + ": " + porTipo.get(tipo).size() + "\n";

            for (String nombre : porTipo.get(tipo)) {
                texto += nombre + "\n";
            }
        }

        return texto;
    }
}