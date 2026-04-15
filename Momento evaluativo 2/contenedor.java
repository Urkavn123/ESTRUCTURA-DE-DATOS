
public class contenedor {
    protected String id;
    protected double peso;
    protected int prioridad;

    public contenedor(String id, double peso, int prioridad) {
        this.id = id;
        this.peso = peso;
        this.prioridad = prioridad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {  
        return "Contenedor{" +
                "id='" + id + '\'' +
                ", peso=" + peso +
                ", prioridad=" + prioridad +
                '}';
    }
}
