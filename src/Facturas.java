public class Facturas {
    public String cliente;
    public String emision;
    public String mes;
    private double consumo;
    private double DeudaTotal;

    public Facturas(String cliente, String emision, String mes, double consumo, double DeudaTotal) {
        this.cliente = cliente;
        this.emision = emision;
        this.mes = mes;
        this.consumo = consumo;
        this.DeudaTotal = DeudaTotal;
    }

    // Getters y Setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getDeudaTotal() {
        return DeudaTotal;
    }

    public void setDeudaTotal(double DeudaTotal) {
        this.DeudaTotal = DeudaTotal;
    }
}
