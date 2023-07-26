/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binary.tree.methods;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {

    public BinaryTreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E content) {
        this.root = new BinaryTreeNode<>(content);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public E getRoot() {
        if (!this.isEmpty()) {
            return root.getContent();
        }
        return null;
    }

    public void setRoot(E content) {
        this.root.setContent(content);
    }

    public BinaryTree<E> getLeft() {
        if (!this.isEmpty()) {
            return root.getLeft();
        }
        return null;
    }

    public BinaryTree<E> getRight() {
        if (!this.isEmpty()) {
            return root.getRight();
        }
        return null;
    }

    public List<E> inOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (!this.isEmpty()) {
            // in order left
            if (this.getLeft() != null) {
                results.addAll(this.getLeft().inOrderTraversal());
            }
            // añadimos la raíz
            results.add(this.root.getContent());
            // in order right    
            if (this.getRight() != null) {
                results.addAll(this.getRight().inOrderTraversal());
            }
        }
        return results;
    }

    public int countLeavesRecursive() {
        int cont = 0;
        if (this.isEmpty()) {
            cont = 0;
        } else if (this.isLeaf()) {
            cont = 1;
        } else {
            if (this.getLeft() != null) {
                cont += this.getLeft().countLeavesRecursive();
            }
            if (this.getRight() != null) {
                cont += this.getRight().countLeavesRecursive();
            }
            return cont;
        }
        return cont;
    }

    public int countLeavesIterative() {
        Stack<BinaryTree<E>> s = new Stack<>();
        int cont = 0;
        s.push(this);
        while (!s.isEmpty()) {
            BinaryTree<E> t = s.pop();
            if (t.isLeaf()) {
                cont++;
            } else {
                if (t.getLeft() != null) {
                    s.push(t.getLeft());
                }
                if (t.getRight() != null) {
                    s.push(t.getRight());
                }
            }
        }
        return cont;
    }

    public boolean isLeaf() {
        if (this.isEmpty()) {
            return false;
        }
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    public boolean setRight(BinaryTree<E> t) {
        if (!this.isEmpty()) {
            this.root.setRight(t);
            return true;
        }
        return false;
    }

    public boolean setLeft(BinaryTree<E> t) {
        if (!this.isEmpty()) {
            this.root.setLeft(t);
            return true;
        }
        return false;
    }

    /*Hay dos maneras de resolver problemas
    iterative or recursive*/
 /*Dependiendo del tipo tendrá el posfijo iterative or recursive */
 /* 1  Implemente el método countDescendants, que cuenta el número de descendientes que
tiene un árbol. Su método no debe contar a la raíz del árbol que lo invoca. Por ejemplo, una
hoja tiene cero descendientes */
    public int countDescendantsIterative() {
        Stack<BinaryTree<E>> s = new Stack<>();

        int contador = 0;

        s.add(this);
        while (!s.isEmpty()) {
            BinaryTree<E> arbolActual = s.pop();

            if (arbolActual.getLeft() != null) {
                contador++;
                s.push(arbolActual.getLeft());

            }
            if (arbolActual.getRight() != null) {
                contador++;
                s.push(arbolActual.getRight());
            }

        }

        return contador;

    }

    public int countDescendantsRecursive() {

        if (this.isLeaf()) {
            return 0;
        }

        int contador = 0;
        if (this.getLeft() != null) {
            contador++;
            contador += this.getLeft().countDescendantsRecursive();
        }
        if (this.getRight() != null) {
            contador++;
            contador += this.getRight().countDescendantsRecursive();
        }
        return contador;
    }

//  2  Implemente el método findParent, que dado un nodo de árbol binario, retorna el padre
//correspondiente. La implementación de su método debe considerar que el nodo raíz no tiene
//un padre
    public void findParentIterative() {

    }

    public BinaryTree<E> findParentRecursive(BinaryTreeNode<E> bn) {

        if (this.getLeft() != null) {
            if (this.getLeft().root != bn) {
                this.getLeft().findParentRecursive(bn);
            } else {
                System.out.println(this);
                System.out.println(bn);
                return this;
            }
        }
        if (this.getRight() != null) {

            if (this.getRight().root != bn) {
                this.getRight().findParentRecursive(bn);
            } else {
                System.out.println(this);
                System.out.println(bn);
                return this;
            }
        }
        return null;
    }

//  3  Implemente el método countLevels que calcule el número de niveles de árbol. Considere
//que un árbol vacío tiene 0 niveles, mientras que un árbol hoja tiene 1 solo nivel.
   public int countLevelsIterative(){
        if(this.isEmpty()){
            return 0;
        }
        if(this.isLeaf()){
            return 1;
        }
        
        
        //MasterPiece by J
        
        Queue<BinaryTree<E>> q = new ArrayDeque<>();
        q.offer(this);
        int nivel = 0;
        while(!q.isEmpty()){
            int cantElements = q.size();
            for(int i = 0;i<cantElements;i++){
                BinaryTree<E> t = q.poll();
                if(t.getLeft() != null){
                    q.offer(t.getLeft());
                }
                if(t.getRight() != null){
                    q.offer(t.getRight());
                }
            }
            nivel++;
        }
        return nivel;
   }

    public int countLevelsRecursive() {
        if (this.isEmpty()) {
            return 0;
        }

        if (this.isLeaf()) {
            return 1;
        }
        int contador1 = 0;
        int contador2 = 0;
        if (this.getLeft() != null) {
            contador1 += this.getLeft().countLevelsRecursive();

        }
        if (this.getRight() != null) {
            contador2 += this.getRight().countLevelsRecursive();

        }
        return Math.max(contador1, contador2)+1;

    }

//   4   Se dice que un árbol binario es zurdo si el árbol: 1) está vacío, 2) es una hoja, o 3) si sus hijos
//son ambos zurdos y tiene a más de la mitad de sus descendientes en el hijo izquierdo.
//Implementar el método isLefty que indique si un árbol binario es zurdo o no.   
    public void isLeftyIterative() {

    }

    public boolean isLeftyRecursive() {
        if(this.isEmpty()){
            return true;
        }if(this.isLeaf()){
            return true;
        }
        
        int izq=0;
        int derecha= 0;
        
        if(this.getLeft()!=null){
            this.isLeftyRecursive();
            izq++;
        }if(this.getRight()!=null){
            this.isLeftyRecursive();
            derecha++;
        }
        
        if(izq>derecha){
            return true;
        }
        
        return false;
        
    }

//    5 Implemente el método isIdentical que, dado un segundo árbol binario, retorne true o
//false indicando si dicho árbol es igual al que invoca el método.
    
    
//  6  Encontrar el valor más grande de cada nivel del árbol. El método largestValueOfEachLevel
//debe imprimir el mayor valor presente en cada nivel de un árbol binario cuyos nodos
//contienen números enteros. Ejemplos:
    
public void largestValueOfEachLevelIterative(){
    if(this.isEmpty()){
        return;
    }
    
    Queue<BinaryTree<E>> q=new ArrayDeque<>();
    
    q.offer(this);
    while(!q.isEmpty()){
        int valorMax=0;
        int tamaño= q.size();
        for(int i=0;i<tamaño;i++){
            BinaryTree<E> at= q.poll();
            Integer contenido= (Integer) at.getRoot();
            if(contenido>valorMax){
                valorMax=contenido;
        }
            if(at.getLeft()!=null){
                q.offer(at.getLeft());
            }if(at.getRight()!=null){
                q.offer(at.getRight());
            }
        }
       System.out.println(valorMax);
    }
}
    
public void largestValueOfEachLevelRecursive(){
    
    
    
    
}
    
    
//  7  El método countNodesWithOnlyChild debe retornar el número de nodos de un árbol que
//tienen un solo hijo. Ejemplo:
    public int countNodesWithOnlyChildRercursive() {
        int contador = 0;

        if (this.isLeaf()) {
            return contador;
        }

        if (this.getLeft() != null && this.getRight() == null) {
            contador++;
        }

        if (this.getRight() != null && this.getLeft() == null) {
            contador++;
        }

        if (this.getLeft() != null) {
            contador += this.getLeft().countNodesWithOnlyChildRercursive();
        }
        if (this.getRight() != null) {
            contador += this.getRight().countNodesWithOnlyChildRercursive();
        }

        return contador;

    }

    public int countNodesWithOnlyChildIterative() {
        Stack<BinaryTree<E>> s = new Stack<>();
        
        s.push(this);
        int contador=0;
        
        while(!s.isEmpty()){
            BinaryTree<E> arbolTemporal=s.pop();
            if(arbolTemporal.getRight()!=null && arbolTemporal.getLeft()==null){
                contador++;
            }
            if(arbolTemporal.getLeft()!=null && arbolTemporal.getRight()==null){
                contador++;
            }
            if(arbolTemporal.getLeft()!=null){
                s.push(arbolTemporal.getLeft());
            }if(arbolTemporal.getRight()!=null){
                s.push(arbolTemporal.getRight());
            }
            
        }
        
        return contador;
    }

//  8  //El método isHeightBalanced debe retornar si un árbol binario está balanceado en altura o
// no. Un árbol vacío está siempre balanceado en altura. Un árbol binario no vacío está
//balanceado si y solo si:
//      1) Su subárbol izquierdo está balanceado,
//      2) Su subárbol derecho está balanceado, y
//      3) La diferencia entre las alturas de sus subárboles izquierdo y derecho es menor que 1.
//El siguiente diagrama muestra dos árboles, uno de ellos está balanceado en altura y el otro
//no. El segundo árbol no está balanceado en altura porque la altura de su subárbol izquierdo
//es mayor en 2 unidades que la altura de su subárbol derecho:
}
