/**
 * One line of text.
 * 
 * @author Samuel A. Rebelsky & Luke Walters
 * @version 1.3 of February 2019
 */
public class TextLine implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the line.
   */
  String line;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with the specified contents.
   */
  public TextLine(String line) {
    if (line == null) {
      this.line = "";
    } else {

      this.line = line;
    }
  } // TextLine(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i == 0
   * @exception Exception if i != 0
   */
  public String row(int i) throws Exception {
    if (i != 0) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    return this.line;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 1;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.line.length();
  } // width()

  /**
   * Checks to ensure that two textlines are the same
   */
  public boolean eqv(TextBlock tbCmp) {
    if (tbCmp == null) {
      return false;
    } else if (!(tbCmp instanceof TextLine)) {
      return false;
    } else {
      TextLine tbCmpLine = (TextLine) tbCmp;
      return this.line.equals(tbCmpLine.line);
    } // else

  }// eqv

} // class TextLine
