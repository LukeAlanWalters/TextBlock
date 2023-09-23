//Author Luke Walters 
//Holds the utility methods for TextBlock

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.P
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /*public boolean eqv(TextBlock t1, TextBlock t2){
    boolean result;
    if(t1.getClass().equals(t2.getClass())){
      return (true && (eqv(t1.block, t2.block) ));
    }
    else{
      return false;
    }
    

  }*/
  public static boolean equals(TextBlock t1, TextBlock t2) throws Exception{
    if ((t1.width() == t2.width()) && (t1.height() == t2.height())){

      for (int i = 0; i < t1.height(); i++){
        if (!t1.row(i).equals(t2.row(i))){
          return false;
        }
      }
      return true;
    }
    else{
      return false;
    }
  }

  public static boolean eq(TextBlock t1, TextBlock t2) throws Exception{
    if (t1 == t2){
      return true;
    }
    else{
      return false;
    }
  }

} // class TBUtils
