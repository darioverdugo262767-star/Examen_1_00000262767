package modelo;

import java.util.ArrayList;
import java.util.List;

public class FachadaModeloConstancia extends SujetoObservado implements IConsultaModelo, IOperacionesModelo {
    private EstudiantesInscritos estudiantes;
    private List<Estudiante> estudiantesEncontrados;
    private Estudiante estudianteSeleccionado;
    private Constancia constanciaGenerada;

    public FachadaModeloConstancia() {
        this.estudiantes = new EstudiantesInscritos();
        this.estudiantesEncontrados = new ArrayList<>();
    }

    @Override
    public void buscarEstudiantesPorId(String idAlumno) {
        this.estudiantesEncontrados = estudiantes.buscarPorId(idAlumno);
        notificarObservadores();
    }

    @Override
    public void seleccionarEstudiante(Estudiante estudiante) {
        this.estudianteSeleccionado = estudiante;
        this.constanciaGenerada = null;
        notificarObservadores();
    }

    @Override
    public void generarConstancia() {
        if (this.estudianteSeleccionado != null) {
            this.constanciaGenerada = new Constancia(this.estudianteSeleccionado);
            notificarObservadores();
        }
    }
    
    @Override
    public List<Estudiante> getEstudiantesEncontrados() {
        return estudiantesEncontrados;
    }

    @Override
    public Estudiante getEstudianteSeleccionado() {
        return estudianteSeleccionado;
    }

    @Override
    public Constancia getConstanciaGenerada() {
        return constanciaGenerada;
    }
}