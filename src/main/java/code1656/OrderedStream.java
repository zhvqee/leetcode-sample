package code1656;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class OrderedStream {

    private int ptr;

    private int n;

    private TreeMap<Integer, String> keyValue = new TreeMap<>();


    public OrderedStream(int n) {
        this.n = n;
        this.ptr = 1;

    }

    public List<String> insert(int idKey, String value) {
        if (keyValue.size() >= n) {
            return new ArrayList<>();
        }
        keyValue.put(idKey, value);
        if (ptr != idKey) {
            return new ArrayList<>();
        }
        SortedMap<Integer, String> sortedMap = keyValue.tailMap(ptr);
        List<String> ret = new ArrayList<>(sortedMap.size());
        int current = ptr;
        for (SortedMap.Entry<Integer, String> entry : sortedMap.entrySet()) {
            if (entry.getKey() == current) {
                ret.add(entry.getValue());
                current++;
            }
        }
        ptr = current;

        return ret;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);

        List<String> ccccc = orderedStream.insert(3, "ccccc");
        ccccc = orderedStream.insert(1, "aaaaa");
        ccccc = orderedStream.insert(2, "bbbbb");
        ccccc = orderedStream.insert(5, "eeeee");
        ccccc = orderedStream.insert(4, "ddddd");
    }

}
