package functional;

import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface ListPrinter<T> {
    void print(List<T> list, Predicate<T> predicate);
}
