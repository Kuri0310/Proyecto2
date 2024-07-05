public class Electrodomesticos {
    private String name;
    private String marca;
    private String model;
    private double consumo;
    private double DeudaC;

    public Electrodomesticos(String name, String model, String marca, double consumo, double DeudaC) {
        this.name = name;
        this.model = model;
        this.marca = marca;
        this.consumo = consumo;
        this.DeudaC = DeudaC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getDeudaC() {
        return DeudaC;
    }

    public void setDeudaC(double DeudaC) {
        this.DeudaC = DeudaC;
    }
}
