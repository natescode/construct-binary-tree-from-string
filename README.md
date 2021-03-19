# Construct Binary Tree from String 

This is the solution to the [Leet Code](https://leetcode.com/problems/construct-binary-tree-from-string/) problem, `Construct Binary Tree from String` written in Java.

The code recursively builds a binary tree where the nodes hold number values (as strings).

Like all recursion problems, we need a base case.

The base case for parsing input like `"4(2(3)(1))(6(7)(5))"`
is to create a Tree node from `4` with value `4` and left and right nodes set to `null`.

Outside the base case we need to break down the string to text suitable to be parsed for the left and right nodes (again we want to get to the base case).

## The Algorithm
consider the following input `4(2)(3)`

1) We start by reading all the characters, building the node's value, until the first `(`. We know that's our number.
2) We continue reading the characters while tracking the number of left `(` and right `)` parens.
   Once the number of left and right parens are equal then we have our **left node**.
3) The characters remaining to be read are the **right node**
4) We trim the leading and trailing parens `(` `)` ie. `( 2 (3) (1) )` becomes `2 (3) (1)`
5) Set the Left Node to the result of recursion (call the current function named ParseTree), passing the left node text `Node.Left = ParseTree(leftText);`
6) Set the Right Node to the result of recursion (call the current function named ParseTree), passing the right node text `Node.Right = ParseTree(rightText);`
7) Return the created node