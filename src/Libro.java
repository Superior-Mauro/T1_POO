public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private double precio;
    private int stock;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, double precio, int stock) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean reducirStock(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    public void aumentarStock(int cantidad) {
        this.stock += cantidad;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Título: " + titulo + " | Autor: " + autor + " | Precio: S/ " + precio + " | Stock: " + stock;
    }
}