# 📚 PageTurner - Sistema de Gestión de Librería Académica

Sistema de escritorio y consola desarrollado en **Java** para automatizar el control de inventario, registro de clientes, ventas y reservas de la librería universitaria **PageTurner** (Lima, Perú).

---

## 📌 Contexto del Negocio

La librería **PageTurner**, administrada por la Sra. Carmen Vidal, operaba mediante registros manuales en cuadernos y hojas de cálculo. Este flujo generaba pérdida de reservas, falta de trazabilidad de stock e imposibilidad de calcular métricas de ingresos o títulos más demandados. 

El presente software digitaliza las operaciones clave, asegurando consistencia en el stock y centralizando los datos comerciales.

---

## 🚀 Funcionalidades Principales

* **Gestión de Catálogo e Inventario:** Registro de libros con ISBN, título, autor, precio unitario y cantidad en stock.
* **Control de Clientes:** Padrón de clientes con nombre completo, DNI y correo electrónico.
* **Módulo de Ventas:** 
  * Registro de transacciones asociando cliente, libro, fecha y cantidad.
  * Validación y descuento automático de stock en tiempo real.
* **Sistema de Reservas:**
  * Habilitado exclusivamente para libros sin existencias disponibles (stock = 0).
  * Trazabilidad de fecha de reserva, cliente solicitante y título reservado.
* **Reportes y Analítica:**
  * Métricas de ventas totales y volumen monetario generado por libro.
  * Identificación de los títulos con mayor demanda y reservas activas.

### Reglas de Negocio Implementadas
* Una **Venta** vincula exactamente a 1 Cliente con 1 Libro en una fecha determinada, actualizando el stock disponible.
* Una **Reserva** vincula a 1 Cliente con 1 Libro sin stock para contacto posterior. Un cliente puede mantener múltiples reservas.
* El **Operador/Asistente** interactúa con el sistema mediante la interfaz; no constituye una entidad persistente en el modelo de datos.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 17 o superior)
* **Arquitectura:** Programación Orientada a Objetos (POO) estructurada en capas (Modelo, Repositorio/DAO, Servicio, Controlador/Vista).
* **Persistencia:** JDBC con SQL Server / MySQL (o colecciones en memoria `java.util.*` según entorno de despliegue).
* **Gestor de Dependencias:** Maven / Gradle.

---
## 🚀 Funcionalidades Principales

* **Inventario de Libros:** Registro de obras con ISBN, título, autor, precio y cantidad disponible.
* **Padrón de Clientes:** Identificación de usuarios mediante nombre, DNI y correo electrónico.
* **Procesamiento de Ventas:** Registro de transacciones con fecha y cantidad, descontando existencias automáticamente.
* **Control de Reservas:** Registro de lista de espera (cliente, libro y fecha) exclusivamente para libros agotados.
* **Reportes de Negocio:** Cálculo de ingresos monetarios acumulados y total de ventas por libro.

---

## 📂 Estructura del Código

El proyecto está organizado en una estructura directa con los siguientes archivos fuente[cite: 1]:

* `App.java`: Clase principal que inicializa el sistema e interactúa con el usuario (asistente de la librería)[cite: 1].
* `Cliente.java`: Modela al cliente (DNI, nombre, correo).
* `Libro.java`: Modela el inventario.
* `Venta.java`: Registra la transacción de compra.
* `Reserva.java`: Gestiona la lista de espera de ejemplares sin stock.
* `Libreria.java`: Administra las colecciones, lógica de negocio y reportes generales.

```text
├── App.java
├── Cliente.java
├── Libreria.java
├── Libro.java
├── Reserva.java
└── Venta.java
