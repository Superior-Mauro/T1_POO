import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Libreria libreria = new Libreria("Librería Central");
        int opcion = 0;

        do {
            System.out.println("\n========== MENÚ LIBRERÍA ==========");
            System.out.println("1. Registrar nuevo Libro");
            System.out.println("2. Registrar nuevo Cliente");
            System.out.println("3. Registrar nueva Venta");
            System.out.println("4. Registrar nueva Reserva");
            System.out.println("5. Mostrar TODO lo registrado");
            System.out.println("6. Ver reporte e ingresos por ISBN");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRO DE LIBRO ---");
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());
                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(scanner.nextLine());

                    libreria.registrarLibro(new Libro(isbn, titulo, autor, precio, stock));
                    System.out.println("¡Libro registrado exitosamente!");
                    break;

                case 2:
                    System.out.println("\n--- REGISTRO DE CLIENTE ---");
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Correo electrónico: ");
                    String correo = scanner.nextLine();

                    libreria.registrarCliente(new Cliente(dni, nombre, correo));
                    System.out.println("¡Cliente registrado exitosamente!");
                    break;

                case 3:
                    System.out.println("\n--- REGISTRO DE VENTA ---");
                    if (libreria.getCatalogo().isEmpty() || libreria.getClientes().isEmpty()) {
                        System.out.println("Error: Debe registrar al menos un libro y un cliente primero.");
                        break;
                    }

                    System.out.print("ID Venta (ej. V001): ");
                    String idVenta = scanner.nextLine();

                    System.out.print("Ingrese DNI del cliente: ");
                    String dniBusqueda = scanner.nextLine();
                    Cliente clienteEncontrado = null;
                    for (Cliente c : libreria.getClientes()) {
                        if (c.getDni().equals(dniBusqueda)) {
                            clienteEncontrado = c;
                            break;
                        }
                    }
                    System.out.print("Ingrese ISBN del libro a comprar: ");
                    String isbnBusqueda = scanner.nextLine();
                    Libro libroEncontrado = null;
                    for (Libro l : libreria.getCatalogo()) {
                        if (l.getIsbn().equals(isbnBusqueda)) {
                            libroEncontrado = l;
                            break;
                        }
                    }
                    if (clienteEncontrado != null && libroEncontrado != null) {
                        System.out.print("Cantidad a comprar: ");
                        int cantidad = Integer.parseInt(scanner.nextLine());

                        Venta nuevaVenta = new Venta(idVenta, LocalDate.now(), cantidad, clienteEncontrado, libroEncontrado);
                        boolean ventaExitosa = libreria.registrarVenta(nuevaVenta);

                        if (ventaExitosa) {
                            System.out.println("¡Venta realizada con éxito!");
                            System.out.println("Total a pagar: S/ " + nuevaVenta.calcularTotal());
                        } else {
                            System.out.println("Error: Stock insuficiente (" + libroEncontrado.getStock() + " disponibles).");
                        }
                    } else {
                        System.out.println("Error: Cliente o Libro no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- REGISTRO DE RESERVA ---");
                    if (libreria.getCatalogo().isEmpty() || libreria.getClientes().isEmpty()) 
                    {
                    System.out.println("Error: Debe registrar al menos un libro y un cliente primero.");
                    break;
                    }

                    System.out.print("ID Reserva (ej. R001): ");
                    String idReserva = scanner.nextLine();

                    // --- NUEVO: Solicitar la fecha al usuario ---
                    System.out.print("Ingrese la fecha de reserva (AAAA-MM-DD, ej. 2026-09-18): ");
                    String fechaStr = scanner.nextLine();
                    LocalDate fechaReserva;
                    try {
                        fechaReserva = LocalDate.parse(fechaStr); // Convierte el texto digitado a LocalDate
                    } catch (Exception e) {
                    System.out.println("Formato de fecha inválido. Se asignará la fecha actual por defecto.");
                    fechaReserva = LocalDate.now();
                    }
                    System.out.print("Ingrese DNI del cliente: ");
                    String dniRes = scanner.nextLine();
                    Cliente clienteRes = null;
                    for (Cliente c : libreria.getClientes()) {
                        if (c.getDni().equals(dniRes)) {
                            clienteRes = c;
                            break;
                        }
                    }
                    System.out.print("Ingrese ISBN del libro a reservar: ");
                    String isbnRes = scanner.nextLine();
                    Libro libroRes = null;
                    for (Libro l : libreria.getCatalogo()) {
                    if (l.getIsbn().equals(isbnRes)) {
                    libroRes = l;
                    break;
                        }
                    }

                    if (clienteRes != null && libroRes != null) {
                        // Se envía la variable fechaReserva capturada por el usuario
                        libreria.registrarReserva(new Reserva(idReserva, fechaReserva, clienteRes, libroRes));
                        System.out.println("¡Reserva realizada con éxito para la fecha " + fechaReserva + "!");
                    } else {
                        System.out.println("Error: Cliente o Libro no encontrado.");
                    }
                    break;         
                case 5:
                    libreria.mostrarTodo();
                    break;

                case 6:
                    System.out.println("\n--- REPORTE DE VENTAS POR LIBRO ---");
                    System.out.print("Ingrese ISBN a consultar: ");
                    String isbnConsulta = scanner.nextLine();
                    System.out.println("Unidades vendidas: " + libreria.contarVentasPorLibro(isbnConsulta));
                    System.out.println("Ingresos generados: S/ " + libreria.calcularIngresosPorLibro(isbnConsulta));
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Ingrese un número entre 1 y 7.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}