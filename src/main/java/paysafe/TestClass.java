package paysafe;

import java.util.*;

/**
 * Created by anuhyacheruvu on 08/10/17.
 */
public class TestClass {
    private int distances[];
    private Set<Integer> settled;
    private Set<Integer> policeNodes;
    private int number_of_nodes;
    private int adjacencyMatrix[][];
    private PriorityQueue<Node> priorityQueue;

    public TestClass(int number_of_nodes, Set policeNodes, int[][] adjacencyMatrix) {
        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes];
        settled = new HashSet<Integer>();
        this.adjacencyMatrix = adjacencyMatrix;
        this.policeNodes = policeNodes;
        priorityQueue = new PriorityQueue<Node>(number_of_nodes, new Node());
    }

    public int getMinDistance(int source, int destination) {
        int evaluationNode;
        for (int i = 0; i < number_of_nodes; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        if (!policeNodes.contains(source)) {
            priorityQueue.add(new Node(source - 1, 0));
            distances[source - 1] = 0;
            while (!priorityQueue.isEmpty()) {
                evaluationNode = getNodeWithMinimumDistance();
                settled.add(evaluationNode);
                evaluateNeighbours(evaluationNode);
            }
        }
        if (distances[destination] != Integer.MAX_VALUE) {
            return distances[destination - 1];
        }
        return -1;
    }

    private int getNodeWithMinimumDistance() {
        int node = priorityQueue.remove().node_Number;
        return node;
    }

    private void evaluateNeighbours(int evaluationNode) {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int destinationNode = 0; destinationNode < number_of_nodes; destinationNode++) {
            if (!policeNodes.contains(destinationNode)) {
                if (adjacencyMatrix[evaluationNode][destinationNode] != 0) {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode]) {
                        distances[destinationNode] = newDistance;
                    }
                    priorityQueue.add(new Node(destinationNode, distances[destinationNode]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int nodes = sc.nextInt();
            Set<Integer> policeNodes = new HashSet<Integer>();
            for (int j = 1; j <= nodes; j++) {
                int temp = sc.nextInt();
                if (temp == 1) {
                    policeNodes.add(j);
                }
            }
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int[][] adjacency_Matrix = new int[nodes + 1][nodes + 1];
            int m = sc.nextInt();
            sc.nextInt();
            for (int k = 1; k <= m; k++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int d = sc.nextInt();
                adjacency_Matrix[u - 1][v - 1] = d;
            }
            TestClass algorithmSet = new TestClass(nodes, policeNodes, adjacency_Matrix);
            int minDistance = algorithmSet.getMinDistance(source, destination);
            System.out.println(minDistance);

        }

    }
}

 class Node implements Comparator<Node> {
    public int node_Number;
    public int distance;

    public Node() {

    }

    public Node(int node_Number, int distance) {
        this.node_Number = node_Number;
        this.distance = distance;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.distance < node2.distance)
            return -1;
        if (node1.distance > node2.distance)
            return 1;
        return 0;
    }
}
