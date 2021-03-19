package com.natescode;

public class Main {

    public static void main(String args[]) {

        // TODO: Create root Tree node instance
        Tree root = new Tree();

        // TODO: base case
        root = ParseTree("4");

        // TODO: single node with leaf nodes
        root = ParseTree("4(2)(6)");

        // TODO: recurse to tree depth :-)
        root = ParseTree("4(2(3)(1))(6(7)(5))");
    }

    public static Tree ParseTree(String text) {
        Tree Node = new Tree();

        // <BASE CASE>: We have but a single number

        // TODO: VALUE
        // Get the Number at the beginning to set the value
        String value = "";
        int index = 0;
        // So while we aren't at the end of the string AND the character isn't our first '('
        // then we known we're reading a number
        while (index < text.length() && text.charAt(index) != '(') {
            value += text.charAt(index);
            index++;
        }
        // set the node value
        Node.SetValue(value);

        // TODO: No left or right nodes
        // if there's no text left then we're done
        if (index == text.length()) {
            Node.Left = null;
            Node.Right = null;
            return Node;
        }

        // </BASE CASE>

        // TODO: LEFT NODE
        // We get the left text that we'll later parse to become a node for the
        // node's left child
        // We already are at the first '(' character. We keep reading until
        // the number of left and right parens are equal
        String leftText = "";
        int lParens = 0;
        int rParens = 0;
        while (lParens != rParens || lParens == 0) {
            char current = text.charAt(index);
            leftText += current;
            // Track left and right parens.
            // once we've counted equal in number then we have the first node ie (2(3)(1)) (6(7)(5))
            if (current == '(') {
                lParens++;
            } else if (current == ')') {
                rParens++;
            }
            index++;
        }
        // TODO: TRIM PARENS (4(3)(2)) => 4(3)(2)
        // The left node will be created based on the left text
        // we call this same function that returns a node
        if (leftText.charAt(0) == '(') {
            leftText = leftText.substring(1, leftText.length() - 1);
        }
        Node.Left = ParseTree(leftText);

        // TODO: RIGHT NODE
        // The rest of the text is automatically the 'Right node'
        // if there is no text left then it is null
        if (index == text.length()) {
            Node.Right = null;
        } else {
            String rightText = text.substring(index);
            if (rightText.charAt(0) == '(') {
                rightText = rightText.substring(1, rightText.length() - 1);
            }
            Node.Right = ParseTree(rightText);
        }
        return Node;
    }
}

/* TODO: Define our Tree node structure */
class Tree {
    // The value "number" we want to store
    // if we wanted to could make this an integer (or float) and do Integer.parseInt() or Float.parseFloat(), respectively
    private String _value = "";
    public Tree Left = null;
    public Tree Right = null;

    public Tree() {

    }

    // Value setter method
    public void SetValue(String value) {
        this._value = value;
    }

}
