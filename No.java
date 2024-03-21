public class No {
    // ATRIBUTOS DA CLASSE ÁRVORE.
    int valor;
    No noEsquerda;
    No noDireita;

    // CONSTRUTOR PADRÃO DA ÁRVORE BINÁRIA.
    public No(int valor) {
        this.valor = valor;
    }

    // MÉTODO PARA ADICIONAR VALORES À ÁRVORE
    public static No inserir(No raiz, int valor) {
        // SE A ÁRVORE NÃO TIVER UMA RAIZ, O VALOR SERÁ ADICIONADO COMO O MESMO.
        if (raiz == null) {
            return new No(valor);
        } else {
            // SE O VALOR INSERIDO FOR MENOR QUE O VALOR DA RAIZ, ELE SERÁ ADICIONADO À ESQUERDA.
            if (valor < raiz.valor) {
                raiz.noEsquerda = inserir(raiz.noEsquerda, valor);
            // SE O VALOR INSERIDO FOR MAIOR QUE O VALOR DA RAIZ, ELE SERÁ ADICIONADO À ESQUERDA.
            } else {
                raiz.noDireita = inserir(raiz.noDireita, valor);
            }
            return raiz;
        }
    }

    // MÉTODO PARA VERIFICAR SE UM VALOR EXISTE DENTRO DA ÁRVORE
    public static boolean pesquisar(No raiz, int valor){
        // SE O VALOR DA RAIZ FOR NULO, SIGNIFICA QUE A ÁRVORE ESTÁ VAZIA.
        if (raiz == null){
            System.out.println("A Árvore Está Vazia !");
            return false;
            // CASO CONTRÁRIO, ELE PERCORRERÁ A ÁRVORE.
        } else {
            if (valor == raiz.valor){
                System.out.println("O Valor: " + valor + " " + "Está Na Árvore!");
                return true;
                // MÉTODO RESPONSÁVEL POR PERCORRER A ÁRVORE COM RECURSIVIDADE.           
            } else if (valor < raiz.valor){
                return pesquisar(raiz.noEsquerda, valor);
            } else {
                return pesquisar(raiz.noDireita, valor);
            }
        }
    }

    // MÉTODO PARA REMOVER UM VALOR DENTRO DA ÁRVORE
    public static No remover(No raiz, int valor){
        // VERIFICAR SE HÁ ELEMENTOS NA ÁRVORE
        if (raiz == null) {
            System.out.println("Como não há elementos na Árvore, não é possível remover nada!");
            return null;
        }
        // RESPONSÁVEL POR RECORRER A ÁRVORE BINÁRIA E PROCURAR O NÓ QUE SERÁ ELIMINADO
        if (valor < raiz.valor) {
            raiz.noEsquerda = remover(raiz.noEsquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.noDireita = remover(raiz.noDireita, valor);
        } else {
            // CASO A RAIZ SEJA UMA FOLHA (ELA NÃO TEM NEM DIREITA NEM ESQUERDA)
            if (raiz.noEsquerda == null && raiz.noDireita == null) {
                return null;
            }
            // O NÓ SÓ TEM UM FILHO
            if (raiz.noEsquerda == null){
                return raiz.noDireita;
            }

            if (raiz.noDireita == null){
                return raiz.noEsquerda;
            }

            // SE O NÓ TIVER 2 FILHOS
            // SUBSTITUI O VALOR DO NÓ REMOVIDO PELO MENOR VALOR DA SUBÁRVORE DIREITA
            raiz.valor = encontrarMenorValor(raiz.noDireita);
            // REMOVE O NÓ COM O MENOR VALOR DA SUBÁRVORE DIREITA
            raiz.noDireita = remover(raiz.noDireita, raiz.valor);
        }
        return raiz;
    }

    // ESSE MÉTODO É RESPONSÁVEL POR ENCONTRAR O MENOR VALOR DENTRO DA ÁRVORE, FOI UMA FORMA QUE EU ARRANJEI DE IMPLEMENTAR NO MÉTODO DE REMOVER PARA CASO O NÓ TENHA DOIS FILHOS
    private static int encontrarMenorValor(No raiz) {
        return raiz.noEsquerda == null ? raiz.valor : encontrarMenorValor(raiz.noEsquerda);
    }

    // MÉTODO PARA IMPRIMIR A ÁRVORE EM ORDEM
    public static void imprimirArvore(No raiz) {
        if (raiz != null) {
            imprimirArvore(raiz.noEsquerda);
            System.out.print(raiz.valor + " ");
            imprimirArvore(raiz.noDireita);
        }
    }

    public static void preFixado(No raiz){
        if (raiz != null){
            System.out.print(raiz.valor + " ");
            preFixado(raiz.noEsquerda);
            preFixado(raiz.noDireita);
        } else {
            System.out.println("Não Há Nenhum Valor Na Árvore Binária");
        }
    }
    
    public static void posFixado(No raiz){
        if (raiz != null){
            posFixado(raiz.noEsquerda);
            posFixado(raiz.noDireita);
            System.out.print(raiz.valor + " ");
        } else {
            System.out.println("Não Há Nenhum Valor Na Árvore Binária");
        }
    }
    
    public static void emOrdem(No raiz){
        if (raiz != null){
            emOrdem(raiz.noEsquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.noDireita);
        } else {
            System.out.println("Não Há Nenhum Valor Na Árvore Binária");
        }
    }

}
