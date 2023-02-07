import tester.Tester;

// Lab4 problem1

// to represent interface for a game piece is either a base tile or 
// a merge tile that has two component tiles it merged from. 
interface IGamePiece {
  
  // returns the value of a game piece
  int getValue();
  
  // combines this game piece with the given game piece to form a merged piece.
  IGamePiece merge(IGamePiece that);
  
  // only equal-valued pieces can merge;
  boolean isValid();
  
  }

// to represent a base tile with its value

/*
TEMPLATES
----------------------
FIELDS:
...this.number...                 --int

METHODS:
...this.getValue()...             --int
...this.merge()...                --IGamePiece
...this.isValid()...              --boolean

METHODS ON FIELDS:
...this.number.getValue()...      --int
...this.number.merge()...         --IGamePiece
...this.number.isValid()...       --boolean

FIELDS OF PARAMETERS:
...that.number...                 --int
...that.piece1...                 --IGamePiece
...that.piece2...                 --IGamePiece

METHODS ON PARAMETERS:
...that.number.getValue()...      --int
...that.number.merge()...         --IGamePiece
...that.number.isValid()...       --boolean
...that.piece1.getValue()...      --IGamePiece
...that.piece2.getValue()...      --IGamePiece
...that.piece1.merge()...         --IGamePiece
...that.piece2.merge()...         --IGamePiece
...that.piece1.isValid()...       --boolean
...that.piece2.isValid()...       --boolean
 */

class BaseTile implements IGamePiece {
  int number;
  
  BaseTile(int number) {
    this.number = number;    
  }
  
  //returns the value of a game piece
   public int getValue() {
     return this.number;
   }
   
  // combines this game piece with the given game piece to form a merged piece.  
    public IGamePiece merge(IGamePiece that) {
       return new MergeTile(this, that);       
     }  
   
   
    // only equal-valued pieces can merge;
     public boolean isValid() {
       return false;
     }
   
}

// to represent merge tile that has two component tiles it merged from

/*
TEMPLATES
----------------------
FIELDS:
...this.piece1...                 --IGamePiece
...this.piece2...                 --IGamePiece

METHODS:
...this.getValue()...      --int
...this.getValue()...      --int
...this.merge()...         --IGamePiece
...this.merge()...         --IGamePiece
...this.isValid()...       --boolean
...this.isValid()...       --boolean

METHODS ON FIELDS:
...this.piece1.getValue()...      --IGamePiece
...this.piece2.getValue()...      --IGamePiece
...this.piece1.merge()...         --IGamePiece
...this.piece2.merge()...         --IGamePiece
...this.piece1.isValid()...       --boolean
...this.piece2.isValid()...       --boolean

FIELDS OF PARAMETERS:
...that.number...                 --int
...that.piece1...                 --IGamePiece
...that.piece2...                 --IGamePiece

METHODS ON PARAMETERS:
...that.number.getValue()...       --int
...that.number.merge()...          --IGamePiece
...that.number.isValid()...        --boolean
...that.piece1.getValue()...       --int
...that.piece2.getValue()...       --int
...that.piece1.merge()...          --IGamePiece
...that.piece2.merge()...          --IGamePiece
...that.piece1.isValid()...        --boolean
...that.piece2.isValid()...        --boolean
 */

class MergeTile implements IGamePiece {
  IGamePiece piece1;
  IGamePiece piece2;
  
  MergeTile(IGamePiece piece1, IGamePiece piece2) {
    this.piece1 = piece1;
    this.piece2 = piece2;
  }
  
  //returns the value of a game piece
    public int getValue() {
      return this.piece1.getValue() + this.piece2.getValue();
  }
    
  // combines this game piece with the given game piece to form a merged piece.  
    public IGamePiece merge(IGamePiece that) {
       return new MergeTile(this, that);       
     }  
   
   
    // only equal-valued pieces can merge;
     public boolean isValid() {
       if (this.piece1.getValue() == this.piece2.getValue()) {
         return true;
       }
       else {
         return false;
       }
     }  
}

// examples for class and test case for method
class ExamplesGP {
  ExamplesGP() {}; 
  
  IGamePiece two = new BaseTile(2);
  IGamePiece three = new BaseTile(3);
  IGamePiece two3 = new MergeTile(two, three);
  IGamePiece twotwo = new MergeTile(two, two);
  IGamePiece two3twotwo = new MergeTile(two3, twotwo);
  
  // test the method getValue
  boolean testGetValue(Tester t) {
    return t.checkExpect(two.getValue(), 2)
        && t.checkExpect(two3.getValue(), 5);
  }
  
 // test the method merge
    boolean testMerge(Tester t) {
      return t.checkExpect(two.merge(three), two3)
          && t.checkExpect(two3.merge(twotwo), two3twotwo);  
    }
    
 // test the method isValid
    boolean testIsValid(Tester t) {
      return t.checkExpect(two.isValid(), false)
          && t.checkExpect(twotwo.isValid(), true)
          && t.checkExpect(two3twotwo.isValid(), false);  
    }   
  
}