//Author Luke Walters 
//Tests for the textblock type

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TextBlockTests {

    TextBlock hello = new TextLine("Hello");

    BoxedBlock boxedHello = new BoxedBlock(hello);

    Truncated truncatedBoxedHello = new Truncated(boxedHello, 3);

    Truncated truncatedPastBoxedHello = new Truncated(boxedHello, 15);

    Truncated truncatedDownZero = new Truncated(boxedHello, 0);

    Centered centeredBoxedHello = new Centered(boxedHello, 11);

    Centered centeredCutBoxedHello = new Centered(boxedHello, 3);

    RightJustified rJustifiedBoxedHello = new RightJustified(boxedHello, 10);

    RightJustified rJustifiedCutBoxedHello = new RightJustified(boxedHello, 3);

    BlockOnes onesCenteredBoxedHello = new BlockOnes(centeredBoxedHello);

    VerticallyFlipped vFlippedHelloandBoxedHello = new VerticallyFlipped(hello, boxedHello);

    HorizontallyFlipped hFlippedHelloandBoxedHello = new HorizontallyFlipped(hello, boxedHello);

    //test blocks for equals
    Truncated truncOnce = new Truncated(boxedHello, 4);
    Truncated truncTwice = new Truncated(truncOnce, 3);

    //Tests for eqv()
    Truncated eqvt1 = new Truncated(new BoxedBlock(new TextLine("Hello")), 3);
    Truncated eqvt2 = new Truncated(new BoxedBlock(new TextLine("Hello")), 3);
    VerticallyFlipped eqvt3 = new VerticallyFlipped(eqvt1, eqvt2);
    VerticallyFlipped eqvt4 = new VerticallyFlipped(eqvt1, eqvt2);



    @Test
    void basicBoxWidthTest(){
        assertEquals(hello.width(), 5);
    }
    
    @Test
    void basicBoxTextCheck() throws Exception{
        assertEquals(hello.row(0), "Hello");
    }

    //intentionally fails in order to show functionality
    @Test
    void basicBoxTextCheckCase() throws Exception{
        assertEquals(hello.row(0), "hello");
    }
    

    @Test
    void basicBoxHeightTest(){
        assertEquals(hello.height(), 1);
    }

    @Test
    void boxedHelloHeight(){
        assertEquals(boxedHello.height(), 3);
    }

    @Test
    void boxedHelloWidthTest(){
        assertEquals(boxedHello.width(), 7);
    }

    @Test
    void boxedBlockTextCheck() throws Exception{
        assertEquals(boxedHello.row(1), "|Hello|");
        assertEquals(boxedHello.row(0), "+-----+");
        assertEquals(boxedHello.row(2), "+-----+");
    }   

    @Test
    void truncatedBlockWidthCheck(){
        assertEquals(truncatedBoxedHello.width(), 3);
    }

    @Test
    void truncatedBlockHeightCheck(){
        assertEquals(truncatedBoxedHello.height(), 3);
    }

    @Test
    void truncatedBlockTextCheck() throws Exception{
        assertEquals(truncatedBoxedHello.row(1), "|He");
        assertEquals(truncatedBoxedHello.row(0), "+--");
        assertEquals(truncatedBoxedHello.row(2), "+--");
    }
    
    @Test
    void truncatedPastBlockWidthCheck(){
        assertEquals(truncatedPastBoxedHello.width(), 15);
    }

    @Test
    void centeredBoxedHelloWidth(){
        assertEquals(centeredBoxedHello.width(), 11);
    }

    @Test 
    void centeredBoxedHelloText() throws Exception{
        assertEquals(centeredBoxedHello.row(1), "  |Hello|  ");
        assertEquals(centeredBoxedHello.row(0), "  +-----+  ");
        assertEquals(centeredBoxedHello.row(2), "  +-----+  ");
    }

    @Test
    void centeredCutBoxedHelloWidth(){
        assertEquals(centeredCutBoxedHello.width(), 3);
    }


    @Test 
    void centeredCutBoxedHelloText() throws Exception{
        assertEquals(centeredCutBoxedHello.row(1), "ell");
        assertEquals(centeredCutBoxedHello.row(0), "---");
        assertEquals(centeredCutBoxedHello.row(2), "---");
    }

    @Test
    void rightJustifiedBoxedHelloWidth(){
        assertEquals(rJustifiedBoxedHello.width(), 10);
    }

    @Test
    void RightJustifiedBoxedHelloTextCheck() throws Exception{
        assertEquals(rJustifiedBoxedHello.row(1), "   |Hello|");
        assertEquals(rJustifiedBoxedHello.row(0), "   +-----+");
        assertEquals(rJustifiedBoxedHello.row(2), "   +-----+");
    }   

    @Test
    void rightJustifiedCutBoxedHelloWidth(){
        assertEquals(rJustifiedCutBoxedHello.width(), 3);
    }

    @Test
    void rightJustifiedCutBoxedHelloTextCheck() throws Exception{
        assertEquals(rJustifiedCutBoxedHello.row(1), "lo|");
        assertEquals(rJustifiedCutBoxedHello.row(0), "--+");
        assertEquals(rJustifiedCutBoxedHello.row(2), "--+");
    }

      @Test
    void truncatedDownZeroWidth(){
        assertEquals(truncatedDownZero.width(), 0);
    }


    @Test
    void truncatedDownZeroTextCheck() throws Exception{
        assertEquals(truncatedDownZero.row(1), "");
        assertEquals(truncatedDownZero.row(0), "");
        assertEquals(truncatedDownZero.row(2), "");
    }

    @Test
    void onesCenteredBoxedHelloWidth(){
        assertEquals(onesCenteredBoxedHello.width(), centeredBoxedHello.width());
    }

    @Test
    void onesCenteredBoxedHelloTextCheck() throws Exception{
        assertEquals(onesCenteredBoxedHello.row(1), "00111111100");
        assertEquals(onesCenteredBoxedHello.row(0), "00111111100");
        assertEquals(onesCenteredBoxedHello.row(2), "00111111100");
    }

    @Test
    void verticallyFlippedHeight(){
        assertEquals(vFlippedHelloandBoxedHello.height(), 4);
    }

    @Test
    void VerticallyFlippedTextCheck() throws Exception{
        assertEquals(vFlippedHelloandBoxedHello.row(1), "|Hello|");
        assertEquals(vFlippedHelloandBoxedHello.row(0), "+-----+");
        assertEquals(vFlippedHelloandBoxedHello.row(2), "+-----+");
        assertEquals(vFlippedHelloandBoxedHello.row(3), "Hello  ");
    }   


    @Test
    void HorizontallyFlippedWidth(){
        assertEquals(hFlippedHelloandBoxedHello.width(), 12);
    }

    @Test
    void HorizontallyFlippedTextCheck() throws Exception{
        assertEquals(hFlippedHelloandBoxedHello.row(1), "|Hello|     ");
        assertEquals(hFlippedHelloandBoxedHello.row(0), "+-----+Hello");
        assertEquals(hFlippedHelloandBoxedHello.row(2), "+-----+     ");
        
    }   

    @Test
    void equalsTestHello() throws Exception{
        assertEquals(TBUtils.equals(hello, hello), true);
    }

    @Test
    void equalsTestBoxedHello() throws Exception{
        assertEquals(TBUtils.equals(boxedHello, boxedHello), true);
    }

    @Test
    void equalsDoesNotCareConstruction() throws Exception{
        assertEquals(TBUtils.equals(truncTwice, truncatedBoxedHello), true);
    }

    @Test
    void eqTestBoxedHello() throws Exception{
        assertEquals(TBUtils.eq(boxedHello, boxedHello), true);
    }

    //Intentionally Fails to show that it cares about memory location not contents
    @Test
    void eqDoesNotCareConstruction() throws Exception{
        assertEquals(TBUtils.eq(truncTwice, truncatedBoxedHello), false);
    }

    @Test
    void eqvSameConstruction() throws Exception{
        assertEquals(eqvt1.eqv(eqvt2), true);
    }

    @Test
    void eqvDifferentConstruction() throws Exception{
        assertEquals(eqvt1.eqv(truncTwice), false);
    }

    @Test
    void eqvWorksForVF(){
        assertEquals(eqvt3.eqv(eqvt4), true);
    }

    

}
