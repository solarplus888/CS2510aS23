import tester.*;                // The tester library
import javalib.worldimages.*;   // images, like RectangleImage or OverlayImages
import javalib.funworld.*;      // the abstract World class and the big-bang library
import javalib.worldcanvas.*;   // so we can view our images
import java.awt.Color;          // general colors (as triples of red,green,blue values)
                                // and predefined colors (Red, Green, Yellow, Blue, Black, White)


// problem 1. method buildMobile & curWidth INCOMPLETE 

// to represent interface for simple and complex mobile
interface IMobile {
  // to computes the total weight of the mobile.                                       
   int totalWeight();
   
  // to compute the total height of the mobile. INCOMPLETE
   int totalHeight();
   
  // to compute whether a mobile is balanced
   boolean isBalanced();
}

// to represent simple mobile

/*
 TEMPLATE:
 ---------------
 Fields:
 ...this.length...            --int
 ...this.weight...            --int
 ...this.color...             --String
 
 Methods:
 ...this.totalWeight()...     --int
 ...this.totalHeight()...     --int
 ...this.isBalanced()...      --boolean
 
 */

class Simple implements IMobile {
  int length;
  int weight;
  String color;
  
  Simple(int length, int weight, String color) {
    this.length = length;
    this.weight = weight;
    this.color = color;
  }
  
  // to computes the total weight of simple mobile
  public int totalWeight() { 
    return this.weight;}
  
  //to computes the total height of simple mobile
   public int totalHeight() { 
     return this.length;}
   
  // to compute whether a mobile is balanced
   public boolean isBalanced() {
     return true;
   }
  
}

//to represent complex mobile

/*
 TEMPLATES:
 ---------------
 FIELDS:
 ...this.length...                  --int
 ...this.leftside...                --int
 ...this.rightside...               --int
 ...this.left...                    --IMobile
 ...this.right...                   --IMobile
 
 METHODS:
 ...this.totalWeight()...           --int
 ...this.totalHeight()...           --int
 ...this.isBalanced()...            --boolean
 
 METHODS ON FIELDS:
 ...this.left.totalWeight()...      --int
 ...this.right.totalWeight()...     --int
 ...this.left.totalHeight()...      --int
 ...this.right.totalHeight()...     --int
 ...this.left.isBalanced()...       --boolean
 ...this.right.isBalanced()...      --boolean
 
 */
class Complex implements IMobile {
  int length;
  int leftside;
  int rightside;
  IMobile left;
  IMobile right;
    
  Complex(int length, int leftside, int rightside, IMobile left, IMobile right) {
    this.length = length;
    this.leftside = leftside;
    this.rightside = rightside;
    this.left = left;
    this.right = right;
  }
  
  // to computes the total weight of complex mobile
  public int totalWeight() { 
    return this.left.totalWeight() + this.right.totalWeight();}
  
  //to computes the total height of complex mobile. INCOMPLETE
  public int totalHeight() { 
    return this.left.totalHeight() + this.right.totalHeight();}
  
  //to compute whether a mobile is balanced
    public boolean isBalanced() {
      return this.left.totalWeight() * this.leftside == this.right.totalWeight() * this.rightside;
    }
  
}

// to represent example for simple & complex mobile. example3 outstanding.
class ExamplesMobiles {
  ExamplesMobiles() {}
  
  IMobile exampleSimple = new Simple(2, 20, "blue");
  IMobile exampleSimple36B = new Simple(1, 36, "blue");
  IMobile exampleSimple12R = new Simple(1, 12, "red");
  IMobile exampleSimple36R = new Simple(2, 36, "red");
  IMobile exampleSimple60G = new Simple(1, 60, "green");
  IMobile exampleComplex1 = new Complex(2, 5, 3, exampleSimple36R, exampleSimple60G);
  IMobile exampleComplex2 = new Complex(2, 8, 1, exampleSimple12R, exampleComplex1);
  IMobile exampleComplex3 = new Complex(1, 9, 3, exampleSimple36B, exampleComplex2);

  // test the method totalWeight
  boolean testTotalWeight(Tester t) {
    return t.checkExpect(this.exampleSimple.totalWeight(), 20)
        && t.checkExpect(this.exampleComplex3.totalWeight(), 144);
    }

//test the method isBalanced
 boolean testIsBalanced(Tester t) {
   return t.checkExpect(this.exampleSimple.isBalanced(), true)
       && t.checkExpect(this.exampleComplex3.isBalanced(), true);
   }


}

// problem 3.1.1 - 3.1.3 INCOMPLETE
class ExamplesS {
  
//shows image at the center of an equally-sized canvas,
 // and the text at the top of the frame is given by description
 boolean showImage(WorldImage image, String description) {
   int width = (int) Math.ceil(image.getWidth());
   int height = (int) Math.ceil(image.getHeight());
   WorldCanvas canvas = new WorldCanvas(width, height, description);
   WorldScene scene = new WorldScene(width, height);
   return canvas.drawScene(scene.placeImageXY(image, width / 2, height / 2))
       && canvas.show();
 }

 WorldImage circleBlue = new CircleImage(100, OutlineMode.SOLID, Color.BLUE);
 WorldImage circleRed = new CircleImage(100, OutlineMode.SOLID, Color.RED);

 boolean testDrawMyShapes(Tester t) {
   return showImage(circleBlue, "Blue circle")
       && showImage(circleRed, "Red circle");
 }
}

