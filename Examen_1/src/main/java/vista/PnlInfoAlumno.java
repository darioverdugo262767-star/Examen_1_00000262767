package vista;

import modelo.Estudiante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Dario
 */
public class PnlInfoAlumno extends JPanel {
    private JTextField txtNombres;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtId;
    private JTextField txtCarrera;
    private JTextField txtSemestre;
    private JTextField txtMateriasInscritas;
    private JButton btnGenerarConstancia;

    public PnlInfoAlumno() {
        setBorder(BorderFactory.createTitledBorder("Informacion del Alumno"));
        setLayout(new GridLayout(8, 2, 5, 5));
        initComponentes();
    }

    private void initComponentes() {
        txtNombres = new JTextField();
        txtApellidoPaterno = new JTextField();
        txtApellidoMaterno = new JTextField();
        txtId = new JTextField();
        txtCarrera = new JTextField();
        txtSemestre = new JTextField();
        txtMateriasInscritas = new JTextField();
        btnGenerarConstancia = new JButton("Generar Constancia");

        JTextField[] campos = {txtNombres, txtApellidoPaterno, txtApellidoMaterno, txtId, txtCarrera, txtSemestre, txtMateriasInscritas};
        for (JTextField tf : campos) {
            tf.setEditable(false);
            tf.setBackground(Color.WHITE);
        }

        add(new JLabel("Nombres:"));
        add(txtNombres);
        add(new JLabel("Apellido Paterno:"));
        add(txtApellidoPaterno);
        add(new JLabel("Apellido Materno:"));
        add(txtApellidoMaterno);
        add(new JLabel("ID:"));
        add(txtId);
        add(new JLabel("Carrera:"));
        add(txtCarrera);
        add(new JLabel("Semestre:"));
        add(txtSemestre);
        add(new JLabel("Materias inscritas:"));
        add(txtMateriasInscritas);
        add(new JLabel());
        add(btnGenerarConstancia);
        btnGenerarConstancia.setEnabled(false);
    }

    public void cargarDatos(Estudiante e) {
        if (e != null) {
            txtNombres.setText(e.getNombres());
            txtApellidoPaterno.setText(e.getApellidoPaterno());
            txtApellidoMaterno.setText(e.getApellidoMaterno());
            txtId.setText(e.getId());
            txtCarrera.setText(e.getCarrera());
            txtSemestre.setText(String.valueOf(e.getSemestre()));
            txtMateriasInscritas.setText(String.valueOf(e.getMateriasInscritas()));
            btnGenerarConstancia.setEnabled(true);
        } else {
            limpiar();
        }
    }

    public void limpiar() {
        txtNombres.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtId.setText("");
        txtCarrera.setText("");
        txtSemestre.setText("");
        txtMateriasInscritas.setText("");
        btnGenerarConstancia.setEnabled(false);
    }

    public void setAccionGenerarConstancia(ActionListener listener) {
        btnGenerarConstancia.addActionListener(listener);
    }
}