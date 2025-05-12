package CU_Practice_Programs.Algo_Implementations;

import java.util.ArrayList;
import java.util.List;

public class HeapEdgesSort {
    public static class Heap {
        public static ArrayList<Graph.Edge> list;

        public Heap() {
            list = new ArrayList<>();
        }

        public void swap(int first, int second) {
            Graph.Edge temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        public int getParent(int index) {
            return (index - 1) / 2;
        }

        public int getLeft(int index) {
            return (index * 2) + 1;
        }

        public int getRight(int index) {
            return (index * 2) + 2;
        }

        public void insert(Graph.Edge edge) {
            list.add(edge);
            upHeap(list.size() - 1);
        }

        private void upHeap(int index) {
            int p = getParent(index);
            if (p >= 0 && list.get(index).compareTo(list.get(p)) < 0) {
                swap(index, p);
                upHeap(p);
            }
        }

        public Graph.Edge remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Heap is empty");
            }
            Graph.Edge temp = list.get(0);
            Graph.Edge last = list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                list.set(0, last);
                downHeap(0);
            }
            return temp;
        }

        private void downHeap(int index) {
            int min = index;
            int left = getLeft(index);
            int right = getRight(index);

            if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
                min = left;
            }

            if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
                min = right;
            }

            if (min != index) {
                swap(min, index);
                downHeap(min);
            }
        }

        public ArrayList<Graph.Edge> heapSortFunc() throws Exception {
            ArrayList<Graph.Edge> result = new ArrayList<>();
            while (!list.isEmpty()) {
                result.add(this.remove());
            }
            return result;
        }

        public static List<Graph.Edge> sortEdges(List<Graph.Edge> edges) throws Exception {;
            Heap heap = new Heap();

            for (Graph.Edge edge : edges) {
                heap.insert(edge);
            }
            return heap.heapSortFunc();
        }
    }

}
