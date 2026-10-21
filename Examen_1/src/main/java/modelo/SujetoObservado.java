package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dario
 */
public abstract class SujetoObservado {
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar();
        }
    }
}