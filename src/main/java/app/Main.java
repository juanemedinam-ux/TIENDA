package app;



import model.Cliente;
import model.Tienda;

import javax.swing.*;

public class Main {


    static void main() {

        Tienda tienda = new Tienda("Tienda UQ","34567","7430000");

        Cliente c1 = new Cliente("1094","Juan perez",tienda,
                "31253664","juan@gamiel.com","Armenia");

        String mensajeResultado = tienda.registrarCliente(c1);

        JOptionPane.showMessageDialog(null,mensajeResultado);

        Cliente resultado = tienda.buscarCliente1("109345");

        if(resultado != null){
            JOptionPane.showMessageDialog(null,"El cliente existe en la tienda");
        }else{
            JOptionPane.showMessageDialog(null,"El cliente no existe en la tienda");
        }


    }
}