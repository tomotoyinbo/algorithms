package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class StackTest {

    private Stack<String> stack;

    @Before
    public void before(){
        stack = new Stack<>();
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekingAtEmptyStack(){
        stack.peek();
    }

    @Test
    public void testPeekingAtNonEmptyStack(){
        stack.push("a");
        Assert.assertEquals("a", stack.peek());
    }

    @Test
    public void testPush(){
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(0, stack.size());
        stack.push("a");
        Assert.assertEquals(1, stack.size());
        stack.push("b");
        Assert.assertEquals(2, stack.size());
    }

    @Test
    public void testPop(){
        stack.push("a");
        stack.push("b");
        stack.push("c");

        String data = stack.pop();
        Assert.assertEquals("c", data);
        Assert.assertEquals(2, stack.size());
    }
}
