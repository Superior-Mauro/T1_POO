import java.time.LocalDate;

public class Reserva {
    private String idReserva;
    private LocalDate fecha;
    private Cliente cliente;
    private Libro libro;

    public Reserva() {
    }

    public Reserva(String idReserva, LocalDate fecha, Cliente cliente, Libro libro) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.cliente = cliente;
        this.libro = libro;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "ID Reserva: " + idReserva + " | Fecha: " + fecha + 
               " | Cliente: " + (cliente != null ? cliente.getNombre() : "N/A") + 
               " | Libro: " + (libro != null ? libro.getTitulo() : "N/A");
    }
}