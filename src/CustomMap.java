import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class KeyValue<K, V>{
    final K key;
    V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof KeyValue) {
            KeyValue<K, V> newKeyValue = (KeyValue<K,V>) obj;
            return this.key.equals(newKeyValue.key);
        }
        return false;
    }

}

public class CustomMap<K, V> implements Map<K, V> {

    List<LinkedList<KeyValue<K,V>>> list = new ArrayList<>();
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        int position = hash(key);
        LinkedList<KeyValue<K,V>> linkedList;
        if(list.size()-1>=position) {
            linkedList = list.get(position);
            return linkedList.contains(new KeyValue<K,V>((K)key, null));
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
// TODO Auto-generated method stub 
        return false;
    }

    @Override
    public V get(Object key) {
        int position = hash(key);
        LinkedList<KeyValue<K,V>> linkedList;
        if(list.size()-1>=position) {
            linkedList = list.get(position);
            int index = linkedList.indexOf(new KeyValue<K,V>((K)key, null));
            return index != -1? linkedList.get(index).value : null;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int position = hash(key);
        KeyValue<K,V> keyVal = new KeyValue<K, V>(key, value);
        LinkedList<KeyValue<K,V>> linkedList;
        if(list.size()-1>=position) {
            linkedList = list.get(position);
        }
        else {
            for(int i=list.size()-1; i<=position; i++) {
                list.add(new LinkedList<KeyValue<K,V>>());
            }
            linkedList = new LinkedList<>();
            linkedList.add(keyVal);
            list.set(position, linkedList);
            size++;
            return value;
        }
        if(linkedList.contains(keyVal)) {
            linkedList.remove(keyVal);
            size--;
        }
        linkedList.add(keyVal);
        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
// TODO Auto-generated method stub 
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
// TODO Auto-generated method stub 
    }

    @Override
    public void clear() {
// TODO Auto-generated method stub 

    }

    @Override
    public Set<K> keySet() {
// TODO Auto-generated method stub 
        return null;
    }

    @Override
    public Collection<V> values() {
// TODO Auto-generated method stub 
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
// TODO Auto-generated method stub 
        return null;
    }

    private int hash(Object key) {
        int hashcode = key.hashCode();
        hashcode%=1000;
        return hashcode < 0 ? hashcode*-1:hashcode;
    }

    public static void main(String[] args) {
        CustomMap<String, String> customMap = new CustomMap<>();
        System.out.println(customMap.put("aks", "value"));
        System.out.println(customMap.put("aks", "value1"));
        System.out.println(customMap.put("aksmint", "aksmint"));
        System.out.println(customMap.get("aks"));
        System.out.println(customMap.get("aksmint"));
        System.out.println(customMap.containsKey("aks"));
        System.out.println(customMap.containsKey("aksmint"));
        System.out.println(customMap.containsKey("aksmi"));
        System.out.println(customMap.size());
        System.out.println(customMap.isEmpty());
        System.out.println(customMap.get(1));
        System.out.println("-----------------------------------------");
        CustomMap<Integer, String> customMap1 = new CustomMap<>();
        System.out.println(customMap1.put(1, "value"));
        System.out.println(customMap1.put(2, "value1"));
        System.out.println(customMap1.put(3, "aksmint"));
        System.out.println(customMap1.get("aks"));
        System.out.println(customMap1.get("aksmint"));
        System.out.println(customMap1.containsKey("aks"));
        System.out.println(customMap1.containsKey("aksmint"));
        System.out.println(customMap1.containsKey("aksmi"));
        System.out.println(customMap1.size());
        System.out.println(customMap1.isEmpty());
        System.out.println(customMap1.get(1));
    }

} 