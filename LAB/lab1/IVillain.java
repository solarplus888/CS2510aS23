// problem 3

// self-referential data to represent either a villain wearing a mask, described as a string,
// or the true identity as the person's name.
interface IVillain {}

// to represent a villain wearing a mask, described as a string
class Villain implements IVillain {
  String mask;
  
  Villain(String mask){
    this.mask = mask;
  }
}

// to represent the true identity as the person's name or Villain
class Person implements IVillain{
  String name;
  IVillain bad;
  
  Person(String name, IVillain bad){
    this.name = name;
    this.bad = bad;
  }
}

// examples and tests for the class hierarchy that represents Villain self referential data
// with at least 3 masks
class ExamplesVillain{
  IVillain batman = new Villain("batman");
  IVillain thor = new Villain("thor");
  IVillain hulk = new Villain("hulk");
  IVillain tommy3 = new Person("thor", this.hulk);
  IVillain tommy2 = new Person("batman", this.tommy3);
  IVillain tommy = new Person("tommy", this.tommy2);
}

// problem 4 - 6: refer to lecture 4 example on circle. 
// problem 7: incomplete

