//Author Luke Walters 
//Flips two blocks and hcomposes them

public class HorizontallyFlipped implements TextBlock{

  //The left portion of the composition.
  TextBlock left;


  //The right portion of the composition.
  TextBlock right;


  //Build a new block by composing left and right side by side.
  public HorizontallyFlipped(TextBlock left, TextBlock right) {
    this.left = right;
    this.right = left;
  }


   // Get one row from the block.
   // @pre 0 <= i < this.height()
   // @exception Exception if the precondition is not met
   
  public String row(int i) throws Exception {
    int lh = this.left.height();
    int rh = this.right.height();
    int h = Math.max(lh, rh);

    
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result;
    if (i < lh) {
      result = this.left.row(i);
    } else {
      result = TBUtils.spaces(this.left.width());
    }
    if (i < rh) {
      result = result.concat(this.right.row(i));
    } else {
      result = result.concat(TBUtils.spaces(this.right.width()));
    }

    return result;
  } 

  
  //Determine how many rows are in the block. 
  public int height() {
    return Math.max(this.left.height(), this.right.height());
  } 

  // Determine how many columns are in the block.
  public int width() {
    return this.left.width() + this.right.width();
  }
  
  public boolean eqv(TextBlock tbCmp){

    if(!(tbCmp instanceof HorizontallyFlipped)){
      return false;
    }

    else{
    HorizontallyFlipped tbCmpHF = (HorizontallyFlipped) tbCmp;
    return this.left.eqv(tbCmpHF.left) && this.right.eqv(tbCmpHF.right);
    }
  }

}
