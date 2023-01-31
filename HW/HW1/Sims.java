// problem 3 - 3 modes, 3 places and student


// to represent interface for 3 modes
interface IMode { 
}

// to represent a subject and whether it is examReview or not
class Study implements IMode {
  String subject;
  boolean examReview;
  
  Study(String subject, boolean examReview) {
    this.subject = subject;
    this.examReview = examReview;
  }  
}

// to represent socialize description and a count of friends to socialize with
class Socialize implements IMode {
  String description;
  int friends;
  
  Socialize(String description, int friends) {
    this.description = description;
    this.friends = friends;
  }
}

// to represent exercise name and whether it is aerobic or not
class Exercise implements IMode {
  String name;
  boolean aerobic;
  
  Exercise(String name, boolean aerobic) {
    this.name = name;
    this.aerobic = aerobic;
  }
}

// to represent interface for 3 places
interface IPlace {  
}

// to represent a classroom where A Classroom has a name, room-capacity and the current occupant-count. 
// The occupant count must be less than the room’s capacity. 
class Classroom implements IPlace {
  String  name;
  int roomCapacity;
  int occupantCount;
  
  Classroom(String name, int roomCapacity, int occupantCount) {
  this.name = name;
  this.roomCapacity = roomCapacity;
  this.occupantCount = occupantCount;
  }
}

/* 
to represent a gym where A Gym has a name, a count of exercise-machines, 
the current count of its patrons as well as whether it is open or not. 
The number of patrons must be less than the number of exercise machines or zero if the gym is closed.
*/
class Gym implements IPlace {
  String name;
  int exerciseMachines;
  int patrons;
  boolean open;
  
  Gym(String name, int exerciseMachines, int patrons, boolean open) {
    this.name = name;
    this.exerciseMachines = exerciseMachines;
    this.patrons = patrons;
    this.open = open;
  }
}

// to represent a student center where A StudentCenter has a name and whether it is open or not.
class StudentCenter implements IPlace {
  String name;
  boolean open;
  
  StudentCenter(String name, boolean open) {
    this.name = name;
    this.open = open;
  }
}

// to represent a student where A sim-student has a name, mode and a location that is their current place, 
// as well as a gpa and a major.
class SimStudent {
  String name;
  IMode mode;
  IPlace location;
  double gpa;
  String major;
  
  SimStudent(String name, IMode mode, IPlace location, double gpa, String major) {
    this.name = name;
    this.mode = mode;
    this.location = location;
    this.gpa = gpa;
    this.major = major;
  }
}

// to represents 6 examples of place and 4 examples of student
class ExamplesSims {
  ExamplesSims() {}
  
  Classroom shillman105 = new Classroom("Shillman 105", 115, 86);
  Gym marino = new Gym("Marino Recreation Center", 78, 47, true);
  StudentCenter curry = new StudentCenter("Curry Student Center", false);
  StudentCenter laksa = new StudentCenter("Laksa Student Center", true);
  StudentCenter nasi = new StudentCenter("Nasi Student Center", true);
  StudentCenter bubur = new StudentCenter("Bubur Student Center", true);
  Study arts = new Study("Arts", false);
  Study science = new Study("Science", true);
  Study history = new Study("History", true);
  Study math = new Study("Math", true);
  Socialize dull = new Socialize("Dull character", 1);
  Socialize normal = new Socialize("Normal character", 10);
  Socialize active = new Socialize("Active character", 100);
  Socialize hyper = new Socialize("Hyper character", 1000);
  Exercise run = new Exercise("Running", true);
  Exercise weight = new Exercise("Weight lifting", false);
  Exercise basketball = new Exercise("Basket ball", true);
  Exercise soccer = new Exercise("Soccer", true);
  SimStudent student1 = new SimStudent("Student 1", this.dull, this.shillman105, 3.5, "Arts major");
  SimStudent student2 = new SimStudent("Student 2", this.normal, this.marino, 3.4, "Science major");
  SimStudent student3 = new SimStudent("Student 3", this.active, this.curry, 3.3, "History major");
  SimStudent student4 = new SimStudent("Student 4", this.hyper, this.laksa, 3.2, "Math major");
}

