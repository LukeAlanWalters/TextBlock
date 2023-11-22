/**
 * @author Luke Walters
 * Centers a TextBlock
 */

public class Centered implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block to be centered
   */
  TextBlock bloc;

  /**
   * The Width to be centered upon
   */
  int centWidth;

  // +-------------+-----------------------------------------------------------
  // | Constructor |
  // +-------------+

  /**
   * Creates a centered TextBlock
   * 
   * @param block - TextBlock
   * @param w     - int
   */
  public Centered(TextBlock block, int w) {
    if(block == null){
      this.bloc = new TextLine("");
    } else {

      this.bloc = block;
    }
    this.centWidth = w;

  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    String result = "";
    double holder;
    String spaces = "";

    if ((i < 0) || (i >= this.bloc.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    else if (this.bloc.width() > this.centWidth) {
      holder = this.bloc.width() - this.centWidth;
      double leftRem = Math.ceil(holder / 2.0);
      double rightRem = Math.floor(holder / 2.0);
      result = this.bloc.row(i).substring(0, this.bloc.width() - (int) rightRem);

      result = result.substring((int) leftRem, result.length());
      return result;
    } // else if()
    else {
      // determines how many spaces there will be on both sides
      holder = this.centWidth / 2.0 - this.bloc.width() / 2.0;
      double start = Math.ceil(holder);
      double end = Math.floor(holder);

      // for loops which concat the spaces on both sides
      for (int j = 0; j < (int) start; j++) {
        spaces = spaces.concat(" ");
      } // for
      result = spaces.concat(this.bloc.row(i));
      spaces = "";
      for (int j = 0; j < (int) end; j++) {
        spaces = spaces.concat(" ");
      } // for
      result = result.concat(spaces);
      return result;
    } // else
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.bloc.height();
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.centWidth;
  }

  /**
   * Determines if this object and another are equal in composition
   */
  public boolean eqv(TextBlock tbCmp) {

    if (!(tbCmp instanceof Centered)) {
      return false;
    } else {
      Centered tbCmpCent = (Centered) tbCmp;
      return this.bloc.eqv(tbCmpCent.bloc);
    } // else
  }// eqv

}// Centered
