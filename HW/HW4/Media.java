import tester.Tester;

// a piece of media
interface IMedia {
  
  // is this media really old?
  boolean isReallyOld();
  
  // are captions available in this language? INCOMPLETE: UANBLE TO PROCESS REST
  boolean isCaptionAvailable(String language);
  
  // a string showing the proper display of the media. INCOMPLETE: Only implemented for movie and did not proceed with abstraction
  String format();
}

// represents a movie
class Movie implements IMedia {
  String title;
  int year;
  ILoString captionOptions; // available captions
  
  Movie(String title, int year, ILoString captionOptions) {
    this.title = title;
    this.year = year;
    this.captionOptions = captionOptions;
  }
  
  
  public boolean isReallyOld() {
    if (this.year < 1930) {
      return true;
    }
    else {
       return false;
    }
  }
  
  public boolean isCaptionAvailable(String language) {
    if (this.captionOptions.language() == language) {
      return true;
    }
    else {
       return false;
    }
  }
  
  //Movies are formatted by the title followed by the year in parentheses, such as "The Favourite (2018)".
  public String format() {
    return this.title.concat("(").concat(String.valueOf(this.year)).concat(")");
  }
}

// represents a TV episode
class TVEpisode implements IMedia {
  String title;
  String showName;
  int seasonNumber;
  int episodeOfSeason;
  ILoString captionOptions; // available captions

  TVEpisode(String title, String showName, int seasonNumber, int episodeOfSeason,
      ILoString captionOptions) {
    this.title = title;
    this.showName = showName;
    this.seasonNumber = seasonNumber;
    this.episodeOfSeason = episodeOfSeason;
    this.captionOptions = captionOptions;
  }

  public boolean isReallyOld() {
    return false;
  }

  public boolean isCaptionAvailable(String language) {
    return false;
  }

  public String format() {
    return "";
  }
}

// represents a YouTube video
class YTVideo implements IMedia {
  String title;
  String channelName;
  ILoString captionOptions; // available captions
  
  public YTVideo(String title, String channelName, ILoString captionOptions) {
    this.title = title;
    this.channelName = channelName;
    this.captionOptions = captionOptions;
  }
  
  public boolean isReallyOld() {
    return false;
  }
  
  public boolean isCaptionAvailable(String language) {
    return false;
  }
  
  public String format() {
    return "";
  }
  
}

// lists of strings
interface ILoString {
  
  // get the language of the subtitle
  String language();
}




// an empty list of strings
class MtLoString implements ILoString {
  
  //get the language of the subtitle
  public String language() { return "";}
  
}

/*
TEMPLATE:
-----------------------
FIELDS:
...this.first...            --String
...this.rest...             --ILoString

METHODS:
...this.language()...       --String

METHODS FOR FIELDS:
...this.first.language()... --String
...this.rest.language()...  --ILoString
  
 */
  

// a non-empty list of strings
class ConsLoString implements ILoString {
  String first;
  ILoString rest;
  
  ConsLoString(String first, ILoString rest) {
    this.first = first;
    this.rest = rest;
  }
  
  //get the language of the subtitle
    public String language() {
      return this.first;}
 
}

// To represent example for media
class ExamplesMedia {
  ILoString english = new ConsLoString("English", new MtLoString());
  ILoString chinese = new ConsLoString("Chinese", new MtLoString());
  ILoString japanese = new ConsLoString("Japanese", new MtLoString());
  ILoString ec = new ConsLoString("English Chinese", 
                                new ConsLoString("English", chinese));
  ILoString ej = new ConsLoString("English Japanese",
                                new ConsLoString("English", japanese));
  
  Movie rambo = new Movie("Rambo", 1929, english);
  Movie alien = new Movie("Alien", 1988, ec);
  TVEpisode game = new TVEpisode("Game of Throne", "The winter is coming", 1, 1, chinese);
  TVEpisode rocky = new TVEpisode("Rocky Balbo", "Champion", 2, 4, ej);
  YTVideo edison = new YTVideo("Peekaboo", "Camera Everywhere Channel" ,chinese);
  YTVideo durain = new YTVideo("24King", "Durian King Channel" ,chinese);
  
  // to test Is really old method
  boolean testIsReallyOld(Tester t) {
    return t.checkExpect(this.rambo.isReallyOld(), true) &&
            t.checkExpect(this.alien.isReallyOld(), false) &&
            t.checkExpect(this.game.isReallyOld(), false) &&
            t.checkExpect(this.edison.isReallyOld(), false);
  }
  
//to test isCaptionAvailable method
 boolean testIsCaptionAvailable(Tester t) {
   return t.checkExpect(this.rambo.isCaptionAvailable("English"), true) &&
          t.checkExpect(this.alien.isCaptionAvailable("English Chinese"), true);
  }
 
//to test format method
boolean testFormat(Tester t) {
  return t.checkExpect(this.rambo.format(), "Rambo(1929)");
 } 
 
}
