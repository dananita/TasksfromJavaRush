package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    Entry <String> root  = new Entry<>("0");


    static class Entry<T> implements Serializable{
        String  elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;




        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }


        void checkChildren(){
            if(leftChild!=null){
                availableToAddLeftChildren = false;
            }
            if(rightChild!= null){
                availableToAddRightChildren = false;
            }
        }

        boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren||availableToAddRightChildren;
        }

    }


    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Size: Expected 15,actual is "+list.size());
        System.out.println("Parent: Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        System.out.println("Parent: Expected 1, actual is " + ((CustomTree) list).getParent("3"));
        System.out.println("Parent: Expected 7, actual is " + ((CustomTree) list).getParent("15"));
       // list.remove("15");
        System.out.println("Size: Expected 14, actual is " + list.size());
        System.out.println("Parent: Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public boolean add(String s){
        boolean result = false;

        if(s != null) {
            Entry<String> rootElement = new Entry<>(s);
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.add(root);
            boolean isOperationAdd = true;


            while (isOperationAdd && !queue.isEmpty()) {
                Entry<String> currentElement = queue.remove();

                if(!currentElement.availableToAddLeftChildren&& currentElement.leftChild!=null){
                    queue.add(currentElement.leftChild);
                } else {
                    if (isOperationAdd && currentElement.availableToAddLeftChildren){
                        rootElement.parent= currentElement;
                        currentElement.leftChild = rootElement;
                        isOperationAdd = false;
                        currentElement.checkChildren();
                    }
                }

                if(!currentElement.availableToAddRightChildren&& currentElement.rightChild!=null){
                    queue.add(currentElement.rightChild);
                } else {
                    if (isOperationAdd && currentElement.availableToAddRightChildren){
                        rootElement.parent= currentElement;
                        currentElement.rightChild = rootElement;
                        isOperationAdd = false;
                        currentElement.checkChildren();
                    }
                }
            }
        }
        return result;
    }

    public String getParent(String s){
        String parentName = null;
        if(root!=null||s!=null||!s.equals(root.elementName)){
            Entry <String> rootElement = new Entry<>(s);
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.offer(root);

            while(parentName==null && !queue.isEmpty()){
                Entry<String> currentElement = queue.remove();
                if(currentElement.leftChild != null){
                    if (!currentElement.leftChild.elementName.equals(s)){
                        queue.add(currentElement.leftChild);
                    } else {
                        parentName = currentElement.elementName;
                    }
                }
                if(currentElement.rightChild != null){
                    if (!currentElement.rightChild.elementName.equals(s)){
                        queue.add(currentElement.rightChild);
                    } else {
                        parentName = currentElement.elementName;
                    }
                }
            }
        }
        return parentName;
    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        int count = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild != null) {
                count++;
                queue.add(currentEntry.rightChild);
            }
            if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild != null) {
                count++;
                queue.add(currentEntry.leftChild);
            }
        }
        return count;
    }

    @Override
    public String get(int index) {
        //return null;
        throw new UnsupportedOperationException();
    }


    public String set(int index, String element) {
        //return super.set(index, element);
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        //super.add(index, element);
        throw new UnsupportedOperationException();
    }

    public  void remove(String s){
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        boolean isOperationRemove = false;
        while (!isOperationRemove && !queue.isEmpty()) {
            Entry<String> currentElement = queue.remove();
            if (!currentElement.leftChild.elementName.equals(s)) {
                queue.add(currentElement.leftChild);
            } else {
                if (!isOperationRemove) {
                    currentElement.leftChild = null;
                    isOperationRemove = true;
                }
            }
            if (!currentElement.rightChild.elementName.equals(s)) {
                queue.add(currentElement.rightChild);
            } else {
                if (!isOperationRemove) {
                    currentElement.rightChild = null;
                    isOperationRemove = true;
                }
            }
        }
    }

    public boolean remove (Object o){
        throw new UnsupportedOperationException();
    }
    @Override
    public String remove(int index) {
        //return super.remove(index);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        //return super.addAll(index, c);
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        //return super.subList(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
       // super.removeRange(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }
}
