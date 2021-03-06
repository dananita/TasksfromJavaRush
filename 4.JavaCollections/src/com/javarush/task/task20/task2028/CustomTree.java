package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("0");

    static class Entry<T> implements Serializable {

        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    } // End of Entry class


    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        list.remove("5");
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            currentNode.checkChildren();
            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren) {
                    currentNode.leftChild = new Entry<>(s);
                    currentNode.leftChild.parent = currentNode;
                    return true;
                } else if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = new Entry<>(s);
                    currentNode.rightChild.parent = currentNode;
                    return true;
                }
            } else {
                if (currentNode.leftChild != null) {
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    queue.offer(currentNode.rightChild);
                }
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {

        int size = -1;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            size++;
            if (currentNode.leftChild != null) {
                queue.offer(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                queue.offer(currentNode.rightChild);
            }
        }
        return size;
    }

    @Override
    public boolean remove(Object o) {
        //Это надо делать когда очередь окажется пустой
        // и ни одного подходящего элемента, к которому
        // надо добавить новый элемент мы не нашли (он будет = null).
        // Еще раз обходим дерево и вызываем правильный метод из Entry.
        try {
            String s = (String) o;
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Entry<String> currentNode = queue.poll();
                if (currentNode.leftChild != null) {
                    if (currentNode.leftChild.elementName.equals(s)) {
                        currentNode.leftChild = null;
                        return true;
                    }
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    if (currentNode.rightChild.elementName.equals(s)) {
                        currentNode.rightChild = null;
                        return true;
                    }
                    queue.offer(currentNode.rightChild);
                }
            }

        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
        return false;
    }

    public String getParent(String s) {
        String parentName = null;
        if (root != null || s != null || !s.equals(root.elementName)) {
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.offer(root);

            while (parentName == null && !queue.isEmpty()) {
                Entry<String> currentElement = queue.remove();
                if (currentElement.leftChild != null) {
                    if (!currentElement.leftChild.elementName.equals(s)) {
                        queue.add(currentElement.leftChild);
                    } else {
                        parentName = currentElement.elementName;
                    }
                }
                if (currentElement.rightChild != null) {
                    if (!currentElement.rightChild.elementName.equals(s)) {
                        queue.add(currentElement.rightChild);
                    } else {
                        parentName = currentElement.elementName;
                    }
                }
            }
        }
        return parentName;
    }
}