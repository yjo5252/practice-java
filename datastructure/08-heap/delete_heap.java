int delete_heap(int[]heap, int size){

  int root = heap[1];       //  root 값 세팅
  int leaf = heap[size--];  // leaf 값 세팅
  parent_index = 1;
  child_index = 2;

  while(child_index <= size){
    if((child_index < size) && (heap[child_inde]<heap[child_index+1]) {
          child_index++;
    }

    if (leaf >= heap[child_index]){
      break;
    }

    // 두 노드 swap
    heap[parent_index] = heap[child_index];
    parent_index = child_index;
    child_index *2;
  }

  heap[parent_index] = leaf;
  return root;

}
