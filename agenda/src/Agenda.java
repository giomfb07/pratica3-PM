import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;
    private int quantidade;

    public Agenda() {
        this.contatos = new ArrayList<>();
        this.quantidade = 0;
    }

    public List<Contato> getContatos() { return contatos; }
    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
        this.quantidade = contatos.size();
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        quantidade = contatos.size();
    }

    /** Remove o primeiro contato com o nome informado. Retorna true se removeu. */
    public boolean removerContato(String nome) {
        Contato c = buscarPorNome(nome);
        if (c == null) {
            return false;
        }
        contatos.remove(c);
        quantidade = contatos.size();
        return true;
    }

    public Contato buscarPorNome(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarPorEmail(String email) {
        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarPorTelefone(String telefone) {
        for (Contato c : contatos) {
            if (c.getTelefone().equals(telefone)) {
                return c;
            }
        }
        return null;
    }
}
