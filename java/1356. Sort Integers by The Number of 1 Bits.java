// Daily Question 10/30/2023
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] += 10001 * Integer.bitCount(arr[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            arr[i] %= 10001;
        }
        return arr;
    }
}
// [Beat 99%]
//  write own sort method. recap: quickSort(), pick pivot, partition, divide. 
// [Better] encode bitCount into arr, since arr[i] <= 10^4

// class Solution {
//     public int[] sortByBits(int[] arr) {
//         int n = arr.length;
//         // Integer[] nums = new Integer[n];
//         // for (int i = 0; i < n; i++) {
//         //     nums[i] = arr[i];
//         // }
//         Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//         Arrays.sort(nums, (a, b) -> {
//             int aa = Integer.bitCount(a);
//             int bb = Integer.bitCount(b);
//             if (aa == bb) {
//                 return Integer.compare(a, b);
//             }
//             return Integer.compare(aa, bb);
//         });
//         // for (int i = 0; i < n; i++) {
//         //     arr[i] = nums[i];
//         // }
//         // return arr;
//         return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
//     }
// }
// [ChatGPT]
//  Stream() usage about int[] and Integer[] conversion. 
//  mapToInt() -> IntStream, these primitive stream are special, their toArray() how to deal with that.

// Q1: int[] to Integer[]
// Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
// The code you provided is a Java statement that converts a primitive `int[]` array (`arr`) into an `Integer[]` array (`nums`). 

// Here's a breakdown:

// 1. `Arrays.stream(arr)` - This converts the `int[]` into an `IntStream`.
// 2. `.boxed()` - This converts the `IntStream` into a `Stream<Integer>`.
// 3. `.toArray(Integer[]::new)` - This converts the `Stream<Integer>` into an `Integer[]`.

// In essence, this is a common way to convert from a primitive int array to a boxed Integer array in Java using the Stream API.

// To provide full context, here's an example usage:

// ```java
// import java.util.Arrays;

// public class Main {
//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5};
        
//         Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
//         System.out.println(Arrays.toString(nums));  // prints [1, 2, 3, 4, 5]
//     }
// }
// ```

// In the example above, we created a primitive `int` array `arr` with some numbers, and then we used the code snippet you provided to convert it to an `Integer` array `nums`. Finally, we printed out the `nums` array to see the result.

// The `toArray` method, when used with a stream of objects (as opposed to a stream of primitives like `IntStream`), expects a generator function to provide a new array of the desired type. The generator function is expected to allocate an array of the right size and type. 

// In the example:
// ```java
// .toArray(Integer[]::new)
// ```
// `Integer[]::new` is a method reference that is equivalent to saying:
// ```java
// (size) -> new Integer[size]
// ```
// It's a function that, given a size, will return a new `Integer[]` of that size.

// This method reference is used so the stream API can create a new array of the right size and type to store the collected elements. It allows for type-safety and ensures that the collected elements are stored in an array of the appropriate type.

// Now, regarding what else `toArray()` can do:

// 1. If you use `toArray()` without any arguments on a stream of objects, it will return an array of type `Object[]`. For example:

// ```java
// Object[] array = stream.toArray();
// ```

// 2. If you're working with a stream of custom objects, you can use the same pattern. For instance, if you have a `Stream<MyClass>`, you'd do:

// ```java
// MyClass[] array = stream.toArray(MyClass[]::new);
// ```

// The key point is that by providing a generator function (like `Integer[]::new` or `MyClass[]::new`), you give the stream API a way to create an array of the exact type and size it needs to hold the stream's elements.

// Q2: int[] to Integer[]
// The code you provided:
// ```java
// int[] arr = Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
// ```
// Converts an `Integer[]` array (`nums`) into a primitive `int[]` array (`arr`). 

// Here's a breakdown:

// 1. `Arrays.stream(nums)` - This converts the `Integer[]` into a `Stream<Integer>`.
// 2. `.mapToInt(Integer::intValue)` - This transforms the `Stream<Integer>` into an `IntStream`. The `mapToInt` method is used to convert each `Integer` object in the stream into its primitive `int` value. The `Integer::intValue` is a method reference to the `intValue()` method of the `Integer` class, which returns the primitive `int` value of an `Integer` object.
// 3. `.toArray()` - This converts the `IntStream` into an `int[]`.

// The reason `toArray()` on an `IntStream` returns an `int[]` without needing a generator function (like in the case of `Stream<T>.toArray()`) is because of how the specialized streams (`IntStream`, `LongStream`, and `DoubleStream`) are designed. 

// For these specialized streams:
// 1. They are specifically for handling primitives, so their `toArray()` method already knows which type of array to return (`int[]` for `IntStream`, `long[]` for `LongStream`, and `double[]` for `DoubleStream`).
// 2. They don't need a generator function because the type (and thus the array type) is already known based on the specific stream. 

// In contrast, with `Stream<T>`, the generic type `T` could be any object type, so the API requires you to provide a generator function to know how to generate the appropriate array for collection. But for `IntStream`, `LongStream`, and `DoubleStream`, this is already predetermined, so there's no ambiguity, and hence, no need for a generator function.
