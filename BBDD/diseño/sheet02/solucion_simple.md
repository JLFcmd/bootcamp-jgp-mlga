# Paso al modelo relacional y DDL (sheet02)

## ex01 – producto

### “Patas de gallo”
- Un producto es una entidad sola.

### Modelo relacional
- **PRODUCTO**(id, stock)

```sql
CREATE TABLE producto (
  id INT PRIMARY KEY,
  stock INT
);
```

---

## ex02 – persona y telefono

### “Patas de gallo”
- Una persona puede tener varios teléfonos.  
- Cada teléfono pertenece a una persona.

### Modelo relacional
- **PERSONA**(id_persona, correo)  
- **TELEFONO**(id_telefono, numero, tipo, id_persona)

```sql
CREATE TABLE persona (
  id_persona SERIAL PRIMARY KEY,
  correo VARCHAR(255)
);

CREATE TABLE telefono (
  id_telefono SERIAL PRIMARY KEY,
  numero VARCHAR(30),
  tipo VARCHAR(30),
  id_persona INT REFERENCES persona(id_persona)
);
```

---

## ex03 – biblioteca

### “Patas de gallo”
- Un usuario puede tener varios préstamos.  
- Un libro puede estar prestado a varios usuarios (uno cada vez).

### Modelo relacional
- **USUARIO**(id_usuario, nombre)  
- **LIBRO**(id_libro, nombre)  
- **PRESTAMO**(id_prestamo, fecha, devolucion, id_usuario, id_libro)

```sql
CREATE TABLE usuario (
  id_usuario SERIAL PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE libro (
  id_libro SERIAL PRIMARY KEY,
  nombre VARCHAR(150)
);

CREATE TABLE prestamo (
  id_prestamo SERIAL PRIMARY KEY,
  fecha DATE,
  devolucion DATE,
  id_usuario INT REFERENCES usuario(id_usuario),
  id_libro INT REFERENCES libro(id_libro)
);
```

---

## ex04 – tienda online

### “Patas de gallo”
- Un cliente puede hacer varios pedidos.  
- Un pedido tiene varios productos.

### Modelo relacional
- **CLIENTE**(id_cliente)  
- **PEDIDO**(id_pedido, fecha, id_cliente)  
- **PRODUCTO**(id_producto, nombre)  
- **PEDIDO_PRODUCTO**(id_pedido, id_producto)

```sql
CREATE TABLE cliente (
  id_cliente SERIAL PRIMARY KEY
);

CREATE TABLE pedido (
  id_pedido SERIAL PRIMARY KEY,
  fecha DATE,
  id_cliente INT REFERENCES cliente(id_cliente)
);

CREATE TABLE producto (
  id_producto SERIAL PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE pedido_producto (
  id_pedido INT REFERENCES pedido(id_pedido),
  id_producto INT REFERENCES producto(id_producto),
  PRIMARY KEY (id_pedido, id_producto)
);
```

---

## ex06 – liga

### “Patas de gallo”
- Un jugador juega en un equipo en una temporada.

### Modelo relacional
- **JUGADOR**(id_jugador, nombre)  
- **EQUIPO**(id_equipo, nombre)  
- **TEMPORADA**(inicio, fin)  
- **PARTICIPACION**(id_jugador, id_equipo, inicio, fin)

```sql
CREATE TABLE jugador (
  id_jugador SERIAL PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE equipo (
  id_equipo SERIAL PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE temporada (
  inicio DATE,
  fin DATE,
  PRIMARY KEY (inicio, fin)
);

CREATE TABLE participacion (
  id_jugador INT REFERENCES jugador(id_jugador),
  id_equipo INT REFERENCES equipo(id_equipo),
  inicio DATE,
  fin DATE,
  PRIMARY KEY (id_jugador, id_equipo, inicio, fin)
);
```

---

## ex12 – empresa

### “Patas de gallo”
- Un empleado puede tener un jefe.  
- Un empleado puede trabajar en varios proyectos.

### Modelo relacional
- **EMPLEADO**(id_empleado, nombre, id_jefe)  
- **PROYECTO**(id_proyecto, nombre)  
- **ASIGNACION**(id_empleado, id_proyecto)

```sql
CREATE TABLE empleado (
  id_empleado SERIAL PRIMARY KEY,
  nombre VARCHAR(100),
  id_jefe INT REFERENCES empleado(id_empleado)
);

CREATE TABLE proyecto (
  id_proyecto SERIAL PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE asignacion (
  id_empleado INT REFERENCES empleado(id_empleado),
  id_proyecto INT REFERENCES proyecto(id_proyecto),
  PRIMARY KEY (id_empleado, id_proyecto)
);
```

---

## ex14 – viajes

### “Patas de gallo”
- Un viaje tiene varias ciudades como paradas.

### Modelo relacional
- **VIAJE**(id_viaje, nombre)  
- **CIUDAD**(id_ciudad, nombre)  
- **PARADA**(id_viaje, id_ciudad, fecha)

```sql
CREATE TABLE viaje (
  id_viaje SERIAL PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE ciudad (
  id_ciudad SERIAL PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE parada (
  id_viaje INT REFERENCES viaje(id_viaje),
  id_ciudad INT REFERENCES ciudad(id_ciudad),
  fecha DATE,
  PRIMARY KEY (id_viaje, id_ciudad)
);
```
