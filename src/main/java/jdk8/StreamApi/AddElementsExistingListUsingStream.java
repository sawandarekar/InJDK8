package jdk8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.techiedelight.com/add-elements-stream-existing-list-java/
 */
public class AddElementsExistingListUsingStream {

    public static void main (String[] args)
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("list:"+list);
        addToList(list, Stream.of(4, 5));
        System.out.println("addToList:"+list);
        addToListSequential(list, Stream.of(6,7));
        System.out.println("addToListSequential:"+list);
        addToListForEachOrdered(list, Stream.of(8,9));
        System.out.println("addToListForEachOrdered:"+list);
        addToListTargetAddAll(list, Stream.of(10,11));
        System.out.println("addToListTargetAddAll:"+list);
        list = addToListStreamConcat(list, Stream.of(12,13));
        System.out.println("addToListStreamConcat:"+list);
    }
    // Generic function to add elements of a Stream into an existing list
    public static<T> void addToList(List<T> target, Stream<T> source)
    {
        source.collect(Collectors.toCollection(() -> target));
    }
    // Generic function to add elements of a Stream into an existing list
    public static<T> void addToListSequential(List<T> target, Stream<T> source)
    {
        source.sequential()
            .collect(Collectors.toCollection(() -> target));
    }
    // Generic function to add elements of a Stream into an existing list
    public static<T> void addToListForEachOrdered(List<T> target, Stream<T> source)
    {
        source.forEachOrdered(target::add);
    }
    // Generic function to add elements of a Stream into an existing list
    public static<T> void addToListTargetAddAll(List<T> target, Stream<T> source)
    {
        target.addAll(source.collect(Collectors.toList()));
    }
    // Generic function to add elements of a Stream into an existing list
    public static<T> List<T> addToListStreamConcat(List<T> target, Stream<T> source)
    {
        return Stream.concat(target.stream(), source)
            .collect(Collectors.toList());
    }
}
