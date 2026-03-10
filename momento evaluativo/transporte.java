class transporte {

    protected String id;
    protected String Origen;
    protected double peso;

    public transporte(String id, String Origen, double peso) {
        this.id = id;
        this.Origen = Origen;
        this.peso = peso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}

