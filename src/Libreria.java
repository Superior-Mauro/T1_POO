
import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private String nombre;
    private List<Libro> catalogo;
    private List<Cliente> clientes;
    private List<Venta> ventas;
    private List<Reserva> reservas;

    public Libreria() {
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Libreria(String nombre) {
        this.nombre = nombre;
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void registrarLibro(Libro libro) {
        if (libro != null) {
            this.catalogo.add(libro);
        }
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente != null) {
            this.clientes.add(cliente);
        }
    }

    public boolean registrarVenta(Venta venta) {
        if (venta != null && venta.getLibro() != null) {
            boolean stockOk = venta.getLibro().reducirStock(venta.getCantidad());
            if (stockOk) {
                this.ventas.add(venta);
                return true;
            }
        }
        return false;
    }

    public boolean registrarReserva(Reserva reserva) {
        if (reserva != null) {
            this.reservas.add(reserva);
            return true;
        }
        return false;
    }

    public double calcularIngresosPorLibro(String isbn) {
        double totalIngresos = 0.0;
        for (Venta v : ventas) {
            if (v.getLibro() != null && v.getLibro().getIsbn().equals(isbn)) {
                totalIngresos += v.calcularTotal();
            }
        }
        return totalIngresos;
    }

    public int contarVentasPorLibro(String isbn) {
        int totalVendido = 0;
        for (Venta v : ventas) {
            if (v.getLibro() != null && v.getLibro().getIsbn().equals(isbn)) {
                totalVendido += v.getCantidad();
            }
        }
        return totalVendido;
    }

    // Métodos para mostrar los datos registrados
    public void mostrarLibros() {
        System.out.println("\n--- CATÁLOGO DE LIBROS ---");
        if (catalogo.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro l : catalogo) {
                System.out.println(l);
            }
        }
    }

    public void mostrarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    public void mostrarVentas() {
        System.out.println("\n--- HISTORIAL DE VENTAS ---");
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas realizadas.");
        } else {
            for (Venta v : ventas) {
                System.out.println(v);
            }
        }
    }

    public void mostrarReservas() {
        System.out.println("\n--- HISTORIAL DE RESERVAS ---");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    public void mostrarTodo() {
        mostrarLibros();
        mostrarClientes();
        mostrarVentas();
        mostrarReservas();
    }
}