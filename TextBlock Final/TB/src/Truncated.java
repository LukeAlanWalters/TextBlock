//Author Luke Walters 
//Truncates a given textblock

public class Truncated implements TextBlock{

  //Fields for Truncated
  TextBlock bloc;
  int truncWidth;



  //Constructor for Truncated
  //Creates a Trucanted object with input TextBlock block and int w 
  public Truncated(TextBlock block ,int w){
    this.bloc = block;
    this.truncWidth = w;
  }

  //@pre 0 <= i < this.height()
  //@exception Exception if the precondition is not met
  //is the row method for Truncated which will truncate each row with the given truncWidth
  public String row(int i) throws Exception{
    String result;

    if ((i < 0) || (i >= this.bloc.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    // checks to see if spaces are needed to pad the end
    if (this.bloc.width() < this.truncWidth){
      String spaces = "";
      
      for (int j = this.bloc.row(i).length(); j < this.truncWidth; j++){
        spaces = spaces.concat(" ");
      }
      result = this.bloc.row(i);
      result = result.concat(spaces);
      return result;
      
    }
    else{
        //truncates the TextBlock
        result = this.bloc.row(i).substring(0, this.truncWidth);
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
    return this.truncWidth;
  }

  public boolean eqv(TextBlock tbCmp){

    if(!(tbCmp instanceof Truncated)){
      return false;
    }

    else{
    Truncated tbCmpTR = (Truncated) tbCmp;
    return this.bloc.eqv(tbCmpTR.bloc);
    }
  }


}

