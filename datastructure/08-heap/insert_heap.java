void insert_heap(int data, int[]heap, int new_index){
  int i;
  if (heap(heap.length != 0)){
    System.out.println("heap is full");
  }
  i = now_index;
  heap[i] = data;

  while((i!=-1)&&(heap[i]>heap[i/2])){
    int temp = heap[i];
    heap[i] = heap[i/2];
    heap[i/2] = temp;
    i /= 2;
  }


}
