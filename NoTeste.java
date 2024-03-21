public class NoTeste {
    public static void main(String[] args) {
        No raiz = null;

        // INSERE VALORES À ÁRVORE BINÁRIA
        raiz = No.inserir(raiz, 10);
        raiz = No.inserir(raiz, 5);
        raiz = No.inserir(raiz, 15);
        raiz = No.inserir(raiz, 3);
        raiz = No.inserir(raiz, 7);
        raiz = No.inserir(raiz, 12);
        raiz = No.inserir(raiz, 20);

        // IMPRIME A ÁRVORE BINÁRIA
        System.out.print("Árvore Binária: " );
        No.imprimirArvore(raiz);
        System.out.println();
        
        // RETORNA A RAIZ DA ÁRVORE BINÁRIA 
        System.out.println("Raiz: " + raiz.valor);
        
        // RETORNA OS VALORES À DIREITA DA ÁRVORE BINÁRIA
        System.out.print("Valores Da Direita: " );
        No.imprimirArvore(raiz.noDireita);
        
        // RETORNA OS VALORES À ESQUERDA DA ÁRVORE BINÁRIA
        System.out.print("\n" + "Valores Da Esquerda: ");
        No.imprimirArvore(raiz.noEsquerda);
        System.out.println();
        No.pesquisar(raiz, 15);

        // REMOVE UM VALOR DA ÁRVORE BINÁRIA
        No.remover(raiz, 20);
        System.out.print("Árvore Binária Com O Valor Removido: ");
        No.imprimirArvore(raiz);

        // IMPRIME A ÁRVORE EM PRÉ-ORDEM 
        System.out.println("\n" + "Árvore Em Pré-Ordem: ");
        No.preFixado(raiz);
        
        // IMPRIME A ÁRVORE EM PÓS-ORDEM
        System.out.println("\n" + "Árvore Em Pós-Ordem: ");
        No.posFixado(raiz);
        
        // IMPRIME A ÁRVORE EM ORDEM
        System.out.println("\n" + "Árvore Em Ordem: ");
        No.emOrdem(raiz);
    }
}
