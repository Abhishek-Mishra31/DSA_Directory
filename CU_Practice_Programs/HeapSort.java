package CU_Practice_Programs;

import java.util.ArrayList;

public class HeapSort {
    private static class Heap {
        public ArrayList<Integer> list;

        public Heap() {
            list = new ArrayList<>();
        }

        public void swap(int first, int second) {
            int temp = list.get(first);
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

        public void insert(int value) {
            list.add(value);
            upHeap(list.size() - 1);
        }

        private void upHeap(int index) {
            int p = getParent(index);
            if (list.get(index).compareTo(list.get(p)) < 0) {
                swap(index, p);
                upHeap(p);
            }
        }


        public int remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("In removal from empty list not allowed");
            }
            int temp = list.get(0);
            int last = list.remove(list.size() - 1);
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

        public ArrayList<Integer> heapSortFunc() throws Exception {
            ArrayList<Integer> result = new ArrayList<>();
            while (!list.isEmpty()) {
                result.add(this.remove());
            }

            return result;
        }
    }


    public static void main(String[] args) throws Exception {
        Heap object = new Heap();
        object.insert(13);
        object.insert(3);
        object.insert(93);
        object.insert(1);
        object.insert(20);
        ArrayList<Integer> output = object.heapSortFunc();
        System.out.println(output);
    }
}
