package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dario
 */
public class Constancia {
    private String folio;
    private String fechaEmision;
    private Estudiante estudiante;
    private static int contador = 0;

    public Constancia(Estudiante estudiante) {
        this.estudiante = estudiante;
        contador++;
        this.folio = String.format("CONST-%03d", contador);
        this.fechaEmision = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getFolio() {
        return folio; 
    }
    
    public String getFechaEmision() {
        return fechaEmision; 
    }
    
    public Estudiante getEstudiante() {
        return estudiante; 
    }
}
