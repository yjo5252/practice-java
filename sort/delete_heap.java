public int delete_heap(int[] heap, int size){
  int root = heap[1]; // root 값 세팅
  int leaf = heap[size--]; // 가장 마지막 노드의 값 저장 ;
  int parent_index=1; //처음 비교부모의 index 값
  int child_index=2; // 처음 비교할 자식의 index 값

  while (parent_index <= size) {// 힙 크기가 넘어갈 때까지 비교

      // 비교할 depth 가 존재한다면 index 변경
      if ((child_index < size) && heap[child_index] < heap[child_index +1])
      {
        child_index++;
      }

      //자식 노드보다 내가 더 크면 비교 멈춤
      if (leaf >= heap[child_index]){
        break;
      }
      //아니면 두 노드 위치를 스왑
      heap[parent_index] = heap[children_index];
      parent_index = child_index;
      child_index *= 2;
    }
    heap[paren_index] = leaf;
    return root;
  }
}   
