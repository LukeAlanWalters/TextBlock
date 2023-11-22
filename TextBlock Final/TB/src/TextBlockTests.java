//Author Luke Walters 
//Tests for the textblock type

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TextBlockTests {

    TextBlock emptyString = new TextLine("");

    TextBlock basicBlock = new TextLine("Hello");

    BoxedBlock basicBoxed = new BoxedBlock(basicBlock);

    BlockOnes basicOnes = new BlockOnes(basicBoxed);

    Truncated truncatedBoxedHello = new Truncated(basicBoxed, 3);

    Truncated truncatedPastBoxedHello = new Truncated(basicBoxed, 15);

    Truncated truncatedDownZero = new Truncated(basicBoxed, 0);

    Centered centeredBoxedHello = new Centered(basicBoxed, 11);

    Centered centeredCutBoxedHello = new Centered(basicBoxed, 3);

    RightJustified rJustifiedBoxedHello = new RightJustified(basicBoxed, 10);

    RightJustified rJustifiedCutBoxedHello = new RightJustified(basicBoxed, 3);

    BlockOnes onesCenteredBoxedHello = new BlockOnes(centeredBoxedHello);

    VComposition VerticallyComposed = new VComposition(basicBlock, basicBoxed);

    HComposition HorizontallyComposed = new HComposition(basicBoxed, basicBoxed);

    VerticallyFlipped vFlippedHelloandBoxedHello = new VerticallyFlipped(VerticallyComposed);

    HorizontallyFlipped hFlippedHelloandBoxedHello = new HorizontallyFlipped(HorizontallyComposed);

    

    //test blocks for equals
    Truncated truncOnce = new Truncated(basicBoxed, 4);
    Truncated truncTwice = new Truncated(truncOnce, 3);

    //Tests for eqv()
    Truncated eqvt1 = new Truncated(new BoxedBlock(new TextLine("Hello")), 3);
    Truncated eqvt2 = new Truncated(new BoxedBlock(new TextLine("Hello")), 3);

    VerticallyFlipped eqvt3 = new VerticallyFlipped(eqvt2);
    VerticallyFlipped eqvt4 = new VerticallyFlipped(eqvt1);

    



    @Test
    void basicBoxWidthTest(){
        assertEquals(basicBlock.width(), 5);
    }
    
    @Test
    void basicBoxTextCheck() throws Exception{
        assertEquals(basicBlock.row(0), "Hello");
    }

    //intentionally fails in order to show functionality
    @Test
    void basicBoxTextCheckCase() throws Exception{
        assertEquals(basicBlock.row(0), "hello");
    }
    

    @Test
    void basicBoxHeightTest(){
        assertEquals(basicBlock.height(), 1);
    }

    @Test
    void boxedHelloHeight(){
        assertEquals(basicBoxed.height(), 3);
    }

    @Test
    void boxedHelloWidthTest(){
        assertEquals(basicBoxed.width(), 7);
    }

    @Test
    void boxedBlockTextCheck() throws Exception{
        assertEquals(basicBoxed.row(1), "|Hello|");
        assertEquals(basicBoxed.row(0), "+-----+");
        assertEquals(basicBoxed.row(2), "+-----+");
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
        assertEquals(hFlippedHelloandBoxedHello.width(), 14);
    }

    @Test
    void HorizontallyFlippedTextCheck() throws Exception{
        assertEquals(hFlippedHelloandBoxedHello.row(1), "|olleH||olleH|");
        assertEquals(hFlippedHelloandBoxedHello.row(0), "+-----++-----+");
        assertEquals(hFlippedHelloandBoxedHello.row(2), "+-----++-----+");
        
    }   

    @Test
    void equalsTestHello() throws Exception{
        assertEquals(TBUtils.equal(basicBlock, basicBlock), true);
    }

    @Test
    void equalsTestBoxedHello() throws Exception{
        assertEquals(TBUtils.equal(basicBoxed, basicBoxed), true);
    }

    @Test
    void equalsDoesNotCareConstruction() throws Exception{
        assertEquals(TBUtils.equal(truncTwice, truncatedBoxedHello), true);
    }

    @Test
    void eqTestBoxedHello() throws Exception{
        assertEquals(TBUtils.eq(basicBoxed, basicBoxed), true);
    }

    //Intentionally false to show that it cares about memory location not contents
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
    void eqvWorksForVF() {
        assertEquals(eqvt3.eqv(eqvt4), true);
    }

    @Test
    void doubleFlippedVertical() throws Exception{
        VerticallyFlipped secondFlipped = new VerticallyFlipped(vFlippedHelloandBoxedHello);
        assertEquals(TBUtils.equal(secondFlipped, VerticallyComposed), true);
    }


    @Test
    void doubleFlippedHorizontal() throws Exception{
        HorizontallyFlipped secondFlipped = new HorizontallyFlipped(hFlippedHelloandBoxedHello);
        assertEquals(TBUtils.equal(secondFlipped, HorizontallyComposed), true);
    }

    
    @Test
    void doubleCentered() throws Exception{
        Centered doubleCentered = new Centered(centeredBoxedHello, 3);
        assertEquals(TBUtils.equal(centeredCutBoxedHello, doubleCentered), true);
    }

    @Test
    void doubleRightJustified() throws Exception{
        RightJustified doubleRight = new RightJustified(rJustifiedBoxedHello, 3);
         assertEquals(TBUtils.equal(rJustifiedCutBoxedHello, doubleRight), true);
    }

    @Test
    void doubleOnes() throws Exception{
        BlockOnes doubleOnes = new BlockOnes(basicOnes);
        assertEquals(TBUtils.equal(basicOnes, doubleOnes), true);
    }

    @Test
    void emptyStringFlippedVertical() throws Exception{
        VerticallyFlipped emptyStringFlipped = new VerticallyFlipped(emptyString);
        assertEquals(TBUtils.equal(emptyStringFlipped, emptyString), true);
    }


    @Test
    void emptyStringFlippedHorizontal() throws Exception{
        HorizontallyFlipped emptyStringFlipped = new HorizontallyFlipped(emptyString);
        assertEquals(TBUtils.equal(emptyStringFlipped, emptyString), true);
    }

    
    @Test
    void emptyStringCentered() throws Exception{
        Centered emptyStringCentered = new Centered(emptyString, 0);
        assertEquals(TBUtils.equal( emptyStringCentered, emptyString), true);
    }

    @Test
    void emptyStringRightJustified() throws Exception{
        RightJustified emptyStringRight = new RightJustified(emptyString, 0);
         assertEquals(TBUtils.equal(emptyStringRight, emptyString), true);
    }

    @Test
    void emptyStringOnes() throws Exception{
        BlockOnes emptyStringOnes = new BlockOnes(emptyString);
        assertEquals(TBUtils.equal(emptyStringOnes, emptyString), true);
    }

    @Test
    void emptyFlippedVertical() throws Exception{
        VerticallyFlipped emptyFlipped = new VerticallyFlipped(null);
        assertEquals(TBUtils.equal(emptyFlipped, emptyString), true);
    }

    @Test
    void emptyFlippedHorizontal() throws Exception{
        HorizontallyFlipped emptyFlipped = new HorizontallyFlipped(null);
         assertEquals(TBUtils.equal(emptyFlipped, emptyString), true);
    }

    @Test
    void emptyCentered() throws Exception{
        Centered emptyCentered = new Centered(null, 0);
        assertEquals(TBUtils.equal(emptyCentered, emptyString), true);
    }

    @Test
    void emptyRightJustified() throws Exception{
        RightJustified emptyRight = new RightJustified(null, 0);
         assertEquals(TBUtils.equal(emptyRight, emptyString), true);
    }

    @Test
    void emptyOnes() throws Exception{
        BlockOnes emptyOnes = new BlockOnes(null);
        assertEquals(TBUtils.equal(emptyOnes, emptyString), true);
    }





}
