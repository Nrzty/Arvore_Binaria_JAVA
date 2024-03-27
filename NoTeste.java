import java.util.Scanner;

public class NoTeste {
    public static void main(String[] args) {
        No raiz = null;
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Inserir valor na árvore");
            System.out.println("2. Pesquisar valor na árvore");
            System.out.println("3. Remover valor da árvore");
            System.out.println("4. Imprimir árvore em ordem");
            System.out.println("5. Imprimir árvore com identação");
            System.out.println("6. Calcular altura da árvore");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
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
                    No.emOrdem(raiz);
                    break;
                case 5:
                    System.out.println("Árvore com identação:");
                    No.imprimirArvoreIdentada(raiz, 0);
                    break;
                case 6:
                    int altura = No.altura(raiz);
                    System.out.println("Altura da árvore: " + altura);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
