package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.entities;
//Quandale dingle here
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Almacenes")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long almacen_id;

    @NotNull(message = "No puede no tener nombre")
    @Size(min = 3, max = 50, message = "El nombre solo puede tener entre 3 y 50 caracteres")
    private String nombre;

    @NotNull(message = "Debe indicar la capacidad máxima del almacén.")
    private Integer capacidad_max;

    @Size(min = 3, max = 50, message = "El nombre solo puede tener entre 3 y 50 caracteres")
    private String localizacion;

    @Size(min = 9, max = 9, message = "Número de teléfono inválido")
    private String telefono;

    public Long getAlmacen_id() {
        return almacen_id;
    }
    public void setAlmacen_id(Long almacen_id) {
        this.almacen_id = almacen_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCapacidad_max() {
        return capacidad_max;
    }
    public void setCapacidad_max(Integer capacidad_max) {
        this.capacidad_max = capacidad_max;
    }
    public String getLocalizacion() {
        return localizacion;
    }
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
