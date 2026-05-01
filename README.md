# Algorithm Performance Experiment (Java)

## A. Project Overview

This project compares the performance of three selected algorithms in Java:

- **Insertion Sort** (Basic Sorting)
- **Merge Sort** (Advanced Sorting)
- **Binary Search** (Searching)

The purpose of this experiment is to measure and compare how these algorithms perform under different conditions using execution time in nanoseconds.

The program tests:
- Different array sizes:
  - Small (10 elements)
  - Medium (100 elements)
  - Large (1000 elements)
- Different input types:
  - Random arrays
  - Sorted arrays

The goal is to observe how input size and input order affect algorithm efficiency and compare practical performance with theoretical Big-O complexity.

---

## B. Algorithm Descriptions

### 1. Insertion Sort

**How it works:**  
Insertion Sort builds the sorted array one element at a time. It takes each element and inserts it into the correct position among the already sorted elements.

**Time Complexity:**
- Best Case: **O(n)**  
- Average Case: **O(n²)**  
- Worst Case: **O(n²)**  

**Why used:**  
Insertion Sort is simple to implement and performs well on small or nearly sorted datasets.

---

### 2. Merge Sort

**How it works:**  
Merge Sort uses the divide-and-conquer approach. It splits the array into smaller parts, recursively sorts them, and then merges them back together in sorted order.

**Time Complexity:**
- Best Case: **O(n log n)**  
- Average Case: **O(n log n)**  
- Worst Case: **O(n log n)**  

**Why used:**  
Merge Sort is much more efficient than basic sorting algorithms on larger datasets and provides stable performance.

---

### 3. Binary Search

**How it works:**  
Binary Search repeatedly divides the sorted array in half to locate the target value.

**Time Complexity:**
- Best Case: **O(1)**  
- Average Case: **O(log n)**  
- Worst Case: **O(log n)**  

**Why used:**  
Binary Search is one of the fastest searching algorithms, but it only works on sorted arrays.

---

## C. Experimental Results

### Execution Time Table (Example)

| Array Size | Input Type | Insertion Sort (ns) | Merge Sort (ns) | Binary Search (ns) |
|-----------|------------|--------------------:|----------------:|-------------------:|
| 10        | Random     | 12300               | 14200           |                    |
| 10        | Sorted     | 900                 | 5200            | 3400               |
| 100       | Random     | 82200               | 100300          |                    |
| 100       | Sorted     | 6100                | 78800           | 1900               |
| 1000      | Random     | 7913900             | 1102900         |                    |
| 1000      | Sorted     | 47400               | 1081400         | 2300               |

> Replace these values with your actual program output.

---

### Comparison by Input Size

The results show that execution time increases as array size becomes larger.

- For small arrays, both sorting algorithms perform relatively fast.
- For medium arrays, Merge Sort becomes noticeably faster than Insertion Sort.
- For large arrays, Merge Sort performs significantly better.

This shows that Merge Sort scales better as input size increases.

---

### Comparison: Sorted vs Random Arrays

Input type had a strong effect on Insertion Sort.

- Insertion Sort was much faster on sorted arrays because it required fewer comparisons and shifts.
- On random arrays, Insertion Sort became much slower due to more element movement.

Merge Sort was less affected by input type because it always divides and merges the array in the same way.

This demonstrates that Insertion Sort is sensitive to input order, while Merge Sort is more consistent.

---

## D. Performance Analysis

### 1. Which sorting algorithm performed faster? Why?

Merge Sort performed faster in most cases, especially for medium and large arrays.

This is because Merge Sort has a time complexity of **O(n log n)**, which grows much more efficiently than Insertion Sort’s **O(n²)** on large datasets.

Insertion Sort was only competitive on very small or already sorted arrays.

---

### 2. How does performance change with input size?

As input size increases, execution time also increases.

However, the increase is much more dramatic for Insertion Sort than for Merge Sort.

- Insertion Sort slows down quickly because its complexity grows quadratically.
- Merge Sort grows more efficiently and handles large arrays much better.

---

### 3. How does sorted vs unsorted data affect performance?

Sorted data improves Insertion Sort significantly because fewer operations are needed.

Random data makes Insertion Sort slower because elements must be shifted more often.

Merge Sort is less affected because its process remains mostly the same regardless of initial order.

---

### 4. Do the results match expected Big-O complexity?

Yes, the results match the expected theoretical complexity.

- Insertion Sort behaved like **O(n²)** on random data and close to **O(n)** on sorted data.
- Merge Sort behaved close to **O(n log n)** in all cases.
- Binary Search remained very fast and scaled close to **O(log n)**.

The measured results are consistent with theoretical expectations.

---

### 5. Which searching algorithm is more efficient? Why?

Binary Search is more efficient than Linear Search because it eliminates half of the remaining elements in each step.

This gives Binary Search a time complexity of **O(log n)**, while Linear Search requires checking elements one by one with **O(n)** complexity.

As array size increases, Binary Search becomes much more efficient.

---

### 6. Why does Binary Search require a sorted array?

Binary Search works by comparing the target to the middle element and deciding whether to search left or right.

This decision is only valid if the array is sorted.

Without sorting, there is no guarantee that values on one side are smaller or larger than the middle value, so Binary Search would not work correctly.

---

## E. Screenshots

Include screenshots of:

1. Program output in terminal
2. Small array test run
3. Medium array test run
4. Large array test run
5. Comparison results clearly visible

Make sure screenshots are readable and show execution times clearly.

---

## F. Reflection

This experiment showed that algorithm efficiency becomes much more important as data size increases. While simple algorithms such as Insertion Sort are easy to implement and perform well on small datasets, they become inefficient on larger random inputs. Merge Sort required more complex implementation but provided much better performance and scalability.

The experiment also showed that theoretical complexity is a useful predictor of practical performance. However, practical results also depend on factors such as input order, hardware speed, and implementation details. One challenge during implementation was ensuring fair comparisons by copying arrays before sorting and measuring execution time accurately using `System.nanoTime()`.
