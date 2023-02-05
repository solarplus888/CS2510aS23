import tester.*;
// assignment2

// problem 1. problem2 INCOMMPLETE
/*
;;A Circuit is one of
;; -- Battery
;; -- Resistor
;; -- Series
;; -- Parallel
 */
interface ICircuit {
  // To count the number of simple components (batteries and resistors) in this component
  int countComponents();
  
  // To compute the voltage between the two terminals of this circuit component
  double totalVoltage();
  
  // To compute the current flowing from the left terminal to the right terminal of this circuit component. INCOMPLETE.
  double totalCurrent();
  
  // method reversePolarity. INCOMPLETE
}

/*
;; A Battery is a (make-battery String Double Double)
(define-struct battery (name voltage nominal-resistance))
*/

/*
TEMPLATE:
------------------------------
FIELDS:
...this.name...             --String
...this.voltage...          --double
...this.nominalResistance...--double

METHODS:
...this.countComponents()... --int
...this.totalVoltage()...    --double
...this.totalCurrent()...    --double 
 */

class Battery implements ICircuit {
  String name;
  double voltage;
  double nominalResistance;
  
  Battery(String name, double voltage, double nominalResistance) {
    this.name = name;
    this.voltage = voltage;
    this.nominalResistance = nominalResistance;
  }
  
  // To count the number of batteries in this component
  public int countComponents() {
    return 1;
  }
  
  //To compute the voltage between the two terminals of this circuit component
  public double totalVoltage() {
    return this.voltage;
  }
  
  //To compute the current flowing from the left terminal to the right terminal of this circuit component
  public double totalCurrent() {
    return this.voltage;
  };
}


/*
;; A Resistor is a (make-resistor String Double)
(define-struct resistor (name resistance))
 */

/*
TEMPLATE:
------------------------------
FIELDS:
...this.name...             --String
...this.resistor...         --double

METHODS:
...this.countComponents()... --int
...this.totalVoltage()...    --double
...this.totalCurrent()...    --double   
 */

class Resistor implements ICircuit {
  String name;
  double resistance;
  
  Resistor(String name, double resistance) {
    this.name = name;
    this.resistance = resistance;
  }
  
  //To count the number of resistor in this component
   public int countComponents() {
     return 1;
   }
   
 //To compute the voltage between the two terminals of this circuit component
   public double totalVoltage() {
     return 0;
   }
   
 //To compute the current flowing from the left terminal to the right terminal of this circuit component
   public double totalCurrent() {
     return this.resistance;
   };
}


 /*
;; A Series is a (make-series Circuit Circuit)
(define-struct series (first second))
 */

/*
TEMPLATE:
------------------------------
FIELDS:
...this.first...             --ICircuit
...this.second...            --ICircuit

METHODS:
...this.countComponents()... --int
...this.totalVoltage()...    --double
...this.totalCurrent()...    --double 

METHODS ON FIELDS:
...this.first.countComponents()... --int
...this.second.countComponents()... --int
...this.first.totalVoltage()... --double
...this.second.totalVoltage()... --double
...this.first.totalCurrent()... --double
...this.second.totalCurrent()... --double
  
 */

class Series implements ICircuit {
  ICircuit first;
  ICircuit second;
  
  Series(ICircuit first, ICircuit second) {
    this.first = first;
    this.second = second;
  }
  
  //To count the number of simple components (batteries and resistors) in this component
  public int countComponents() {
    return this.first.countComponents() + this.second.countComponents();
  }
  
  //To compute the voltage between the two terminals of this circuit component
  public double totalVoltage() {
    return this.first.totalVoltage() + this.second.totalVoltage();
  }
  
  //To compute the current flowing from the left terminal to the right terminal of this circuit component
  public double totalCurrent() {
    /*if (this.first == Resistor && this.second == Battery) {
        return this.second.totalCurrent() / this.first.totalCurrent();}
    elseif (this.first == Battery && this.second == Resistor) {
        return this.first.totalCurrent() / this.second.totalCurrent();}
    else {return 0;}
    */
    return 0;
  }
}


/*
;; A Parallel is a (make-parallel Circuit Circuit)
(define-struct parallel (first second))
 */

/*
TEMPLATE:
------------------------------
FIELDS:
...this.first...             --ICircuit
...this.second...            --ICircuit

METHODS:
...this.countComponents()... --int
...this.totalVoltage()...    --double
...this.totalCurrent()...    --double 

METHODS ON FIELDS:
...this.first.countComponents()... --int
...this.second.countComponents()... --int
...this.first.totalVoltage()... --double
...this.second.totalVoltage()... --double  
...this.first.totalCurrent()... --double
...this.second.totalCurrent()... --double  
 */

class Parallel implements ICircuit {
  ICircuit first;
  ICircuit second;
  
  Parallel(ICircuit first, ICircuit second) {
    this.first = first;
    this.second = second;
  }
  
  //To count the number of simple components (batteries and resistors) in this component
  public int countComponents() {
    return this.first.countComponents() + this.second.countComponents();
  }
  
  //To compute the voltage between the two terminals of this circuit component
  public double totalVoltage() {
    return this.first.totalVoltage() + this.second.totalVoltage();
  }
  
  //To compute the current flowing from the left terminal to the right terminal of this circuit component
  public double totalCurrent() {
    return 0;
  };
}

// examples of ICircuit & methods
class ExamplesCircuits {
  ExamplesCircuits() {}
  ICircuit batteryOne = new Battery("B 1", 10, 25);
  ICircuit battery1 = new Battery("BT 1", 10, 0);
  ICircuit battery2 = new Battery("BT 2", 20, 0);
  ICircuit resistorOne = new Resistor("R 1", 100);
  ICircuit resistorTwo = new Resistor("R 2", 250);
  ICircuit resistorThree = new Resistor("R 3", 500);
  ICircuit resistorFour = new Resistor("R 4", 200);
  ICircuit resistorFive = new Resistor("R 5", 50);
  ICircuit simpleSeries = new Series(batteryOne, resistorOne);
  ICircuit series1 = new Series(battery1, battery2);
  ICircuit series2 = new Series(resistorFour, resistorFive);
  ICircuit parallel1 = new Parallel(series1, series2);
  ICircuit parallel2 = new Parallel(parallel1, resistorOne);
  ICircuit parallel3 = new Parallel(parallel2, resistorTwo);
  ICircuit complexCircuit = new Parallel(parallel3, resistorThree);
  
  // test the method countComponents()
  boolean testCountComponents(Tester t) {
    return t.checkExpect(this.battery1.countComponents(), 1)
        && t.checkExpect(this.resistorOne.countComponents(),1)
        && t.checkExpect(this.complexCircuit.countComponents(), 7);
  }
    
  // test the method totalVoltage()
  boolean testTotalVoltage(Tester t) {
    return t.checkExpect(this.battery1.totalVoltage(), 10.0)
        && t.checkExpect(this.complexCircuit.totalVoltage(), 30.0);
  }
  
}