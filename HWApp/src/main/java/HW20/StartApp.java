package HW20;

public class StartApp {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        graph.printGraph();

        System.out.println("Містить вершину 3? - " + graph.hasVertex(3));
        System.out.println("Містить ребро 1-2? - " + graph.hasEdge(1, 2));

        graph.removeEdge(1, 2);
        graph.removeVertex(4);

        graph.printGraph();
    }
}
