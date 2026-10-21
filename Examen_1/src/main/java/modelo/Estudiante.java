package modelo;

/**
 *
 * @author Dario
 */
public class Estudiante {
    private String id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String carrera;
    private int semestre;
    private int materiasInscritas;

    public Estudiante(
        String id,
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno,
        String carrera,
        int semestre,
        int materiasInscritas
    ) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrera = carrera;
        this.semestre = semestre;
        this.materiasInscritas = materiasInscritas;
    }

    public String getId() {
        return id; 
    }
    
    public String getNombres() {
        return nombres; 
    }
    
    public String getApellidoPaterno() {
        return apellidoPaterno; 
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno; 
    }
    
    public String getCarrera() {
        return carrera; 
    }
    
    public int getSemestre() {
        return semestre; 
    }
    
    public int getMateriasInscritas() {
        return materiasInscritas; 
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    @Override
    public String toString() {
        return id;
    }
}
