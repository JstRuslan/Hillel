package HW20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private final Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Додає вершину
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Додає ребро між двома вершинами
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // для неорієнтованого графа
    }

    // Видаляє вершину
    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            for (int neighbor : adjacencyList.get(vertex)) {
                adjacencyList.get(neighbor).remove(vertex);
            }
            adjacencyList.remove(vertex);
        }
    }

    // Видаляє ребро між двома вершинами
    public void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source);
        }
    }

    // Перевіряє чи існує вершина
    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Перевіряє чи існує ребро
    public boolean hasEdge(int source, int destination) {
        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
    }

    // Друк графа
    public void printGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
