package edu.ensign.cs335.structure.list;

/**
 * Interface for a SinglyLinkedList.  The assignment is to create a class that
 * implements all the methods found in this interface.
 * @param <T>
 */
public interface SinglyLinkedList<T> {

    /**
     * Adds a new data element to as the tail of the SinglyLinkedList.
     * @param data
     */
    void append(T data);

    /**
     * Returns the current size of the size of the SinglyLinkedList (includes both null and non-null node values)
     * "size" is defined as how many elements can be populated into this implementation.
     * @return
     */
    int getSize();

    /**
     * Returns the current number of non-null Nodes in the list.
     * @return
     */
    int getCount();

    /**
     * Returns if the SinglyLinkedList contains zero Nodes instances.
     * @return
     */
    boolean isEmpty();

    /**
     * Inserts the data into a Node at the tail.
     * @param data
     */
    void insert(T data);

    /**
     * Inserts the data element at the position defined.
     * @param data The data element T to be inserted.
     * @param index The position where to insert the data element.
     */
    void insertNth(T data, int index);

    /**
     * Inserts the data element at the head position.
     * @param data The data element T to insert.
     */
    void insertHead(T data);

    /**
     * Returns true if the data structure is found, else false.
     * @param data The data element to find in a given node.
     * @return true if the T is found, else false.
     */
    boolean search(T data);

    /**
     * Returns the value (T) found at defined index.  Returns null if no value found or index outside of size.
     * @param index The index of the desired value.
     * @return The value of T contained in the Node at the given index.  Null if value not found or index out of current size.
     */
    T getNth(int index);

    /**
     * Deletes the tail element
     * @return boolean value true if successful, else false.
     */
    boolean delete();

    /**
     * Deletes the element found at the head of the SinglyLinkedList.
     * @return true if element was successfully deleted, else false.
     */
    boolean deleteHead();

    /**
     * Deletes the value T found at defined index.
     * @param index The integer index of the value to delete.
     * @return Returns true if element successfully deleted, else false.
     */
    boolean deleteNth(int index);


    String toString();

    void clear();
}