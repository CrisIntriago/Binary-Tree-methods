/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.binary.tree.methods;

/**
 *
 * @author Administrador
 */
public class BinaryTreeMethods {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree(0);
        tree.setLeft(new BinaryTree(1));
        tree.setRight(new BinaryTree(2));
        tree.getLeft().setLeft(new BinaryTree(3));
        BinaryTree<Integer> bt = new BinaryTree(4);
        tree.getLeft().setRight(bt);
        tree.getRight().setLeft(new BinaryTree(5));
        tree.getRight().setRight(new BinaryTree(6));
        tree.getRight().getRight().setRight(new BinaryTree(7));

        System.out.println("Probando el primer método countDescendants: ");
        System.out.println("Iterativo: ");
        System.out.println(tree.countDescendantsIterative());
        System.out.println("Recursivo: ");
        System.out.println(tree.countDescendantsRecursive());

        System.out.println("Probando el segundo método findParent: ");
        System.out.println("Iterativo: ");
//       //System.out.println(tree.findParentIterative());
        System.out.println("Recursivo: ");
//        System.out.println(tree.findParentRecursive(bt.root));
//        

        System.out.println("Probando el tercer método countLevels: ");
        System.out.println("Iterativo: ");
        System.out.println(tree.countLevelsIterative());
        System.out.println("Recursivo: ");
        System.out.println(tree.countLevelsRecursive());

        System.out.println("Probando el cuarto método isLefty: ");
        System.out.println("Iterativo: ");
        // System.out.println(tree.countLevelsIterative());
        System.out.println("Recursivo: ");
        // System.out.println(tree.countLevelsRecursive());

        System.out.println("Probando el quinto método isIdentical: ");
        System.out.println("Iterativo: ");
        // System.out.println(tree.countLevelsIterative());
        System.out.println("Recursivo: ");
        // System.out.println(tree.countLevelsRecursive());

        System.out.println("Probando el sexto método largestValueOfEachLevel: ");
        System.out.println("Iterativo: ");
        tree.largestValueOfEachLevelIterative();
        System.out.println("Recursivo: ");
        // System.out.println(tree.countLevelsRecursive());

        System.out.println("Probando el séptimo método countNodesWithOnlyChild: ");
        System.out.println("Iterativo: ");
       System.out.println(tree.countNodesWithOnlyChildIterative());
        System.out.println("Recursivo: ");
       System.out.println(tree.countNodesWithOnlyChildRercursive());

        System.out.println("Probando el octavo método isHeightBalanced: ");
        System.out.println("Iterativo: ");
//       System.out.println(tree.countNodesWithOnlyChildIterative());
        System.out.println("Recursivo: ");
//        System.out.println(tree.countNodesWithOnlyChildRercursive());

        System.out.println("Probando el noveno método isBinarySearchTree?");

    }
}
