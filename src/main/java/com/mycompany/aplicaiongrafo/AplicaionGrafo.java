//INTEGRANTES

package com.mycompany.aplicaiongrafo;

import java.util.Scanner;

public class AplicaionGrafo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grafo g = new Grafo();

        while (true) {
            System.out.println("\n=== SIMULADOR DE RUTAS ===");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Agregar arista");
            System.out.println("3. Mostrar grafo");
            System.out.println("4. Ejecutar BFS");
            System.out.println("5. Ejecutar DFS");
            System.out.println("6. Ejecutar Dijkstra");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre del nodo: ");
                    String nodo = sc.nextLine();
                    g.agregarNodo(nodo);
                    System.out.println("Nodo agregado.");
                }
                case 2 -> {
                    System.out.print("Origen: ");
                    String origen = sc.nextLine();
                    System.out.print("Destino: ");
                    String destino = sc.nextLine();
                    System.out.print("Peso: ");
                    int peso = sc.nextInt();
                    g.agregarArista(origen, destino, peso);
                    System.out.println("Arista agregada.");
                }
                case 3 -> g.mostrarGrafo();
                case 4 -> {
                    System.out.print("Nodo inicio: ");
                    String inicio = sc.nextLine();
                    Algoritmos.bfs(g, inicio);
                }
                case 5 -> {
                    System.out.print("Nodo inicio: ");
                    String inicio = sc.nextLine();
                    Algoritmos.dfs(g, inicio);
                }
                case 6 -> {
                    System.out.print("Nodo inicio: ");
                    String inicio = sc.nextLine();
                    System.out.print("Nodo destino: ");
                    String fin = sc.nextLine();
                    Algoritmos.dijkstra(g, inicio, fin);
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }
}
