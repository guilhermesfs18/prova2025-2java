// 04:20:17

public class prova {

    public static boolean existe(int[] v, int tam, int x) {
        boolean achou = false;
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) {
                achou = true;
            }
        }
        return achou;
    }

    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;

        for (int i = 0; i < tamA; i++) {
            if (existe(u, tamU, a[i]) == false) {
                u[tamU] = a[i];
                tamU++;
            }
        }

        for (int i = 0; i < tamB; i++) {
            if (existe(u, tamU, b[i]) == false) {
                u[tamU] = b[i];
                tamU++;
            }
        }

        return tamU;
    }

    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i++) {
            int atual = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > atual) {
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = atual;
        }
    }

    public static int gerarVetor(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;

        for (int i = 0; i < tamV; i++) {
            if (existe(vsr, tamVSR, v[i]) == false) {
                vsr[tamVSR] = v[i];
                tamVSR++;
            }
        }

        return tamVSR;
    }

    public static void rotacionarEsquerda(int[] v, int tam) {
        int primeiro = v[0];
        for (int i = 0; i < tam - 1; i++) {
            v[i] = v[i + 1];
        }
        v[tam - 1] = primeiro;
    }

    public static void rotacionarDireita(int[] v, int tam) {
        int ultimo = v[tam - 1];
        for (int i = tam - 1; i > 0; i--) {
            v[i] = v[i - 1];
        }
        v[0] = ultimo;
    }

    public static void rotacionar(int[] v, int tam, int k) {
        if (k >= 0) {
            for (int vez = 0; vez < k; vez++) {
                rotacionarEsquerda(v, tam);
            }
        } else {
            for (int vez = 0; vez < -k; vez++) {
                rotacionarDireita(v, tam);
            }
        }
    }

    public static void imprimir(int[] v, int tam) {
        for (int i = 0; i < tam; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int[] a = {1, 2, 3, 3};
        int[] b = {3, 4, 5, 1};
        int[] u = new int[a.length + b.length];
        int tamU = uniao(a, a.length, b, b.length, u);
        System.out.print("Uniao: ");
        imprimir(u, tamU);

        
        int[] s = {5, 2, 8, 1, 3};
        ordenar(s, s.length);
        System.out.print("Ordenado: ");
        imprimir(s, s.length);

        
        int[] v = {5, 2, 5, 3, 3, 8, 3, 8, 2};
        int[] vsr = new int[v.length];
        int tamVSR = gerarVetor(v, v.length, vsr);
        System.out.print("Sem repetição: ");
        imprimir(vsr, tamVSR);

        
        int[] r1 = {1, 2, 3, 4, 5};
        rotacionar(r1, r1.length, 2);
        System.out.print("Rotação k=2: ");
        imprimir(r1, r1.length);

        int[] r2 = {1, 2, 3, 4, 5};
        rotacionar(r2, r2.length, -1);
        System.out.print("Rotação k=-1: ");
        imprimir(r2, r2.length);
    }
}