package froggy.implementations;

import froggy.interfaces.Lake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LakeImpl<T extends Integer> implements Lake<Integer> {
    private static final int DEFAULT_INDEX_VALUE = 0;

    private List<Integer> numbers;

    public LakeImpl(Integer... numbers) {
        this.setNumbers(numbers);
    }

    private void setNumbers(Integer... numbers) {
        this.numbers = new ArrayList<>();
        Collections.addAll(this.numbers, (numbers));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
        private int index;
        private List<Integer> frogJumps;

        public Frog() {
            this.index = DEFAULT_INDEX_VALUE;
            this.setIndices();
        }

        @Override
        public boolean hasNext() {
            return this.index < this.frogJumps.size();
        }

        @Override
        public Integer next() {
            return this.frogJumps.get(this.index++);
        }

        private void setIndices() {
            this.frogJumps = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 == 0) {
                    this.frogJumps.add(numbers.get(i));
                }
            }

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 != 0) {
                    this.frogJumps.add(numbers.get(i));
                }
            }
        }
    }
}