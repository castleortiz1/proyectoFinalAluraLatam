import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito {
    private double limite;
    private double saldo;
    private List<Compras> listaDeCompras;

    public TarjetaDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean realizarCompra(Compras compras) {
        if (this.saldo >= compras.getValor()) {
            this.saldo -= compras.getValor();
            this.listaDeCompras.add(compras);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compras> getListaDeCompras() {
        return listaDeCompras;
    }
}