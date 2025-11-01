
package com.mycompany.aplicaiongrafo;
import java.util.*;


public class Grafo {
    private final Map<String, List<Arista>> adj;

    public Grafo() {
        this.adj = new HashMap<>();
    }

    public void agregarNodo(String nombre) {
        adj.putIfAbsent(nombre, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino, int peso) {
        adj.putIfAbsent(origen, new ArrayList<>());
        adj.putIfAbsent(destino, new ArrayList<>());
        adj.get(origen).add(new Arista(destino, peso));
        adj.get(destino).add(new Arista(origen, peso)); // No dirigido
    }

    public Map<String, List<Arista>> getAdyacencias() {
        return adj;
    }

    public void mostrarGrafo() {
        System.out.println("=== GRAFO ===");
        for (String nodo : adj.keySet()) {
            System.out.print(nodo + " -> ");
            for (Arista a : adj.get(nodo)) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
