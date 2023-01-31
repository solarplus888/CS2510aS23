// problem 1

// to represent a real estate listing
class RealEstateListing {
  boolean singleFamily;
  int year;
  int squareFootage;
  int price;
  String city;
  
  RealEstateListing(boolean singleFamily, int year, int squareFootage, int price, String city) {
    this.singleFamily = singleFamily;
    this.year = year;
    this.squareFootage = squareFootage;
    this.price = price;
    this.city = city;
  } 
}

// to represent 3 examples of real estate listing
class ExamplesListings {
  ExamplesListings() {}
  
  RealEstateListing bostonCondo = new RealEstateListing(false, 2010, 700, 350000, "Boston");
  RealEstateListing beachHouse = new RealEstateListing(true, 1995, 2000, 699999, "Yarmouth"); 
  RealEstateListing chicagoTownhouse = new RealEstateListing(false, 2020, 1700, 400000, "Chicago");
}  
  
  
