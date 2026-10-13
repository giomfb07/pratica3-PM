import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Bilheteria bilheteria = new Bilheteria();
        int opcao;

        do {
            System.out.println("\n===== BILHETERIA =====");
            System.out.println("1 - Cadastrar ingresso");
            System.out.println("2 - Remover ingresso");
            System.out.println("3 - Buscar ingresso por código");
            System.out.println("4 - Listar todos os ingressos");
            System.out.println("5 - Calcular arrecadação total");
            System.out.println("6 - Listar benefícios dos ingressos");
            System.out.println("7 - Finalizar");
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1: cadastrar(bilheteria); break;
                case 2:
                    if (bilheteria.removerIngresso(lerInt("Código do ingresso: "))) {
                        System.out.println("Ingresso removido com sucesso!");
                    } else {
                        System.out.println("Código não encontrado.");
                    }
                    break;
                case 3:
                    Ingresso i = bilheteria.buscarIngresso(lerInt("Código do ingresso: "));
                    if (i == null) {
                        System.out.println("Código não encontrado.");
                    } else {
                        System.out.println();
                        i.exibirInformacoes();
                        System.out.println("Benefícios: " + i.obterBeneficios());
                    }
                    break;
                case 4: bilheteria.listarIngressos(); break;
                case 5:
                    System.out.printf("Arrecadação total: R$ %.2f%n", bilheteria.calcularArrecadacaoTotal());
                    break;
                case 6: bilheteria.listarBeneficios(); break;
                case 7: System.out.println("Encerrando o programa..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    private static void cadastrar(Bilheteria bilheteria) {
        System.out.println("Tipo: 1 - Comum | 2 - Estudante | 3 - VIP");
        int tipo = lerInt("Tipo: ");
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo inválido!");
            return;
        }

        int codigo = lerInt("Código: ");
        if (bilheteria.buscarIngresso(codigo) != null) {
            System.out.println("Já existe um ingresso com esse código.");
            return;
        }
        String evento = lerTexto("Nome do evento: ");
        String setor = lerTexto("Setor: ");
        double valor = lerDouble("Valor base: ");

        Ingresso ingresso;
        switch (tipo) {
            case 1:
                ingresso = new IngressoComum(codigo, evento, setor, valor);
                break;
            case 2:
                String inst = lerTexto("Instituição de ensino: ");
                ingresso = new IngressoEstudante(codigo, evento, setor, valor, inst);
                break;
            default:
                String r = lerTexto("Acesso ao backstage? (s/n): ");
                boolean backstage = r.equalsIgnoreCase("s");
                int lounge = lerInt("Número do lounge: ");
                ingresso = new IngressoVIP(codigo, evento, setor, valor, backstage, lounge);
        }
        bilheteria.adicionarIngresso(ingresso);
        System.out.println("Ingresso cadastrado com sucesso!");
    }

    private static String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    private static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
