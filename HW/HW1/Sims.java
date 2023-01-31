// problem 3 - 3 modes, 3 places and student

// to represent a subject and whether it is examReview or not
class Study {
  String subject;
  boolean examReview;
  
  Study(String subject, boolean examReview) {
    this.subject = subject;
    this.examReview = examReview;
  }  
}

// to represent socialize description and a count of friends to socialize with
class Socialize {
  String description;
  int friends;
  
  Socialize(String description, int friends) {
    this.description = description;
    this.friends = friends;
  }
}

// to represent exercise name and whether it is aerobic or not
class Exercise {
  String name;
  boolean aerobic;
  
  Exercise(String name, boolean aerobic) {
    this.name = name;
    this.aerobic = aerobic;
  }
}

// to represent 3 types of mode (behaviors)
class Mode {
  Study study;
  Socialize socialize;
  Exercise exercise;
  
  Mode(Study study, Socialize socialize, Exercise exercise) {
    this.study = study;
    this.socialize = socialize;
    this.exercise = exercise;
  }
}

// to represent a classroom where A Classroom has a name, room-capacity and the current occupant-count. 
// The occupant count must be less than the room’s capacity. 
class Classroom {
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
class Gym {
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
class StudentCenter {
  String name;
  boolean open;
  
  StudentCenter(String name, boolean open) {
    this.name = name;
    this.open = open;
  }
}

// to represent 3 types of places a student can visit
class Place {
  Classroom classroom;
  Gym gym;
  StudentCenter studentCenter;
  
  Place(Classroom classroom, Gym gym, StudentCenter studentCenter) {
    this.classroom = classroom;
    this.gym = gym;
    this.studentCenter = studentCenter;
  }  
}

// to represent a student where A sim-student has a name, mode and a location that is their current place, 
// as well as a gpa and a major.
class SimStudent {
  String name;
  Mode mode;
  Place location;
  double gpa;
  String major;
  
  SimStudent(String name, Mode mode, Place location, double gpa, String major) {
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
  Mode mode1 = new Mode(this.arts, this.dull, this.run);
  Mode mode2 = new Mode(this.science, this.normal, this.weight);
  Mode mode3 = new Mode(this.history, this.active, this.basketball);
  Mode mode4 = new Mode(this.math, this.hyper, this.soccer);
  Place place1 = new Place(this.shillman105, this.marino, this.curry);
  Place place2 = new Place(this.shillman105, this.marino, this.laksa);
  Place place3 = new Place(this.shillman105, this.marino, this.nasi);
  Place place4 = new Place(this.shillman105, this.marino, this.bubur);
  SimStudent student1 = new SimStudent("Student 1", this.mode1, this.place1, 3.5, "Arts major");
  SimStudent student2 = new SimStudent("Student 2", this.mode2, this.place2, 3.4, "Science major");
  SimStudent student3 = new SimStudent("Student 3", this.mode3, this.place3, 3.3, "History major");
  SimStudent student4 = new SimStudent("Student 4", this.mode4, this.place4, 3.2, "Math major");
}
