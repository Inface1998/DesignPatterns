package com.test.iteration;

import java.util.Arrays;
import java.util.List;

/**
 * @author : zhanghj
 */
public class MyList {
    private List<String> data = Arrays.asList("a","b","c");
    public Iterator iterator(){
        return new Itr();
    }
    private class Itr implements Iterator{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public String next() {
            return data.get(index++);
        }
    }
}
