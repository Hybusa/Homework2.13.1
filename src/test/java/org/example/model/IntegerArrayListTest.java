package org.example.model;

import org.example.exception.ElementNotFoundException;
import org.example.exception.MyIndexOutOfBoundsException;
import org.example.exception.NullParamException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayListTest {


    IntegerArrayList integerArrayList = new IntegerArrayList();

    @BeforeEach
    void cleanListBeforeEachTest() {
        integerArrayList = new IntegerArrayList();
    }

    /**
     * Method under test: {@link IntegerArrayList#add(Integer)}
     */

    @Test
    void add_NullParam_ThrowsNullParamException() {
        assertThrows(NullParamException.class, () -> integerArrayList.add(null));
    }

    @Test
    void add_CorrectParams_ReturnsAdded() {

        Integer testInteger = 3;

        assertEquals(testInteger, integerArrayList.add(testInteger));
    }

    @Test
    void add_CorrectParams_ActuallyAdds() {
        Integer testInteger = 3;

        integerArrayList.add(testInteger);

        assertTrue(Arrays.asList(integerArrayList.toArray()).contains(testInteger));
    }

    /**
     * Method under test: {@link IntegerArrayList#add(int, Integer)}
     */
    @Test
    void indexAdd_NullParam_ThrowsNullParamException() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        int indexUnderTest = 5;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(NullParamException.class, () -> integerArrayList.add(indexUnderTest, null));
    }

    @Test
    void indexAdd_ArrayIsEmpty_ThrowIndexOutOfBoundsException() {
        int indexUnderTest = 5;

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.add(indexUnderTest, 8));
    }

    @Test
    void indexAdd_IndexOutOfBounds_ThrowIndexOutOfBoundsException() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        int indexUnderTest = 5;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.add(indexUnderTest, 8));
    }

    @Test
    void indexAdd_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(expectedInteger, integerArrayList.add(indexUnderTest, expectedInteger));
    }

    @Test
    void indexAdd_CorrectParams_AddedCorrectly() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(indexUnderTest, expectedInteger);

        Integer[] testArray = integerArrayList.toArray();

        assertEquals(expectedInteger, testArray[indexUnderTest]);
    }


    /**
     * Method under test: {@link IntegerArrayList#set(int, Integer)}
     */
    @Test
    void set_NullParam_ThrowsNullParamException() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        int indexUnderTest = 5;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(NullParamException.class, () -> integerArrayList.set(indexUnderTest, null));
    }

    @Test
    void set_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {

        Integer testInteger = 5;
        int indexUnderTest = 5;

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.set(indexUnderTest, testInteger));
    }

    @Test
    void set_IndexOutOfBounds_ThrowsIndexOutOfBoundsException() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 5;
        int indexUnderTest = 5;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.set(indexUnderTest, integerUnderTest));
    }

    @Test
    void set_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(expectedInteger, integerArrayList.set(indexUnderTest, expectedInteger));
    }

    @Test
    void set_CorrectParams_setCorrectly() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        integerArrayList.set(indexUnderTest, expectedInteger);
        Integer[] testArray = integerArrayList.toArray();

        assertEquals(expectedInteger, testArray[2]);
    }

    /**
     * Method under test: {@link IntegerArrayList#remove(Integer)}
     */
    @Test
    void remove_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
         Integer integerUnderTest = 5;

        assertThrows(ElementNotFoundException.class, () -> integerArrayList.remove(integerUnderTest));
    }

    @Test
    void remove_NonExistentString_ThrowsElementNotFoundException() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 5;


        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(ElementNotFoundException.class, () -> integerArrayList.remove(integerUnderTest));
    }

    @Test
    void remove_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);

        assertEquals(expectedInteger, integerArrayList.remove(expectedInteger));
    }

    @Test
    void remove_CorrectParams_CorrectlyRemoved() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);
        integerArrayList.remove(expectedInteger);
        Integer[] testArray = integerArrayList.toArray();

        assertFalse(Arrays.asList(testArray).contains(expectedInteger));
        assertFalse(Arrays.asList(testArray).contains(null));
    }


    /**
     * Method under test: {@link IntegerArrayList#remove(int)}
     */

    @Test
    void indexRemove_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
        int indexUnderTest = 3;

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.remove(indexUnderTest));
    }

    @Test
    void indexRemove_indexOutOfBounds_ThrowsIndexOutOfBoundsException() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        int indexUnderTest = 5;


        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.remove(indexUnderTest));
    }

    @Test
    void indexRemove_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);

        assertEquals(expectedInteger, integerArrayList.remove(indexUnderTest));
    }

    @Test
    void indexRemove_CorrectParams_CorrectlyRemoved() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);
        integerArrayList.remove(indexUnderTest);
        Integer[] testArray = integerArrayList.toArray();

        assertFalse(Arrays.asList(testArray).contains(expectedInteger));
        assertFalse(Arrays.asList(testArray).contains(null));
    }

    /**
     * Method under test: {@link IntegerArrayList#contains(Integer)}
     */
    @Test
    void contains_arrayIsEmpty_ReturnsFalse() {
        Integer integerUnderTest = 8;
        assertFalse(integerArrayList.contains(integerUnderTest));
    }

    @Test
    void remove_StringNonExistent_ReturnsFalse() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;


        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertFalse(integerArrayList.contains(integerUnderTest));
    }

    @Test
    void contains_CorrectParams_ReturnsTrue() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(integerUnderTest);

        assertTrue(integerArrayList.contains(integerUnderTest));
    }

    /**
     * Method under test: {@link IntegerArrayList#indexOf(Integer)}
     */
    @Test
    void indexOf_arrayIsEmpty_ReturnsNegative() {
        Integer integerUnderTest = 8;
        assertEquals(-1, integerArrayList.indexOf(integerUnderTest));
    }

    @Test
    void indexOf_IntegerNonExistent_ReturnsNegative() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(-1, integerArrayList.indexOf(integerUnderTest));
    }

    @Test
    void indexOf_CorrectParams_ReturnsCorrectIndex() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(integerUnderTest);

        assertEquals(indexUnderTest, integerArrayList.indexOf(integerUnderTest));
    }

    /**
     * Method under test: {@link IntegerArrayList#lastIndexOf(Integer)}
     */
    @Test
    void lastIndexOf_arrayIsEmpty_ReturnsNegative() {
        Integer integerUnderTest = 5;
        assertEquals(-1, integerArrayList.lastIndexOf(integerUnderTest));
    }

    @Test
    void lastIndexOf_StringNonExistent_ReturnsNegative() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;


        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(-1, integerArrayList.lastIndexOf(integerUnderTest));
    }

    @Test
    void lastIndexOf_CorrectParams_ReturnsCorrectIndex() {

        Integer testInteger = 2;
        Integer testInteger1 =3;
        Integer testInteger2 =2;
        Integer integerUnderTest = 2;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(integerUnderTest);

        assertEquals(indexUnderTest, integerArrayList.lastIndexOf(integerUnderTest));
    }


    /**
     * Method under test: {@link IntegerArrayList#get(int)}
     */
    @Test
    void get_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
        int indexUnderTest = 3;

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.get(indexUnderTest));
    }

    @Test
    void get_indexOutOfBounds_ThrowsIndexOutOfBoundsException() {

        Integer testInteger = 0;
        Integer testInteger1 =1;
        Integer testInteger2 =2;
        int indexUnderTest = 5;


       integerArrayList.add(testInteger);
       integerArrayList.add(testInteger1);
       integerArrayList.add(testInteger2);

        assertThrows(MyIndexOutOfBoundsException.class, () -> integerArrayList.get(indexUnderTest));
    }

    @Test
    void get_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 =1;
        Integer testInteger2 =2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);

        assertEquals(expectedInteger, integerArrayList.get(indexUnderTest));
    }

    /**
     * Method under test: {@link IntegerArrayList#equals(IntegerArrayList)}
     */
    @Test
    void equals_NullParam_ThrowsNullParamException() {
        assertThrows(NullParamException.class, () -> integerArrayList.equals(null));
    }

    @Test
    void equals_EmptyList_ReturnsFalse() {

        IntegerArrayList testIntegerArrayList = new IntegerArrayList();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;

        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);

        assertFalse(integerArrayList.equals(testIntegerArrayList));
    }

    @Test
    void equals_NonMatchingLists_ReturnsFalse() {

        IntegerArrayList testIntegerArrayList = new IntegerArrayList();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;


        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);
        integerArrayList.add(testInteger2);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger);

        assertFalse(integerArrayList.equals(testIntegerArrayList));
    }


    @Test
    void equals_MatchingLists_ReturnsTrue() {

        IntegerArrayList testIntegerArrayList = new IntegerArrayList();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;


        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);
        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertTrue(integerArrayList.equals(testIntegerArrayList));
    }

    /**
     * Method under test: {@link IntegerArrayList#size()}
     */
    @Test
    void testSize() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        Integer[] testArray = integerArrayList.toArray();

        assertEquals(3, testArray.length);
    }

    /**
     * Method under test: {@link IntegerArrayList#isEmpty()}
     */
    @Test
    void isEmpty_EmptyList_ReturnsTrue() {
        assertTrue(integerArrayList.isEmpty());
    }
    @Test
    void isEmpty_NonEmptyList_ReturnsFalse(){
        integerArrayList.add(5);
        assertFalse(integerArrayList.isEmpty());
    }

    /**
     * Method under test: {@link IntegerArrayList#clear()}
     */
    @Test
    void testClear() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        Integer[] testArray = integerArrayList.toArray();

        assertTrue(testArray.length != 0);

        integerArrayList.clear();
        testArray = integerArrayList.toArray();

        assertEquals(0, testArray.length);
    }
    /**
     * Method under test: {@link IntegerArrayList#toArray()}
     */
    @Test
    void testToArray() {

        IntegerArrayList testIntegerArrayList = new IntegerArrayList();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;


        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);
        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(Arrays.asList(testIntegerArrayList.toArray()), Arrays.asList(integerArrayList.toArray()));
    }
}

