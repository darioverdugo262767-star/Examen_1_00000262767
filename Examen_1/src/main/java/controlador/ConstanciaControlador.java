package controlador;

import modelo.Estudiante;
import modelo.IOperacionesModelo;

/**
 *
 * @author Dario
 */
public class ConstanciaControlador {
    private IOperacionesModelo modelo;

    public void setModelo(IOperacionesModelo modelo) {
        this.modelo = modelo;
    }

    public void buscarEstudiantes(String idAlumno) {
        modelo.buscarEstudiantesPorId(idAlumno);
    }

    public void seleccionarEstudiante(Estudiante estudiante) {
        modelo.seleccionarEstudiante(estudiante);
    }

    public void solicitarGenerarConstancia() {
        modelo.generarConstancia();
    }
}
