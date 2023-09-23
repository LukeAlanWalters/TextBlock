

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock hello = new TextLine("Hello");
    BoxedBlock m1 = new BoxedBlock(hello);
    Centered m2 = new Centered(hello, 10);
    boolean myBool = TBUtils.equals(hello, m2);
    Truncated mtrunc = new Truncated(hello, 2);
    Truncated mtrunc2 = new Truncated(hello, 3);
    Truncated mtrunc3 = new Truncated(mtrunc2, 2);
    VerticallyFlipped vf = new VerticallyFlipped(hello, m1);
    pen.println(myBool);
    //TBUtils.print(pen, m1);
    System.out.println(hello.row(0));
    TBUtils.print(pen, m2);
    //RightJustified m3 = new RightJustified(block, 10);
    //TBUtils.print(pen, m3);
    //HorizontallyFlipped m4 = new HorizontallyFlipped(block, m1);
    //TBUtils.print(pen, m4);
    //Truncated my = new Truncated(m1, 20);
    //HComposition hcomp = new HComposition(my, m1);
    //BlockOnes ones = new BlockOnes(my);
    //TBUtils.print(pen, hcomp);
    //TBUtils.print(pen, my);
    //TBUtils.print(pen, ones);
    // Print out the block
    //TBUtils.print(pen, block);
    pen.println(mtrunc.eqv(mtrunc3));
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
