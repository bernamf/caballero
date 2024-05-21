package modelo.bean;



public class Caballero {
    private int id;
    private String nombre;
    private int fuerza;
    private int experiencia;
    private String foto;

    // Constructor
    public Caballero(int id, String nombre, int fuerza, int experiencia, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.experiencia = experiencia;
        this.foto = foto;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}