/**
 * @author Luke Walters
 *         Truncates a given textblock at the given length
 */

public class Truncated implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The TextBlock to be truncated
   */
  TextBlock bloc;

  /**
   * The width at which the block will be truncated
   */
  int truncWidth;

  // +-------------+-----------------------------------------------------------
  // | Constructor |
  // +-------------+

  /**
   * Creates a Trucanted object with input TextBlock block and int w
   * 
   * @param block - TextBlock
   * @param w     - int
   */
  public Truncated(TextBlock block, int w) {
    if (block == null) {
      this.bloc = new TextLine("");
    } else {

      this.bloc = block;
    }
    this.truncWidth = w;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * Is the row method for Truncated which will truncate each row with the given
   * truncWidth.
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    String result;

    if ((i < 0) || (i >= this.bloc.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    // checks to see if spaces are needed to pad the end
    if (this.bloc.width() < this.truncWidth) {
      String spaces = "";

      for (int j = this.bloc.row(i).length(); j < this.truncWidth; j++) {
        spaces = spaces.concat(" ");
      } // for
      result = this.bloc.row(i);
      result = result.concat(spaces);
      return result;

    } else {
      // truncates the TextBlock
      result = this.bloc.row(i).substring(0, this.truncWidth);
      return result;

    } // else
  }// row

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
    return this.truncWidth;
  }// width()

  /**
   * Determines if this object and another are equal in composition
   */
  public boolean eqv(TextBlock tbCmp) {

    if (!(tbCmp instanceof Truncated)) {
      return false;
    } else {
      Truncated tbCmpTR = (Truncated) tbCmp;
      return this.bloc.eqv(tbCmpTR.bloc);
    } // else
  }// eqv

}// Truncated