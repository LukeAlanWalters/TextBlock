/**
 * @author Luke Walters
 *         Flips all of the rows from top to bottom
 */

public class VerticallyFlipped implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block to be vertically flipped
   */
  TextBlock bloc;

  // +-------------+-----------------------------------------------------------
  // | Constructor |
  // +-------------+

  /**
   * Creates a TextBlock that is vertically flipped
   * 
   * @param block - TextBlock
   */
  public VerticallyFlipped(TextBlock block) {
    if (block == null) {
      this.bloc = new TextLine("");
    } else {

      this.bloc = block;
    }
  } // VComposition(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * Flips rows with their counterpart
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {

    int numRows = this.bloc.height();

    if (i < 0 || i >= numRows) {
      throw new Exception("Invalid row " + i);
    } // if

    int lastIndex = numRows - 1;

    // Flipping the rows by accessing rows in reverse order
    return this.bloc.row(lastIndex - i);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.bloc.height();
  }// height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.bloc.width();
  }// width()

  /**
   * Determines if this object and another are equal in composition
   */
  public boolean eqv(TextBlock tbCmp) {

    if (!(tbCmp instanceof VerticallyFlipped)) {
      return false;
    } else {
      VerticallyFlipped tbCmpVF = (VerticallyFlipped) tbCmp;
      return this.bloc.eqv(tbCmpVF.bloc);
    } // else
  }// eqv

}// VerticallyFlipped
