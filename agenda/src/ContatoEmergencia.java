public class ContatoEmergencia extends Contato {
    private int grauPrioridade; // 1 a 5
    private String observacao;

    public ContatoEmergencia(String nome, String email, String telefone,
                             int grauPrioridade, String observacao) {
        super(nome, email, telefone);
        setGrauPrioridade(grauPrioridade);
        this.observacao = observacao;
    }

    public int getGrauPrioridade() { return grauPrioridade; }

    public void setGrauPrioridade(int grauPrioridade) {
        if (grauPrioridade < 1 || grauPrioridade > 5) {
            throw new IllegalArgumentException("Grau de prioridade deve estar entre 1 e 5.");
        }
        this.grauPrioridade = grauPrioridade;
    }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    @Override
    public void exibir() {
        System.out.println("Tipo: Emergência");
        super.exibir();
        System.out.println("Grau de prioridade: " + grauPrioridade);
        System.out.println("Observação: " + observacao);
    }
}
