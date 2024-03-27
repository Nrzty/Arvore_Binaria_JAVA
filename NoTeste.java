import java.util.Scanner;

public class NoTeste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        No raiz = null;

        int opcao;
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Inserir valor na árvore");
            System.out.println("2. Pesquisar valor na árvore");
            System.out.println("3. Remover valor da árvore");
            System.out.println("4. Imprimir árvore em ordem");
            System.out.println("5. Imprimir árvore em pré-ordem");
            System.out.println("6. Imprimir árvore em pós-ordem");
            System.out.println("7. Imprimir altura da árvore");
            System.out.println("8. Imprimir altura de um nó específico");
            System.out.println("9. Imprimir nível da árvore");
            System.out.println("10. Imprimir nível de um nó específico");
            System.out.println("11. Imprimir profundidade da árvore");
            System.out.println("12. Imprimir profundidade de cada nó");
            System.out.println("13. Imprimir árvore com identação");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    raiz = No.inserir(raiz, valorInserir);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser pesquisado: ");
                    int valorPesquisar = scanner.nextInt();
                    No.pesquisar(raiz, valorPesquisar);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    raiz = No.remover(raiz, valorRemover);
                    break;
                case 4:
                    System.out.println("Árvore em ordem:");
                    No.imprimirArvore(raiz);
                    break;
                case 5:
                    System.out.println("Árvore em pré-ordem:");
                    No.preOrdem(raiz);
                    break;
                case 6:
                    System.out.println("Árvore em pós-ordem:");
                    No.posOrdem(raiz);
                    break;
                case 7:
                    System.out.println("Altura da árvore: " + No.altura(raiz));
                    break;
                case 8:
                    System.out.print("Digite o valor do nó para calcular a altura: ");
                    int valorNo = scanner.nextInt();
                    System.out.println("Altura do nó " + valorNo + ": " + No.alturaDoNo(raiz, valorNo));
                    break;
                case 9:
                    System.out.println("Nível da árvore: " + No.nivelDaArvore(raiz));
                    break;
                case 10:
                    System.out.print("Digite o valor do nó para calcular o nível: ");
                    int valorNoNivel = scanner.nextInt();
                    System.out.println("Nível do nó " + valorNoNivel + ": " + No.nivelNo(raiz, valorNoNivel, 0));
                    break;
                case 11:
                    System.out.println("Profundidade da árvore: " + No.profundidadeDaArvore(raiz));
                    break;
                case 12:
                    System.out.println("Profundidade de cada nó:");
                    No.profundidadeDeCadaNo(raiz, 0);
                    break;
                case 13:
                    System.out.println("Árvore com identação:");
                    No.imprimirArvoreIdentada(raiz, 0);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
