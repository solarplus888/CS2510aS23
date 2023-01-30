// problem 3

// unions of data
// to represent amusementpark
interface IAmusementpark {
}

//to represent a shows
class Shows implements IAmusementpark {
  String name;
  int age;

  Shows(String name, int age){
    this.name = name;
    this.age = age;
  }
}

// to represent food vendor
class Food implements IAmusementpark {
  String menu;
  
  Food(String menu){
    this.menu = menu;
  }
}

// to represent rollar coaster
class RC implements IAmusementpark {
  int height;
  int rating1;
  int rating2;
  
  RC(int height, int rating1, int rating2){
    this.height = height;
    this.rating1 = rating1;
    this.rating2 = rating2;
  }
}

class ExamplesAP {
  ExamplesAP() {}
  
  IAmusementpark puppet = new Shows("Puppet show", 3);
  IAmusementpark fire = new Shows("Fire show", 10);
  IAmusementpark noodle = new Food("fried noodle");
  IAmusementpark rice = new Food("fried rice");
  IAmusementpark smallspin = new RC(120, 2, 2);
  IAmusementpark bigspin = new RC(140, 8, 8);
  
}
