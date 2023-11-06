/*
    Name:           Darin Wilcox
    Class:          CS335 Data Structures and Algorithms

    Description:    SinglyLinkedList driver
*/


package edu.ensign.cs335.structure.list;

/**
 *
 */
public class SinglyLinkedListDriver
{
    private SinglyLinkedList<Integer> linkedList;

    public static void main(String[] args) {
        new SinglyLinkedListDriver();
    }

    private SinglyLinkedListDriver() {
        this.linkedList = new SinglyLinkedListImpl();
        assert linkedList.getSize() == 0 && linkedList.getCount() == 0;
        assert linkedList.isEmpty();

        /// Checking if the insert function works
        linkedList.insertHead(6);
        linkedList.insertHead(8);
        linkedList.insertHead(11);
        linkedList.insert(4);
        linkedList.insertNth(1, 4);

        /// Use toString() to show all the elements.
        System.out.println(linkedList);
        System.out.println("size: " + linkedList.getSize());
        System.out.println("count: " + linkedList.getCount());
        System.out.println("");

        /// Testing searches
        assert linkedList.search(11) &&
                linkedList.search(6)  &&
                linkedList.search(1)  &&
               !linkedList.search(1000);

        /// Testing gets
        assert linkedList.getNth(0) == 11 &&
                linkedList.getNth(2) == 6  &&
                linkedList.getNth(4) == 1;

        /// Testing deletion
        linkedList.deleteHead();
        linkedList.deleteNth(1);
        linkedList.delete();
        /// Use toString() to show all the elements.
        System.out.println(linkedList);
        System.out.println("");
        System.out.println("size: " + linkedList.getSize());
        System.out.println("count: " + linkedList.getCount());

        ///
        linkedList.clear();
        assert linkedList.isEmpty();
    }
}