
public class ConsumoDeLuz {

    public int kWh;
    public double costo;
    public double consumoDiario;
    public double consumoSemanal;
    public double consumoMensual; 

    public ConsumoDeLuz(double consumoDiario, double consumoSemanal, double consumoMensual, int kWh, double costo) {
        this.kWh= kWh;
        this.costo = costo;
        this.consumoDiario = consumoDiario;
        this.consumoSemanal = consumoSemanal;
        this.consumoMensual = consumoMensual;
    }
}