import java.util.Scanner;

public class NoTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        No raiz = null;
        int opcao;
        
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir valor na árvore");
            System.out.println("2. Pesquisar valor na árvore");
            System.out.println("3. Remover valor da árvore");
            System.out.println("4. Imprimir árvore em ordem");
            System.out.println("5. Imprimir árvore com indentação");
            System.out.println("6. Calcular altura da árvore");
            System.out.println("7. Calcular altura de um nó");
            System.out.println("8. Calcular profundidade de um nó");
            System.out.println("9. Calcular profundidade da árvore");
            System.out.println("10. Imprimir árvore em pré-ordem");
            System.out.println("11. Imprimir árvore em pós-ordem");
            System.out.println("12. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            
            switch(opcao) {
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
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Árvore com indentação:");
                    No.imprimirArvoreIdentada(raiz, 0);
                    System.out.println();
                    break;
                case 6:
                    int alturaArvore = No.alturaDaArvore(raiz);
                    System.out.println("Altura da árvore: " + alturaArvore);
                    break;
                case 7:
                    System.out.print("Digite o valor do nó para calcular a altura: ");
                    int valorNo = scanner.nextInt();
                    int alturaNo = No.alturaDoNo(No.buscarNo(raiz, valorNo));
                    System.out.println("Altura do nó " + valorNo + ": " + alturaNo);
                    break;
                case 8:
                    System.out.print("Digite o valor do nó para calcular a profundidade: ");
                    int valorNoProfundidade = scanner.nextInt();
                    int profundidadeNo = No.profundidadeDoNo(raiz, valorNoProfundidade, 0);
                    System.out.println("Profundidade do nó " + valorNoProfundidade + ": " + profundidadeNo);
                    break;
                case 9:
                    int profundidadeArvore = No.profundidadeDaArvore(raiz);
                    System.out.println("Profundidade da árvore: " + profundidadeArvore);
                    break;
                case 10:
                    System.out.println("Árvore em pré-ordem:");
                    No.preOrdem(raiz);
                    System.out.println();
                    break;
                case 11:
                    System.out.println("Árvore em pós-ordem:");
                    No.posOrdem(raiz);
                    System.out.println();
                    break;
                case 12:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            
        } while (opcao != 12);
        
        scanner.close();
    }
}
