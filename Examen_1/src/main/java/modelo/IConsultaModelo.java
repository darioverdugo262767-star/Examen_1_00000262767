package modelo;

import java.util.List;

/**
 *
 * @author Dario
 */
public interface IConsultaModelo {
    List<Estudiante> getEstudiantesEncontrados();
    Estudiante getEstudianteSeleccionado();
    Constancia getConstanciaGenerada();
}
