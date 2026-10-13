public class IngressoVIP extends Ingresso {
    private boolean acessoBackstage;
    private int numeroLounge;

    public IngressoVIP(int codigo, String nomeEvento, String setor, double valorBase,
                       boolean acessoBackstage, int numeroLounge) {
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage = acessoBackstage;
        this.numeroLounge = numeroLounge;
    }

    public boolean isAcessoBackstage() { return acessoBackstage; }
    public void setAcessoBackstage(boolean acessoBackstage) { this.acessoBackstage = acessoBackstage; }

    public int getNumeroLounge() { return numeroLounge; }
    public void setNumeroLounge(int numeroLounge) { this.numeroLounge = numeroLounge; }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.8; // acréscimo de 80%
    }

    @Override
    public String obterBeneficios() {
        String b = "Acesso ao lounge nº " + numeroLounge + " e entrada prioritária";
        if (acessoBackstage) {
            b += "; acesso ao backstage";
        }
        return b + ".";
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Ingresso VIP");
        super.exibirInformacoes();
        System.out.println("Lounge: " + numeroLounge);
        System.out.println("Acesso ao backstage: " + (acessoBackstage ? "Sim" : "Não"));
        System.out.printf("Valor final: R$ %.2f%n", calcularValorFinal());
    }
}
