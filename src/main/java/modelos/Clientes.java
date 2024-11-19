package modelos;

public class Clientes {
    //Declaramos las variables de mi product0
    private Long idClientes;
    private String nombre;
    private String apellido;
    private String genero;
    private int telefono;
    //Implementamos nuestros constructor

    public Clientes() {
    }
    public Clientes(Long idClientes, String nombre,String apellido, int telefono, String genero) {
        this.idClientes=idClientes;
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.genero=genero;
    }
    //Implementamos los métodos get y set

    public Long getIdClientes() {return idClientes;}

    public void setIdClientes(Long idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

}