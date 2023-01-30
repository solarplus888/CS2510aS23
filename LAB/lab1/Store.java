// problem 1 & 2

// to represent store location
class Location {
  String city;
  String state;
  
  // the constructor
  Location(String city, String state) {
    this.city = city;
    this.state = state;
  }
}

// to represent a company store
public class Store {
  String name;
  int year;
  String inventory;
  Location location;
  
  // the constructor
  Store(String name, int year, String inventory, Location location) {
    this.name = name;
    this.year = year;
    this.inventory = inventory;
    this.location = location;
  }
}

// examples and tests for the classes that represent store

class ExamplesStores {
  ExamplesStores() { }
  
  Location a = new Location("Bellevue", "");
  Location s = new Location("Boston", "MA");
  Location o = new Location("New York City", "NY");
  Store amazon = new Store("Amazon", 1994, "miscellany", this.a);
  Store subway = new Store("Subway", 1965, "sandwiches", this.s);
  Store outlier = new Store("Outlier", 2008, "clothing", this.o);
}

