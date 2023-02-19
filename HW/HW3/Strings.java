// CS 2510, Assignment 3 INCOMPLETE

import tester.*;

// to represent a list of Strings
interface ILoString {
  
    // combine all Strings in this list into one
    String combine();
    
    // produces a new list, sorted in alphabetical order, treating all Strings as if they were given in all lower case
    ILoString sort();
    
    // insert the given String into this list of sorted string
    ILoString insert(String b); 
}

// to represent an empty list of Strings
class MtLoString implements ILoString {
    MtLoString(){}
    
    // combine all Strings in this list into one
    public String combine() {
       return "";
    }
    
    // produces a new list, sorted in alphabetical order, treating all Strings as if they were given in all lower case
    public ILoString sort() {
      return this;
    }
    
    // insert the given String into this list of sorted string
    public ILoString insert(String that) {
      return this;
    } 
    
}

// to represent a nonempty list of Strings
/*
TEMPLATE
FIELDS:
... this.first ...         -- String
... this.rest ...          -- ILoString

METHODS:
... this.combine() ...      -- String
... this.toLowerCase() ...  -- String
... this.sort() ...         -- ILoString
... this.insert(String that)...        -- ILoString

METHODS FOR FIELDS:
... this.first.concat(String) ...         -- String
... this.first.compareTo(String) ...      -- int
... this.first.toLowerCase() ...          -- String
... this.first.sort()...                  -- String
... this.first.insert()...                -- ILoString
... this.rest.combine() ...               -- String
... this.rest.toLowerCase() ...           -- ILoString
... this.rest.sort()...                   -- ILoString
... this.rest.insert()...                 -- ILoString

METHODS ON PARAMETERS:
... that.combine()...              --String
... that.toLowerCase() ...        -- String
... that.sort() ...               -- ILoString
... that.insert(String)...        -- ILoString

*/

class ConsLoString implements ILoString {
    String first;
    ILoString rest;
    
    ConsLoString(String first, ILoString rest){
        this.first = first;
        this.rest = rest;  
    }
    
    
    
    // combine all Strings in this list into one
    public String combine(){
        return this.first.concat(this.rest.combine());
    }
    
     // insert the given String into this list of sorted string INCOMPLETE
     public ILoString insert(String that) {
       if (this.first.compareToIgnoreCase(that) <= 0) {
         return new ConsLoString(this.first, this.rest.insert(that));
       }
       else {
         return new ConsLoString(that, this);
       }
     }
    
   // produces a new list, sorted in alphabetical order, treating all Strings as if they were given in all lower case
    public ILoString sort() {
      return this.rest.sort()          // sort the rest of the list...  
                 .insert(this.first);  // and insert the first String into that result
    }
    
}

// to represent examples for lists of strings
class ExamplesStrings{
    
    ILoString mary = new ConsLoString("Mary ",
                    new ConsLoString("had ",
                        new ConsLoString("a ",
                            new ConsLoString("little ",
                                new ConsLoString("lamb.", new MtLoString())))));
    
    ILoString sortedMary = new ConsLoString("a ",
        new ConsLoString("had ",
            new ConsLoString("lamb. ",
                new ConsLoString("little ",
                    new ConsLoString("Mary", new MtLoString())))));
    
    ILoString mtlist = new MtLoString();
    
    // test the method combine for the lists of Strings
    boolean testCombine(Tester t){
        return 
            t.checkExpect(this.mary.combine(), "Mary had a little lamb.");
    }
    
   // test the method sort for the lists of books
    boolean testSort(Tester t) {
      return
      t.checkExpect(this.mtlist.sort(), this.mtlist); 
      //&&
      //t.checkExpect(this.mary.sort(), this.sortedMary);
    }
}