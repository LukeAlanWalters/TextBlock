//Author Luke Walters 
//A verticall compistion where the top and bottom items are switched

public class VerticallyFlipped implements TextBlock{
    


   //The top portion of the composition.
  TextBlock top;

  
  //The bottom portion of the composition.
  TextBlock bottom;

//Constructor
  public VerticallyFlipped(TextBlock top, TextBlock bottom) {
    this.top = bottom;
    this.bottom = top;
  } // VComposition(String)


  
   // Get one row from the block.
   // 
   // @pre 0 <= i < this.height()
   // @exception Exception if the precondition is not met
   
  public String row(int i) throws Exception {
    // Gather some basic information
    int th = this.top.height();
    int bh = this.bottom.height();
    int tw = this.top.width();
    int bw = this.bottom.width();
    int h = th + bh;

    // Determine padding
    String padtop = "";
    String padbot = "";
    if (tw > bw) {
      padbot = TBUtils.spaces(tw - bw);
    } else {
      padtop = TBUtils.spaces(bw - tw);
    } // the bottom is wider

    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } else if (i < th) {
      return this.top.row(i) + padtop;
    } else {
      return this.bottom.row(i - th) + padbot;
    } // if the row is in the bottom half
  } // row(int)


   //Determine how many rows are in the block.
  public int height() {
    return this.top.height() + this.bottom.height();
  } 


   //Determines how many columns are in the block.
  public int width() {
    return Math.max(this.top.width(), this.bottom.width());
  } 

  public boolean eqv(TextBlock tbCmp){

    if(!(tbCmp instanceof VerticallyFlipped)){
      return false;
    }

    else{
    VerticallyFlipped tbCmpVF = (VerticallyFlipped) tbCmp;
    return this.top.eqv(tbCmpVF.top) && this.bottom.eqv(tbCmpVF.bottom);
    }
  }

}
