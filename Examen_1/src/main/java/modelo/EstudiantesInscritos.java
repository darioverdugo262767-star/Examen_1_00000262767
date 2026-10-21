package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Dario
 */
public class EstudiantesInscritos {
    private List<Estudiante> estudiantes;

    public EstudiantesInscritos() {
        this.estudiantes = new ArrayList<>();
        cargarEstudiantes();
    }

    private void cargarEstudiantes() {
        estudiantes.add(new Estudiante("00000262767", "Roki", "Saucedo", "Lopez", "Ingeniero en Software", 6, 6));
        estudiantes.add(new Estudiante("00000262747", "Pepe", "Pepusio", "Pepon", "Ingeniero en Software", 5, 7));
        estudiantes.add(new Estudiante("00000262743", "Lamine", "Yamal", "Ruiz", "Lic. en Administracion", 4, 5));
        estudiantes.add(new Estudiante("00000262777", "Cristian", "Mbappe", "Soto", "Ingeniero Industrial", 8, 4));
        estudiantes.add(new Estudiante("00000262789", "Jose", "Mourinho", "Castro", "Ingeniero en Software", 3, 6));
        estudiantes.add(new Estudiante("00000262788", "Juan", "Soto", "Pacheco", "Lic. en Psicologia", 2, 6));
        estudiantes.add(new Estudiante("00000262755", "Aaron", "Ohtani", "Betts", "Ingeniero en Software", 7, 5));
    }

    public List<Estudiante> buscarPorId(String idAlumno) {
        if (idAlumno == null || idAlumno.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return estudiantes.stream()
                .filter(e -> e.getId().contains(idAlumno.trim()))
                .collect(Collectors.toList());
    }
}
