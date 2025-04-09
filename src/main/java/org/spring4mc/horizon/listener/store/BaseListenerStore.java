package org.spring4mc.horizon.listener.store;

import org.spring4mc.horizon.listener.EventListener;
import org.spring4mc.horizon.listener.registry.EventSubscription;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BaseListenerStore<E> {
    protected Class<E> baseClass;

    public abstract <EVENT extends E> EventSubscription<EVENT> register(EventListener<EVENT> listener);

    public abstract boolean unregister(EventSubscription<? extends E> listener);

    public static class SortedEntries<E> implements Iterable<E> {
        private final AtomicReference<E[]> arrayRef;
        private final Comparator<? super E> comparator;

        public SortedEntries(E[] array, Comparator<? super E> comparator) {
            this.arrayRef = new AtomicReference<>(array);
            this.comparator = comparator;
        }

        @Override
        public Iterator<E> iterator() {
            return Arrays.stream(this.arrayRef.get()).iterator();
        }

        @Override
        public SortedEntries<E> clone() {
            final E[] es = this.arrayRef.get();
            return new SortedEntries<>(es, this.comparator);
        }

        public void add(E element) {
            E[] oldArray;
            E[] newArray;

            do {
                oldArray = this.arrayRef.get();
                newArray = Arrays.copyOf(oldArray, oldArray.length + 1);

                int insertionPoint = Arrays.binarySearch(oldArray, element, this.comparator);
                if (insertionPoint < 0) {
                    insertionPoint = -insertionPoint - 1;
                }

                System.arraycopy(oldArray, insertionPoint, newArray, insertionPoint + 1, oldArray.length - insertionPoint);

                newArray[insertionPoint] = element;
            } while (!this.arrayRef.compareAndSet(oldArray, newArray));
        }

        public void remove(E element) {
            E[] oldArray;
            E[] newArray;

            do {
                oldArray = this.arrayRef.get();

                final int index = Arrays.binarySearch(oldArray, element, this.comparator);
                if (index < 0) {
                    return;
                }

                newArray = Arrays.copyOf(oldArray, oldArray.length - 1);

                System.arraycopy(oldArray, 0, newArray, 0, index);
                System.arraycopy(oldArray, index + 1, newArray, index, oldArray.length - index - 1);
            } while (!this.arrayRef.compareAndSet(oldArray, newArray));
        }
    }
}
