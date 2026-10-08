package model;

import java.util.*;

/**
 *
 */
public class Tienda {

    private final String nombre;
    private final String nit;// documentar
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String, Producto> listaProductos = new HashMap<>();


    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    // setters y getters

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //-------------------CRUD CLIENTE---------------------------------------------------------------------------


    /**
     * Este metodo permite registrar un cliente
     *
     * @param cliente
     * @return
     */
    public String registrarCliente(Cliente cliente) {
        Cliente clienteEncontrado = buscarCliente1(cliente.getDocumentoIdentidad());
        if (clienteEncontrado == null) {
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    public String registrarCliente2(Cliente cliente) {
        Optional<Cliente> clienteEncontrado = buscarCliente2(cliente.getDocumentoIdentidad());
        if (clienteEncontrado.isEmpty()) {
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }


    public Cliente buscarCliente1(String documentoIdentidad) {
        for (Cliente cliente : listaClientes) {//foreach
            if (documentoIdentidad.equals(cliente.getDocumentoIdentidad())) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Esta forma de hacer una busqueda se llama imperativo- significa que usted ve el còmo? hace las cosas
     *
     * @param documentoIdentidad
     * @return
     */
    public Optional<Cliente> buscarCliente2(String documentoIdentidad) {
        for (Cliente cliente : listaClientes) {
            if (documentoIdentidad.equals(cliente.getDocumentoIdentidad())) {
                return Optional.of(cliente);//guardo en la caja
            }
        }
        return Optional.empty();
    }

    // imperativa y declarativa(estudiarlo)


    /**
     * mama.hacerArrozConPollo();
     * Declarativo: significa que usted declara lo que quiere hacer, osea el Què?
     *
     * @param documentoIdentidad
     * @return
     */
    public Optional<Cliente> buscarCliente3(String documentoIdentidad) {
        return listaClientes.stream().filter(cliente ->
                documentoIdentidad.equals(cliente.getDocumentoIdentidad())).findFirst();
    }


    // Cambiar if(clienteEncontrado == null){ por un Optional
    // hacer el metodo buscar cliente usando un optional

    public Factura buscarFactura(String codigo) {

        for (Factura factura : listaFacturas) {
            if (factura.codigo().equals(codigo)) {
                return factura;
            }
        }
        return null;
    }

    public Optional<Factura> obtenerFactura(String codigo) {
        return listaFacturas.stream().filter(f -> f.codigo().equals(codigo)).findFirst();
    }
}

