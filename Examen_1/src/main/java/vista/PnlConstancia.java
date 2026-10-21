package vista;

import modelo.Constancia;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Dario
 */
public class PnlConstancia extends JPanel {
    private JTextArea txtArea = new JTextArea();

    public PnlConstancia() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Constancia Generada"));
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);
    }

    public void mostrarConstancia(Constancia c) {
        String texto = "FOLIO: " + c.getFolio() + "\n" +
                       "FECHA DE EMISION: " + c.getFechaEmision() + "\n" +
                       "ALUMNO: " + c.getEstudiante().getNombreCompleto() + "\n" +
                       "ID: " + c.getEstudiante().getId() + "\n" +
                       "CARRERA: " + c.getEstudiante().getCarrera() + "\n" +
                       "SEMESTRE: " + c.getEstudiante().getSemestre()+ "\n" +
                       "MATERIAS INCRITAS: " + c.getEstudiante().getMateriasInscritas() + "\n\n" +
                       "Por medio de la presente se hace constar que el alumno esta INSCRITO.";
        txtArea.setText(texto);
    }

    public void limpiar() {
        txtArea.setText("");
    }
}