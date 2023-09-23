//Author Luke Walters 
//Makes a textblock that is right justified

public class RightJustified implements TextBlock{

  //Fields
TextBlock bloc;
int justWidth;

  //Constructor requires a TextBlock and int as input
  public RightJustified(TextBlock block, int w) {
    this.bloc = block;
    this.justWidth = w;
  }

  //@pre 0 <= i < this.height()
  //@exception Exception if the precondition is not met
  public String row(int i) throws Exception{
    String result;
    double holder;
    String spaces = "";

    if ((i < 0) || (i >= this.bloc.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    else if(this.justWidth > this.bloc.width()){
      holder = this.justWidth - this.bloc.width();

      for (int j = 0; j < holder; j++){
        spaces = spaces.concat(" ");
      }
      result = spaces.concat(this.bloc.row(i));
      return result;
    }
      else {
        result = this.bloc.row(i);
        result = result.substring(this.bloc.width() - this.justWidth, this.bloc.width());
        return result;
      }
    
  }
  

  /**
   * Determine how many rows are in the block.
   */
  public int height(){
    return this.bloc.height();
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width(){
    return this.justWidth;
  }

  public boolean eqv(TextBlock tbCmp){

    if(!(tbCmp instanceof RightJustified)){
      return false;
    }

    else{
    RightJustified tbCmpRJ = (RightJustified) tbCmp;
    return this.bloc.eqv(tbCmpRJ.bloc);
    }
  }
    
}
