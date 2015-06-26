import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

/**
 * Created by alpha on 25/06/2015.
 */
public class WrapExerciseTest {

    private final String LINCOLNS_PHRASE = "Four score and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal";
    WrapExercise  wrapExercise = new WrapExercise();

    @Test
    public void shouldWrapAEmptyString()
    {
        String wrappedString = wrapExercise.wrapString("",7);
        assertThat(wrappedString, is(""));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWrappingLengthZero() throws Exception {
        wrapExercise.wrapString("four",0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWrappingLengthLessThanZero() throws Exception {
        wrapExercise.wrapString("four",-1);
    }

    @Test
    public void shouldWrapAStringLessThanWrappingLength()
    {
        String wrappedString = wrapExercise.wrapString("four",7);
        assertThat(wrappedString, is("four"));

    }

    @Test
    public void shouldWrapAStringLengthSameAsWrappingLength()
    {
        String wrappedString = wrapExercise.wrapString("four",4);
        assertThat(wrappedString, is("four"));

    }



    @Test
    public void shouldSplitAStringOnceWhenMoreThanWrappingLength()
    {
        String wrappedString = wrapExercise.wrapString("four", 3);
        assertThat(wrappedString, is("fou\nr"));

    }

    @Test
    public void shouldSplitAStringMoreThanOnceWhenMoreThanWrappingLength()
    {
        String wrappedString = wrapExercise.wrapString("fourfour", 3);
        assertThat(wrappedString, is("fou\nrfo\nur"));

    }


    @Test
    public void shouldSplitTheWordsWithSpaces()
    {
        String wrappedString = wrapExercise.wrapString("four four four", 4);
        assertThat(wrappedString, is("four\nfour\nfour"));

    }


    @Test
    public void shouldNotSplitTheWordIfSpaceIsInProximity()
    {
        String wrappedString = wrapExercise.wrapString("four four", 6);
        assertThat(wrappedString, is("four\nfour"));
    }

    @Test
    public void testName() throws Exception {
        String wrappedString = wrapExercise.wrapString("four score and", 7);
        assertThat(wrappedString, is("four\nscore\nand"));
    }

    @Test
    public void shouldHandleTheLincolnsPhrase() throws Exception {
        String wrappedString = wrapExercise.wrapString(LINCOLNS_PHRASE, 7);
        assertThat(wrappedString, startsWith("Four\nscore\nand\nseven\nyears\nago our\n"));
        assertThat(wrappedString, containsString("contine\nnt"));
    }
}
