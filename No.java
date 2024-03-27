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

    // PRÉ-ORDEM: ORDEM DE VISITA = RAIZ, ESQUERDA, DIREITA
    public static void preOrdem(No raiz){
        if (raiz != null){
            System.out.print(raiz.valor + " ");
            preOrdem(raiz.noEsquerda);
            preOrdem(raiz.noDireita);
        } 
    }
    
    // PÓS-ORDEM: ORDEM DE VISITA = ESQUERDA, DIREITA, RAIZ
    public static void posOrdem(No raiz){
        if (raiz != null){
            posOrdem(raiz.noEsquerda);
            posOrdem(raiz.noDireita);
            System.out.print(raiz.valor + " ");
        } 
    }
    
    // PÓS-ORDEM: ORDEM DE VISITA = ESQUERDA, RAIZ, DIREITA
    public static void emOrdem(No raiz){
        if (raiz != null){
            emOrdem(raiz.noEsquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.noDireita);
        } 
    }

    // MÉTODO QUE PERCORRE OS NÓS DA ÁRVORE E FAZ A CONTAGEM DA MESMA
    public static int contarNos(No raiz){
        if (raiz == null) // VERIFICA SE A RAIZ É NULA
            return 0;
        else return (1 + contarNos(raiz.noEsquerda) + contarNos(raiz.noDireita)); // CONTA OS NÓS DAS SUBÁRVORES DIREITA E ESQUERDAS
    }
    
    // Se o nó com o valor especificado não existir, retorna null
    public static No encontrarNo(No raiz, int valor) {
        if (raiz == null || raiz.valor == valor) {
            return raiz;
        }
        if (valor < raiz.valor) {
            return encontrarNo(raiz.noEsquerda, valor);
        }
        return encontrarNo(raiz.noDireita, valor);
    }
    
    
    // MÉTODO QUE CALCULA A ALTURA DE UM NÓ ESPECÍFICO
    public static int alturaDoNo(No raiz, int valorNo) {
        No noAlvo = encontrarNo(raiz, valorNo);
        if (noAlvo == null) {
            return -1; // Nó não encontrado
    }
        return alturaDoNo(noAlvo);
    }
    
    // MÉTODO QUE CALCULA A ALTURA DE UM NÓ
    public static int alturaDoNo(No no) {
        if (no == null) {
            return -1; // Nó vazio tem altura -1
        }
        int alturaEsquerda = alturaDoNo(no.noEsquerda);
        int alturaDireita = alturaDoNo(no.noDireita);
        return 1 + Math.max(alturaEsquerda, alturaDireita); // Altura do nó é 1 + a maior altura entre as subárvores esquerda e direita
    }

    // MÉTODO QUE PROCURA A ALTURA DA ÁRVORE
    public static int altura(No raiz){
        if (raiz == null || (raiz.noEsquerda == null && raiz.noDireita == null)) // VERIFICA SE A RAIZ É NULA
            return 0;
        else{    
            if (altura(raiz.noEsquerda) > altura(raiz.noDireita)) // CALCULA A ALTURA DA SUBÁRVORE
            return (1 + altura(raiz.noEsquerda)); // 1 + ALTURA DA SUBÁRVORE ESQUERDA
            
            else
            return (1 + altura(raiz.noDireita)); // 1 + ALTURA DA SUBÁRVORE DIREITA
        }
    } 

    // MÉTODO QUE IMPRIME A ÁRVORE COM IDENTAÇÃO
    public static void imprimirArvoreIdentada(No raiz, int nivel) {
        if (raiz != null) {
            imprimirArvoreIdentada(raiz.noEsquerda, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   "); // Adiciona espaços para identação
            }
            System.out.println(raiz.valor); // Imprime o valor do nó
            imprimirArvoreIdentada(raiz.noDireita, nivel + 1);
        }
    }

    // MÉTODO QUE RETORNA O NÍVEL DE CADA NÓ
    public static int nivelNo(No raiz, int valor, int nivelAtual) {
        if (raiz == null)
            return -1;
        // SE O VALOR DA RAIZ FOR IGUAL O VALOR INSERIDO, ENTÃO ELE SÓ RETORNA O NÍVEL ATUAL
        if (raiz.valor == valor)
            return nivelAtual;

        int nivelNoEsquerda = nivelNo(raiz.noEsquerda, valor, nivelAtual + 1);
        if (nivelNoEsquerda != -1)
            return nivelNoEsquerda;

        int nivelNoDireita = nivelNo(raiz.noDireita, valor, nivelAtual + 1);
        return nivelNoDireita;
    }


    // MÉTODO RESPONSÁVEL POR RETORNAR A ALTURA DE CADA NÓ
    public static void alturaDeCadaNo(No raiz, int nivelAtual) {
        if (raiz == null)
            return;
        // RETORNA O VALOR ATUAL DO NÓ + O NÍVEL
        System.out.println("Nó: " + raiz.valor + " - Altura: " + nivelAtual);

        // A ALTURA DE CADA NÓ É A SUA RAIZ COM O NÍVEL DELA + 1
        alturaDeCadaNo(raiz.noEsquerda, nivelAtual + 1);
        alturaDeCadaNo(raiz.noDireita, nivelAtual + 1);
    }

    // MÉTODO RESPONSÁVEL POR VERIFICAR A PROFUNDIDADE DE CADA NÓ
    public static void profundidadeDeCadaNo(No raiz, int nivelAtual) {
        if (raiz == null)
            return;

        System.out.println("Nó: " + raiz.valor + " - Profundidade: " + nivelAtual);

        profundidadeDeCadaNo(raiz.noEsquerda, nivelAtual + 1);
        profundidadeDeCadaNo(raiz.noDireita, nivelAtual + 1);
    }

    // MÉTODO RESPONSÁVEL POR RETORNAR A PROFUNCIDADE DA ÁRVORE
    public static int profundidadeDaArvore(No raiz) {
        if (raiz == null)
            return 0;

        int profundidadeEsquerda = profundidadeDaArvore(raiz.noEsquerda);
        int profundidadeDireita = profundidadeDaArvore(raiz.noDireita);

        return Math.max(profundidadeEsquerda, profundidadeDireita) + 1;
    }

    // RETORNA O NÍVEL DA ÁRVORE
    public static int nivelDaArvore(No raiz) {
        if (raiz == null)
            return 0;

        int nivelEsquerda = nivelDaArvore(raiz.noEsquerda);
        int nivelDireita = nivelDaArvore(raiz.noDireita);

        return Math.max(nivelEsquerda, nivelDireita) + 1;
    }

}
