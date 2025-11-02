
package com.mycompany.aplicaiongrafo;
import java.util.*;


public class Algoritmos {
     public static void bfs(Grafo g, String inicio) {
        System.out.println("=== BFS desde " + inicio + " ===");
        Set<String> visitado = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(inicio);
        visitado.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");
            for (Arista a : g.getAdyacencias().getOrDefault(actual, new ArrayList<>())) {
                if (!visitado.contains(a.getDestino())) {
                    visitado.add(a.getDestino());
                    cola.add(a.getDestino());
                }
            }
        }
        System.out.println();
    }

    public static void dfs(Grafo g, String inicio) {
        System.out.println("=== DFS desde " + inicio + " ===");
        Set<String> visitado = new HashSet<>();
        dfsRec(g, inicio, visitado);
        System.out.println();
    }

    private static void dfsRec(Grafo g, String nodo, Set<String> visitado) {
        visitado.add(nodo);
        System.out.print(nodo + " ");
        for (Arista a : g.getAdyacencias().getOrDefault(nodo, new ArrayList<>())) {
            if (!visitado.contains(a.getDestino())) {
                dfsRec(g, a.getDestino(), visitado);
            }
        }
    }

    public static void dijkstra(Grafo g, String inicio, String fin) {
        System.out.println("=== Dijkstra de " + inicio + " a " + fin + " ===");
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String nodo : g.getAdyacencias().keySet()) {
            dist.put(nodo, Integer.MAX_VALUE);
        }
        dist.put(inicio, 0);
        pq.add(inicio);

        while (!pq.isEmpty()) {
            String actual = pq.poll();
            for (Arista a : g.getAdyacencias().getOrDefault(actual, new ArrayList<>())) {
                int nuevaDist = dist.get(actual) + a.getPeso();
                if (nuevaDist < dist.get(a.getDestino())) {
                    dist.put(a.getDestino(), nuevaDist);
                    prev.put(a.getDestino(), actual);
                    pq.add(a.getDestino());
                }
            }
        }

        if (dist.get(fin) == Integer.MAX_VALUE) {
            System.out.println("No existe camino de " + inicio + " a " + fin);
            return;
        }

        List<String> camino = new ArrayList<>();
        for (String at = fin; at != null; at = prev.get(at)) {
            camino.add(at);
        }
        Collections.reverse(camino);

        System.out.println("Distancia minima: " + dist.get(fin));
        System.out.println("Camino: " + String.join(" -> ", camino));
    }
}
