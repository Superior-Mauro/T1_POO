import java.time.LocalDate;

public class Venta {
    private String idVenta;
    private LocalDate fecha;
    private int cantidad;
    private Cliente cliente;
    private Libro libro;

    public Venta() {
    }

    public Venta(String idVenta, LocalDate fecha, int cantidad, Cliente cliente, Libro libro) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.libro = libro;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public double calcularTotal() {
        if (this.libro != null) {
            return this.cantidad * this.libro.getPrecio();
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "ID Venta: " + idVenta + " | Fecha: " + fecha + " | Cantidad: " + cantidad + 
               " | Cliente: " + (cliente != null ? cliente.getNombre() : "N/A") + 
               " | Libro: " + (libro != null ? libro.getTitulo() : "N/A") + 
               " | Total: S/ " + calcularTotal();
    }
}