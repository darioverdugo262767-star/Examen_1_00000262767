package modelo;

/**
 *
 * @author Dario
 */
public interface IOperacionesModelo {
    void buscarEstudiantesPorId(String idCriterio);
    void seleccionarEstudiante(Estudiante estudiante);
    void generarConstancia();
}
