package com.ruoyi.web.list.guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Shorts;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/5 12:37
 */
public class GuavaJoinTester {
    public static void main(String args[]) {


    }

    @Test
    public void testJoin() {
        GuavaJoinTester tester = new GuavaJoinTester();
        tester.testJoiner();
    }

    @Test
    public void testSplit() {
        GuavaJoinTester tester = new GuavaJoinTester();
        tester.testSplitter();
    }

    @Test
    public void testCharMatch() {
        GuavaJoinTester tester = new GuavaJoinTester();
        tester.testCharMatcher();
    }

    @Test
    public void testCaseFormater() {
        GuavaJoinTester tester = new GuavaJoinTester();
        tester.testCaseFormat();
    }

    @Test
    public void testToBytes() {
        GuavaJoinTester tester = new GuavaJoinTester();
        tester.testBytes();
    }

    @Test
    public void testToShorts() {
        GuavaJoinTester tester = new GuavaJoinTester();
        tester.testShorts();
    }

    private void testJoiner() {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
    }

    private void testSplitter() {
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, ,brown, fox, jumps, over, the, lazy, little dog."));
    }

    private void testCharMatcher() {
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123"));    // only the digits
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("     Mahesh     Parashar ", ' '));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh123", "*"));  // star out all digits
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("mahesh123"));
        // eliminate all characters that aren't digits or lowercase
    }

    private void testCaseFormat() {
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }

    private void testBytes() {
        byte[] byteArray = {1, 2, 3, 4, 5, 5, 7, 9, 9};
        //convert array of primitives to array of objects
        List<Byte> objectArray = Bytes.asList(byteArray);
        System.out.println(objectArray.toString());
        //convert array of objects to array of primitives
        byteArray = Bytes.toArray(objectArray);
        System.out.print("[ ");
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
        System.out.println("]");
        byte data = 5;
        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Bytes.contains(byteArray, data));
        //Returns the index
        System.out.println("Index of 5: " + Bytes.indexOf(byteArray, data));
        //Returns the last index maximum
        System.out.println("Last index of 5: " + Bytes.lastIndexOf(byteArray, data));
    }

    private void testShorts() {
        short[] shortArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //convert array of primitives to array of objects
        List<Short> objectArray = Shorts.asList(shortArray);
        System.out.println(objectArray.toString());
        //convert array of objects to array of primitives
        shortArray = Shorts.toArray(objectArray);
        System.out.print("[ ");
        for (int i = 0; i < shortArray.length; i++) {
            System.out.print(shortArray[i] + " ");
        }
        System.out.println("]");
        short data = 5;
        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Shorts.contains(shortArray, data));
        //Returns the minimum
        System.out.println("Min: " + Shorts.min(shortArray));
        //Returns the maximum
        System.out.println("Max: " + Shorts.max(shortArray));
        data = 2400;
        //get the byte array from an integer
        byte[] byteArray = Shorts.toByteArray(data);
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
    }
}
