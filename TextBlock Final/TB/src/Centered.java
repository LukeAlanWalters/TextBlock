//Author Luke Walters 
//centers a texblock

public class Centered implements TextBlock{

  //fields
  TextBlock bloc;
  int centWidth;

  //Constructor expects a TextBlock and int as input
  public Centered(TextBlock block, int w) {
    this.bloc = block;
    this.centWidth = w;
    
  }

  //@pre 0 <= i < this.height()
  //@exception Exception if the precondition is not met
  public String row(int i) throws Exception{
    String result = "";
    double holder;
    String spaces = "";

    if ((i < 0) || (i >= this.bloc.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    else if (this.bloc.width() > this.centWidth){
      holder = this.bloc.width() - this.centWidth;
      double leftRem = Math.ceil(holder/2.0);
      double rightRem = Math.floor(holder/2.0);
      result = this.bloc.row(i).substring(0, this.bloc.width() - (int) rightRem);

      result = result.substring((int) leftRem, result.length());
      return result;

    }

    else{
    //determines how many spaces there will be on both sides
      holder = this.centWidth/2.0 - this.bloc.width()/2.0;
      double start = Math.ceil(holder);
      double end = Math.floor(holder);

      //for loops which concat the spaces on both sides
      for (int j = 0; j < (int) start; j++){
        spaces = spaces.concat(" ");
      }
      result = spaces.concat(this.bloc.row(i));
      spaces = "";
      for (int j = 0; j < (int) end; j++){
        spaces = spaces.concat(" ");
      }
      result = result.concat(spaces);
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
    return this.centWidth;
  }

  public boolean eqv(TextBlock tbCmp){

    if(!(tbCmp instanceof Centered)){
      return false;
    }

    else{
    Centered tbCmpCent = (Centered) tbCmp;
    return this.bloc.eqv(tbCmpCent.bloc);
    }
  }

}



