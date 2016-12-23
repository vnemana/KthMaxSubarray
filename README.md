**Kth Max Subarray Project**

- Need to read an input file
- First line contains the number of test cases - T
- Each of the next 2 sets of lines contains 2 and 3 below T times
- 2nd line contains array size N and max sub-array size M.
- 3rd line contains the full array.
- Each of the next M lines contains a single integer - p.

Output:
- Output a single integer corresponding to the maximum element in the pth subarray.


- Comparison of 2 subarrays - they need to be arranged in descending order.
    compare(B, C):
        Append N - |B| zeros at the end of the array B.
        Append N - |C| zeros at the end of the array C.
        for i = 1 to N:
            if B[i] < C[i]:
                return B is less than C
            if B[i] > C[i]:
                return B is greater than C
        return B and C are equal.

**Subtasks**

**Subtask #1 (20 points):**
1 ≤ T ≤ 20
1 ≤ N ≤ 200
1 ≤ M ≤ 104

**Subtask #2 (30 points):**
1 ≤ T ≤ 20
1 ≤ N ≤ 3000
1 ≤ M ≤ 104

**Subtask #3 (50 points):**
1 ≤ T ≤ 5
1 ≤ N ≤ 105
1 ≤ M ≤ 105

**Example**

Input:
1
4 2
3 1 2 4
1
5

Output:
4
3
