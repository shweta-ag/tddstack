/**
 * Created by alpha on 24/06/2015.
 */

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class StackTest {
 private Stack stack;

    @Before
    public void setUp(){
        stack = new Stack();
    }

    @Test
    public void newStack_isEmpty() throws Exception {

        assertTrue(stack.isEmpty());
    }

    @Test
    public void afterOnePush_isNotEmpty() throws Exception {

        stack.push(0);
        assertFalse(stack.isEmpty());
    }


    @Test(expected=Stack.Underflow.class)
    public void popEmptyStack_throwUnderflow() throws Exception {
        stack.pop();

    }

    @Test
    public void afterPushingX_willPopX() throws Exception{
        stack.push(99);
        assertEquals(99 , stack.pop());
        stack.push(88);
        assertEquals(88,stack.pop());

    }

    @Test
    public void afterOnePushAndOnePop_shouldBeEmpty() throws Exception{

    }

    @Test
    public void afterPushingXandY_willPopY(){
        stack.push(99);
        stack.push(88);
        Assert.assertEquals(88,stack.pop());
    }
}
