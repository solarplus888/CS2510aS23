// to represent interface of bagel recipe. INCOMPLETE
interface IBagel {
}

class BagelRecipe implements IBagel {
  double flour;
  double water;
  double yeast;
  double malt;
  double salt;

  // main constructor
  BagelRecipe(double flour, double water, double yeast, double malt, double salt) {
    this.flour = flour;
    this.water = water;
    this.yeast = yeast;
    this.malt =  malt;
    this.salt = salt;
    
    if(this.flour == this.water) {
      this.flour = flour;
    }
    else {
      throw new IllegalArgumentException("the weight of the flour should be equal to the weight of the water");
    }
    
    if(this.yeast == this.malt) {
      this.yeast = yeast;
    }
    else {
      throw new IllegalArgumentException("the weight of the yeast should be equal to the weight of the malt");
    }
    
    if(this.salt == this.flour / 20 - this.yeast) {
      this.salt = salt;
    }
    else {
      throw new IllegalArgumentException("the weight of the salt + yeast should be 1/20th the weight of the flour");
    }
      
  }
  
  // second constructor
  BagelRecipe(double flour, double yeast) {
    this.flour = flour;    
    this.yeast = yeast;
   
  }
  
  //3rd constructor
  BagelRecipe(double flour, double yeast, double salt) {
    this.flour = flour;    
    this.yeast = yeast;
    this.salt = salt;
  }
  
  
}
