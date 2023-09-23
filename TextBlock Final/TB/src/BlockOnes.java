//Author Luke Walters 
//Makes a textblock of 0 where spaces are and 1's where non-spaces are

public class BlockOnes implements TextBlock{

    //Field
    TextBlock bloc;

    //Constructor takes in a TextBlock
    public BlockOnes(TextBlock block){
        this.bloc = block;
    }

    //@pre 0 <= i < this.height()
  //@exception Exception if the precondition is not met
  //turns all of the char values in a bloc into 1 and all spaces into 0
    public String row(int i) throws Exception{
        String result = "";
    
        if ((i < 0) || (i >= this.bloc.height())) {
          throw new Exception("Invalid row " + i);
        } // if the row is invalid

        for(int j = 0; j < this.bloc.width(); j++){
            //System.out.println("test 1");
            if (Character.isWhitespace(this.bloc.row(i).charAt(j))){
                //System.out.println("test 1.1");
                result = result.concat("0");
            }
            else{
                //System.out.println("test 1.2");
                result = result.concat("1");
            }
        }
        return result;
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
    return this.bloc.width();
  }

  public boolean eqv(TextBlock tbCmp){

    if(!(tbCmp instanceof BlockOnes)){
      return false;
    }

    else{
    BlockOnes tbCmpBO = (BlockOnes) tbCmp;
    return this.bloc.eqv(tbCmpBO.bloc);
    }
  }
}
