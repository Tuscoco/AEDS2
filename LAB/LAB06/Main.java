import java.util.*;

/**
 * Main
 */

public class Main {

    public static void swap(int[] array,int n,int n2){
        int tmp = array[n];
        array[n] = array[n2];
        array[n2] = tmp;
    }

    public static int mediana(int inicio, int meio, int fim){

        int resultado = 0;

        if(((inicio >= meio) && (inicio <= fim)) || ((inicio >= fim) && (inicio <= meio))){

            resultado = inicio;

        }else if(((meio >= inicio) && (meio <= fim)) || ((meio >= fim) && (meio <= inicio))){

            resultado = meio;

        }else if(((fim >= meio) && (fim <= inicio)) || ((fim >= inicio) && (fim <= meio))){

            resultado = fim;

        }

        return resultado;

    }

    public static void quicksortFirstPivot(int[] array, int left, int right){

        int i = left;
        int j = right;
        int pivo = array[i];

        while(i <= j){

            while(array[i] < pivo){
                i++;
            }
            while(array[j] > pivo){
                j--;
            }

            if(i <= j){
                swap(array, i, j);
                i++;
                j--;
            }

        }

        if(left < j){
            quicksortFirstPivot(array, left, j);
        }

        if(i < right){
            quicksortFirstPivot(array, i, right);
        }

    }

    public static void quicksortLastPivot(int[] array, int left, int right){

        int i = left;
        int j = right;
        int pivo = array[j];

        while(i <= j){

            while(array[i] < pivo){
                i++;
            }
            while(array[j] > pivo){
                j--;
            }

            if(i <= j){
                swap(array, i, j);
                i++;
                j--;
            }

        }

        if(left < j){
            quicksortFirstPivot(array, left, j);
        }

        if(i < right){
            quicksortFirstPivot(array, i, right);
        }

    }

    public static void quicksortRandomPivot(int[] array, int left, int right){

        Random rand = new Random();
        int i = left;
        int j = right;
        int pivo = array[rand.nextInt(j + 1)];

        while(i <= j){

            while(array[i] < pivo){
                i++;
            }
            while(array[j] > pivo){
                j--;
            }

            if(i <= j){
                swap(array, i, j);
                i++;
                j--;
            }

        }

        if(left < j){
            quicksortFirstPivot(array, left, j);
        }

        if(i < right){
            quicksortFirstPivot(array, i, right);
        }

    }

    public static void quicksortMedianOfThree(int[] array, int left, int right){

        int i = left;
        int j = right;
        int pivo = mediana(array[i], array[j/2], array[j]);

        while(i <= j){

            while(array[i] < pivo){
                i++;
            }
            while(array[j] > pivo){
                j--;
            }

            if(i <= j){
                swap(array, i, j);
                i++;
                j--;
            }

        }

        if(left < j){
            quicksortFirstPivot(array, left, j);
        }

        if(i < right){
            quicksortFirstPivot(array, i, right);
        }

    }

    public static int[] gerarArrayOrdenado(int n){

        int[] array = new int[n];

        for(int i = 0;i < n;i++){

            array[i] = i + 1;

        }

        return array;

    }

    public static int[] gerarArrayQuaseOrdenado(int n){

        int[] array = new int[n];

        for(int i = 0;i < n;i++){

            array[i] = i + 1;

        }

        array[n/2] = n;
        array[(n / 2) + 1] = n;
        array[(n / 2) + 2] = n + n;

        return array;

    }

    public static int[] gerarArrayAleatorio(int n){

        int[] array = new int[n];

        Random rand = new Random();

        for(int i = 0;i < n;i++){

            array[i] = rand.nextInt();

        }

        return array;

    }
    
    public static void main(String[] args) {

        long inicio;
        long fim;
        long tempo;
        
        System.out.println("First Pivot Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("First Pivot Quase Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayQuaseOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayQuaseOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayQuaseOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("First Pivot Aleatorio:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayAleatorio(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayAleatorio(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortFirstPivot(gerarArrayAleatorio(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        //////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("Last Pivot Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("Last Pivot Quase Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayQuaseOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayQuaseOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayQuaseOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("Last Pivot Aleatorio:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayAleatorio(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayAleatorio(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortLastPivot(gerarArrayAleatorio(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        //////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("Random Pivot Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("Random Pivot Quase Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayQuaseOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayQuaseOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayQuaseOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("Random Pivot Aleatorio:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayAleatorio(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayAleatorio(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortRandomPivot(gerarArrayAleatorio(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        //////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("MedianOfThree Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("MedianOfThree  Quase Ordenado:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayQuaseOrdenado(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayQuaseOrdenado(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayQuaseOrdenado(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");


        System.out.println();
        System.out.println("MedianOfThree  Aleatorio:");
        System.out.println();
        
        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayAleatorio(100), 0, 99);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 100 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayAleatorio(1000), 0, 999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 1000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

        inicio = System.nanoTime();
        quicksortMedianOfThree(gerarArrayAleatorio(10000), 0, 9999);
        fim = System.nanoTime();
        tempo = fim - inicio;
        System.out.println("Array de 10000 elementos");
        System.out.println("Tempo: " + tempo/1000000 + "ms");

    }
    
}