import java.util.ArrayList;
import java.util.List;

public class Bilheteria {
    private List<Ingresso> ingressos;

    public Bilheteria() {
        this.ingressos = new ArrayList<>();
    }

    public List<Ingresso> getIngressos() { return ingressos; }
    public void setIngressos(List<Ingresso> ingressos) { this.ingressos = ingressos; }

    /** Adiciona o ingresso. Retorna false se já existir um ingresso com o mesmo código. */
    public boolean adicionarIngresso(Ingresso ingresso) {
        if (buscarIngresso(ingresso.getCodigo()) != null) {
            return false;
        }
        ingressos.add(ingresso);
        return true;
    }

    public boolean removerIngresso(int codigo) {
        Ingresso i = buscarIngresso(codigo);
        if (i == null) {
            return false;
        }
        ingressos.remove(i);
        return true;
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso i : ingressos) {
            if (i.getCodigo() == codigo) {
                return i;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos) {
            System.out.println("------------------------------");
            i.exibirInformacoes(); // polimorfismo
        }
        System.out.println("------------------------------");
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso i : ingressos) {
            total += i.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos) {
            System.out.println("Ingresso " + i.getCodigo() + " (" + i.getNomeEvento() + "): "
                    + i.obterBeneficios());
        }
    }
}
