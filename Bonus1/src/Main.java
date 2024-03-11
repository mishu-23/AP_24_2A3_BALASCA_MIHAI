import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int[][] creazaGraf(int noduri) {
        int[][] matrice = new int[noduri][noduri];
        for(int i = 0; i < noduri; i++) {
            matrice[0][i] = 1;
            matrice[i][0] = 1;
            matrice[i][i] = 0;
            if(i == 1) {
                matrice[1][2] = 1;
                matrice[2][1] = 1;
                matrice[1][noduri-1] = 1;
                matrice[noduri-1][1] = 1;
            } else if (i == noduri-1) {
                matrice[i-1][i] = 1;
                matrice[i][i-1] = 1;
                matrice[1][i] = 1;
                matrice[i][1] = 1;
            } else if(i != 0){
                matrice[i-1][i] = 1;
                matrice[i][i-1] = 1;
                matrice[i+1][i] = 1;
                matrice[i][i+1] = 1;
            }
        }
        for(int i = 0; i < noduri; i++) {
            for(int j = 0; j < noduri; j++) {
                System.out.print(matrice[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        return matrice;

    }
    public static int numaraCicluri(int[][] matrice) {
        int cicluri = 0;
        int[] vizitat = new int[matrice.length];
        for(int i = 0; i < matrice.length; i++) {
            if(vizitat[i] == 0) {
                List<Integer> ciclu = new ArrayList<>();
                int numarCicluriNod = dfs(matrice, i, vizitat, ciclu);
                System.out.println("Numar de cicluri pentru nodul: " + i + " este " + numarCicluriNod);
                cicluri += numarCicluriNod;
            }
        }

        return cicluri;
    }

    public static int dfs(int[][] matrice, int nod, int[] vizitat, List<Integer> ciclu) {
        vizitat[nod] = 1;
        ciclu.add(nod);

        int numarCicluriNod = 0;

        for(int i = 0; i < matrice.length; i++) {
            if(matrice[nod][i] == 1 && vizitat[i] == 0) {
                numarCicluriNod += dfs(matrice, i, vizitat, ciclu);
            } else if(matrice[nod][i] == 1 && ciclu.contains(i)){
                ciclu.add(nod);
                numarCicluriNod++;
            }

        }
            ciclu.remove(ciclu.size() - 1);
            vizitat[nod] = 0;
            return numarCicluriNod;
    }
    public static void main(String[] args) {
        int noduri = Integer.parseInt(args[0]);
        if( noduri > 3) {
            int matrice[][] = creazaGraf(noduri);
            int lungime = matrice.length;
            int cicluri = numaraCicluri(matrice);
            System.out.println("Raspuns " + cicluri + "=" + (lungime*lungime - 3*lungime + 3));
        }
        else {
            System.out.println("numar prea mic");
        }
    }
}
