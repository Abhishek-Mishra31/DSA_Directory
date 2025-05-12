package CU_Practice_Programs.Algo_Implementations;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Graph object = new Graph(5);
        object.addEdge(0, 1 , 1);
        object.addEdge(1, 2 , 7);
        object.addEdge(2  , 3 , 3);
        object.addEdge(0, 3 , 4);
        object.printGraph();
        System.out.println(object.getEdges());
        object.kruskalMST();

//        object.addEdge(0,1,6);
//        object.addEdge(0,2,4);
//        object.addEdge(2,1,1);
//        object.addEdge(3,4,2);
//        object.addEdge(2,4,7);
//
//        object.printGraph();
//       object.kruskalMST();


    }
}

