package org.uade.structure.implementation;
import org.uade.structure.definition.StackADT;

public class Stack implements StackADT {
    private Node top;
    private int size;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public int getElement() {
        if (isEmpty()) {
            throw new IllegalStateException("La estructura está vacía.");
        }
        return top.value;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }


    @Override
    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La estructura está vacía.");
        }
        top = top.next;
        size--;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}