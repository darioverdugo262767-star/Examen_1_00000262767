package ensamblador;

import controlador.ConstanciaControlador;
import modelo.FachadaModeloConstancia;
import vista.FrmGenerarConstancia;

/**
 *
 * @author Dario
 */
public class Ensamblador {

    public void ensamblar() {
        FachadaModeloConstancia modelo = new FachadaModeloConstancia();
        ConstanciaControlador controlador = new ConstanciaControlador();
        FrmGenerarConstancia vista = new FrmGenerarConstancia();

        controlador.setModelo(modelo);
        vista.setControlador(controlador);
        vista.setModelo(modelo);

        modelo.agregarObservador(vista);

        vista.setVisible(true);
    }
}