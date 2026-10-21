package vista;

import controlador.ConstanciaControlador;
import modelo.Constancia;
import modelo.Estudiante;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.IConsultaModelo;
import modelo.Observador;

/**
 *
 * @author Dario
 */
public class FrmGenerarConstancia extends JFrame implements Observador{
    private IConsultaModelo modelo;
    private ConstanciaControlador controlador;

    private JTextField txtBusqueda = new JTextField();
    private DefaultListModel<Estudiante> modelLista = new DefaultListModel<>();
    private JList<Estudiante> lstCoincidencias = new JList<>(modelLista);

    private CardLayout cardLayout = new CardLayout();
    private JPanel pnlDerecho = new JPanel(cardLayout);
    private PnlInfoAlumno pnlInfo = new PnlInfoAlumno();
    private PnlConstancia pnlConstancia = new PnlConstancia();

    public FrmGenerarConstancia() {
        setTitle("Generar Constancia");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(new GridLayout(1, 2, 10, 10));

        JPanel pnlIzquierdo = new JPanel(new BorderLayout(5, 5));
        pnlIzquierdo.setBorder(BorderFactory.createTitledBorder("Busqueda por ID"));
        pnlIzquierdo.add(txtBusqueda, BorderLayout.NORTH);
        pnlIzquierdo.add(new JScrollPane(lstCoincidencias), BorderLayout.CENTER);

        pnlDerecho.add(pnlInfo, "INFO");
        pnlDerecho.add(pnlConstancia, "CONSTANCIA");

        add(pnlIzquierdo);
        add(pnlDerecho);

        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { buscar(); }
            public void removeUpdate(DocumentEvent e) { buscar(); }
            public void changedUpdate(DocumentEvent e) { buscar(); }

            private void buscar() {
                if (controlador != null) {
                    controlador.buscarEstudiantes(txtBusqueda.getText());
                }
            }
        });

        lstCoincidencias.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && lstCoincidencias.getSelectedValue() != null) {
                if (controlador != null) {
                    controlador.seleccionarEstudiante(lstCoincidencias.getSelectedValue());
                }
            }
        });

        pnlInfo.setAccionGenerarConstancia(e -> {
            if (controlador != null) {
                controlador.solicitarGenerarConstancia();
            }
        });
    }

    public void setControlador(ConstanciaControlador c) {
        this.controlador = c; 
    }
    
    public void setModelo(IConsultaModelo m) {
        this.modelo = m; 
    }

    @Override
    public void actualizar() {
        if (modelo == null) return;

        modelLista.clear();
        for (Estudiante est : modelo.getEstudiantesEncontrados()) {
            modelLista.addElement(est);
        }

        Constancia c = modelo.getConstanciaGenerada();
        if (c != null) {
            pnlConstancia.mostrarConstancia(c);
            cardLayout.show(pnlDerecho, "CONSTANCIA");
            return;
        }

        Estudiante sel = modelo.getEstudianteSeleccionado();
        if (sel != null) {
            pnlInfo.cargarDatos(sel);
            cardLayout.show(pnlDerecho, "INFO");
        } else {
            pnlInfo.limpiar();
        }
    }
}