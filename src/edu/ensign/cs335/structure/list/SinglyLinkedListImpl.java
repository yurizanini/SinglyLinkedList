package edu.ensign.cs335.structure.list;

public class SinglyLinkedListImpl<T> implements SinglyLinkedList<T>{
    private Node<T> head; // The head of the linked list

    public SinglyLinkedListImpl() {
        head = null;
    }

    @Override
    public void append(T data) {
        Node<T> newNode = new Node<>(data);

        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse the list to the last node
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // Attach the new node to the last node
            current.setNext(newNode);
        }
    }

    @Override
    public int getSize() {
        int size = 0;
        Node<T> current = head;

        while (current != null){
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public int getCount() {
        int count = 0;
        Node<T> current = head;

        while(current != null){
            if(current.getData() != null){
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;

            // Traverse the list to the last node
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // Set the next reference of the last node to the new node
            current.setNext(newNode);
        }
    }

    @Override
    public void insertNth(T data, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index is out of range.");
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            // Insert at the beginning
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            int currentIndex = 0;

            while (current != null && currentIndex < index - 1) {
                current = current.getNext();
                currentIndex++;
            }
            if (current == null) {
                throw new IllegalArgumentException("Index is out of range.");
            } else {
                // Insert the new node at the specified index
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            }
        }
    }

    @Override
    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);

        // Update the head to point to the new node
        newNode.setNext(head);
        head = newNode;

    }

    @Override
    public boolean search(T data) {
        Node<T> current = head;

        while (current != null) {
            if (data.equals(current.getData())) {
                // Data found in a node
                return true;
            }
            current = current.getNext();
        }

        // Data not found in the list
        return false;
    }

    @Override
    public T getNth(int index) {
        Node<T> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {//<=?
            current = current.getNext();
            currentIndex++;
        }

        if (current != null) {
            return current.getData(); // Return the data at the specified index
        } else {
            return null; // Index is out of range, return null
        }
    }

    @Override
    public boolean delete() {
        if (head == null) {
            return false; // The list is empty, nothing to delete
        }

        if (head.getNext() == null) {
            // If there is only one node in the list, set head to null
            head = null;
        } else {
            Node<T> current = head;

            // Traverse the list to find the second-to-last node
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }

            // Update the next reference of the second-to-last node to remove the last node
            current.setNext(null);
        }

        return true; // Successfully deleted the tail element
    }

    @Override
    public boolean deleteHead() {
        if (head == null) {
            return false; // The list is empty, nothing to delete
        }

        // Update the head to point to the next node
        head = head.getNext();
        return true; // Successfully deleted the element at the head
    }

    @Override
    public boolean deleteNth(int index) {
        if (index < 0) {
            return false; // Index is negative, return false
        }

        if (index == 0) {
            // If the index is 0, update head to remove the first element
            if (head != null) {
                head = head.getNext();
                return true; // Successfully deleted the element at index 0
            } else {
                return false; // List is empty, nothing to delete
            }
        } else {
            Node<T> current = head;
            int currentIndex = 0;

            while (current != null && currentIndex < index - 1) {
                current = current.getNext();
                currentIndex++;
            }

            if (current != null && current.getNext() != null) {
                // Update the next reference of the preceding node to skip the node to be deleted
                current.setNext(current.getNext().getNext());
                return true; // Successfully deleted the element at the specified index
            } else {
                return false; // Index is out of range or list is empty, return false
            }
        }
    }

    public String toString() {
        Node<T> tmp = head;
        String cont = "";
        while(tmp.getNext()!=null) {
            cont=cont+tmp.getData()+" -> ";
            tmp=tmp.getNext();
        }
        cont=cont+tmp.getData();
        return cont;
    }

    @Override
    public void clear() {
        head = null;
    }
}
