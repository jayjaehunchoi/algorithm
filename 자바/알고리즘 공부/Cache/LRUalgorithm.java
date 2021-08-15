import java.util.*;

class LRUCache{
  
  // cache item클래스를 생성하여 맵같은 형태를 구현해줄거임
  class CacheItem{
    int key;
    int value;
    CacheItem prev;
    CacheItem next;
    
    public CachItem(int key, int value){
      this.key = key;
      this.value = value;
    }
  }
  
  CacheItem head;
  CacheItem tail;
  int capacity;
  Map<Integer, CacheItem> map;
  
  // 첫 LRU때, head, tail초기화, 용량설정, 저장소 만들기 
  LRUCache(int capacity){
    head = null;
    tail = null;
    this.capacity = capacity;
    map = new HashMap<>();
  }
  
  // 정보 가져오기
  public int get(int key){
    if(!map.containsKey(key)){
      return -1;
    }else{
      CacheItem cur = map.get(key);
      
      if(cur != head){
        if(cur == tail){
          tail = tail.prev;
        }
        if(cur.prev != null) cur.prev.next = cur.next;
        if(cur.next != null) cur.next.prev = cur.prev;
        cur.next = head;
        head.prev = cur;
        cur.prev = null;
        head = cur;
    }
      return cur.value;
   }
  }
  
  //정보 넣기
  public void put(int key, int value){
    if(get(key) == -1){
      CacheItem cur = new CacheItem(key, value);
      
      if(head == null){
        head = cur;
        tail = cur;
      }else{
       
        head.prev = cur;
        cur.next = head;
        head = cur;
      }
      map.put(key, cur);
      
      if(map.size > capacity){
        map.remove(tail.key);
        tail.prev.next = null;
        tail = tail.prev;
      }
    } else{
      map.get(key).value = value;
    }
  }
}

        
        
          


