
# Edit Distance (Levenshtein Distance) using Dynamic Programming in Java

This repository contains a Java implementation of the **Edit Distance** algorithm (also known as **Levenshtein Distance**) using **Dynamic Programming**.

## What is Edit Distance?

Edit distance is a way of quantifying how dissimilar two strings (e.g., words) are to one another by counting the minimum number of operations required to transform one string into the other. The allowed operations are:

1. **Insert** a character
2. **Remove** a character
3. **Replace** a character

The Edit Distance between two strings is the minimum number of these operations required to convert one string into the other.

## Algorithm Approach

The solution is based on **Dynamic Programming**. The key idea is to construct a 2D table `dp` where each entry `dp[i][j]` represents the minimum edit distance between the substrings `str1[0...i-1]` and `str2[0...j-1]`.

### Steps of the algorithm:

1. **Initialization**:  
   - The first row of the table represents converting an empty string to the first string by inserting characters.
   - The first column represents converting the first string to an empty string by deleting characters.

2. **Filling the table**:  
   - For each cell in the table `dp[i][j]`, we consider three possibilities:
     - Insert a character
     - Delete a character
     - Replace a character
   - We take the minimum cost from these three operations plus 1 (if the characters differ) or 0 (if the characters are the same).

3. **Result**:  
   - The final answer will be found in `dp[m][n]`, where `m` and `n` are the lengths of the two strings.
Example
For the input strings "kitten" and "sitting", the output would be:
The Edit Distance between "kitten" and "sitting" is: 3
