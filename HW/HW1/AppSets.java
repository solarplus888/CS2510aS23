// problem 2

// class diagram is a self referential data

// to represent AppSet interface
interface IAppSets {} 

// to represent folder
class Folder implements IAppSets {
  String title;
  
  Folder(String title) {
    this.title = title;
  }
}

// to represent apps
class Apps implements IAppSets {
  String appName;
  IAppSets others;
  
  Apps(String appName, IAppSets others) {
    this.appName = appName;
    this.others = others;
  }
}

class ExamplesSets {
  ExamplesSets() { }
  
  IAppSets travel = new Folder("Travel");
  IAppSets food = new Folder("Food");
  IAppSets uber = new Apps("Uber", this.travel);
  IAppSets mTicket = new Apps("mTicket", this.travel);
  IAppSets moovit = new Apps("Moovit", this.travel);
  IAppSets orbitz = new Apps("Orbitz", this.travel);
  IAppSets grubhub = new Apps("Grubhub", this.food);
  IAppSets bGood = new Apps("B. Good", this.food);
  IAppSets gongCha = new Apps("Gong Cha", this.food);
}
