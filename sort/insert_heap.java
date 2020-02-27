void insert_heap (int data, int[] heap, int now_index) {
  int i;
  if (heap[heap.length-1]!= 0){ //heap 으로 가득차있으면 종료한다.
      System.out.println("heap is full");
  }
  i = now_index

  heap[i] = data;
  while((i!=1) && heap[i] >heap[i/2]){
    //root Node가 되거나 부모노드보다 작을때까지 위치 재지정
    int temp =  heap[i];
    heap[i] = heap[i/2];
    heap[i/2] = heap[i];
    i/=2;
  }
}
