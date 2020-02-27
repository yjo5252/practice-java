//Radix Sort version 2 

public static void Radix_Sort(int[] data, int max_size)
{
  ArrayList <Queue> bucket = new ArrayList[];
  int jarisu = 1;
  // 양의 정수의 자리수는 10개이므로 (0-9) 10개의 자리수 생성
  for (int i=0; i< 10; i++)  {
    buckeet.add(new PriorityQueue<Integer>(10))
  }

  int count = 0;

  while (count != max_size){ // 최대 자리수만큼 반복
    int index = 0;

    for (int i=0; i<data.length; i++){
      // 자리수에 있는 Value 값을 기반으로 버켓에 저장을 수행함
      bucket.get(data[i]/ jarisu)%10).add(data[i]));
    }
    // 버켓 데이터를 기반으로 해당 자리수 기반 정렬된 데이터를 배열에 다시 정리함

    for (int i=0; i<10; i++) {
      int bucket_num = bucket.get(i).size();
      for (int j=0; j<bucket_num; j++) {
        data[index] = (int)bucket.get(i).poll();
        index++;
      }
    }
    jarisu = jarisu *10; //자리수 증가
    count++;
  }
}
