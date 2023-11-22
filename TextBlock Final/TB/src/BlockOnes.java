/**
 * @author Luke Walters
 *         Makes a textblock of 0 where spaces are and 1's where non-spaces are
 */

public class BlockOnes implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The TextBlock to be converted into zero's and one's
   */
  TextBlock bloc;

  // +-------------+-----------------------------------------------------------
  // | Constructor |
  // +-------------+

  /**
   * Constructs the BlockOnes object
   * 
   * @param block - TexBlock
   */
  public BlockOnes(TextBlock block) {
    if (block == null) {
      this.bloc = new TextLine("");
    } else {

      this.bloc = block;
    }
  }// BlockOnes

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * turns all of the char values in a bloc into 1 and all spaces into 0
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    String result = "";

    if ((i < 0) || (i >= this.bloc.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    for (int j = 0; j < this.bloc.width(); j++) {
      // System.out.println("test 1");
      if (Character.isWhitespace(this.bloc.row(i).charAt(j))) {
        // System.out.println("test 1.1");
        result = result.concat("0");
      } else {
        // System.out.println("test 1.2");
        result = result.concat("1");
      } // else
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

  /**
   * Determines if this object and another are equal in composition
   */
  public boolean eqv(TextBlock tbCmp) {

    if (!(tbCmp instanceof BlockOnes)) {
      return false;
    } else {
      BlockOnes tbCmpBO = (BlockOnes) tbCmp;
      return this.bloc.eqv(tbCmpBO.bloc);
    } // else
  }// eqv
}// BlockOnes
