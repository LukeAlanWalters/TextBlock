/**
 * @author Luke Walters
 *         Flips all of the text in a block horizontally
 */

public class HorizontallyFlipped implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The TexBlock to be Horizontally Flipped
   */
  TextBlock bloc;

  // +-------------+-----------------------------------------------------------
  // | Constructor |
  // +-------------+

  /**
   * Creates a new block which flips all of the text in a block horizontally
   * 
   * @param block - TextBlock
   */
  public HorizontallyFlipped(TextBlock block) {
    if (block == null) {
      this.bloc = new TextLine("");
    } else {

      this.bloc = block;
    }
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * Flips all of the text in each row
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {

    int h = this.bloc.height();

    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result = "";
    for (int j = (this.bloc.width() - 1); j >= 0; j--) {
      result = result.concat("" + this.bloc.row(i).charAt(j));
    } // for
    return result;
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
    return this.bloc.width();
  }// width()

  public boolean eqv(TextBlock tbCmp) {

    if (!(tbCmp instanceof HorizontallyFlipped)) {
      return false;
    } else {
      HorizontallyFlipped tbCmpHF = (HorizontallyFlipped) tbCmp;
      return this.bloc.eqv(tbCmpHF.bloc);
    } // else
  }// eqv

}// HorizontallyFlipped
