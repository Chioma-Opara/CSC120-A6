import java.util.Hashtable;


public class Library extends Building{
  private Hashtable<String, Boolean> collection;  //boolean tells us if the book is available or not

  // class constructor
  public Library(String name, String address, int nFloors){
    super(name, address, nFloors);
    this.collection = new Hashtable<> ();
  }


  /**
   * Returns true if the title appears as a key in the Libary's collection, false otherwise
   * @param title title of the book
   * @return whether or not book is contained in library's collection
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title)
  }

  /**
   * Returns true if the title is currently available to be checked out, false otherwise
   * @param title title of the book
   * @return boolean showing whether or not the book is available
   */
  public boolean isAvailable(String title){
    if (collection.get(title) == true){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * Add a book to the library's collection
   * @param title name of the book to be added
   */
  public void addTitle(String title){
    collection.put(title, true);
    System.out.println(title + " has been successfully added to " + this.getName() + "'s collection");
  }

  /**
   * Remove title from library's collection
   * @param title name of the book to be removed
   * @return name of the book removed from collection
   */
  public String removeTitle(String title){
    // if title is in collection, remove title
    if (containsTitle(title)){
      collection.remove(title);
      System.out.println("You have successfully removed " + title + " from " + this.getName() + "'s collection.");
      return title;
    }
 
    // else, throw an exception
    else{
      throw new RuntimeException("You cannot remove " + title + " as it is not in "  + this.getName() + "'s collection");
    }
  }

  /**
   * Check out title from library's collection
   * @param title name of the book to be checked out
   */
  public void checkOut(String title){
    // if title is in collection and is available, check out title
    if (this.containsTitle(title)){
      if (this.isAvailable(title)){
        collection.replace(title, collection.get(title), false);
        System.out.println("You have successfully checked out " + title + " from " + this.getName());
      }
      else{
        System.out.println(title + " is currently unavailable for check out");
      }
    }

    // if title is not in collection, throw an exception
    else{
      throw new RuntimeException("You cannot check out " + title + " at this time as it is not in " + this.getName() + "'s collection.");
    }
    }

  
  /**
   * Return a checked out book to library's collection. 
   * @param title name of book to be returned
   */
  public void returnBook(String title){
    // if title is in collection, change availibility of book to true
    if (this.containsTitle(title)){
      collection.replace(title, collection.get(title), true);
      System.out.println("You have successfully retured " + title + " to " + this.getName());
    }
    // if title is not in collection, throw an exception
    else{
      throw new RuntimeException(title + " was never in " + this.getName() + "'s collection. You could not have borrowed it from here.");
    }
  }

  /**
   * Prints out the entire collection and availability for check out of each book
   */
  public void printCollection(){
    System.out.println("\n" + this.getName().toUpperCase() + "'s BOOK COLLECTION"); // print a header for list
    collection.forEach((key, value)-> System.out.println("Currently available: " + value + "\t \t Title: " + key ));
    }
}


/**NOTES TO ME -> Personal notes to help future me work through my code
 * DO I need a getter for colletion. Nope. Don't want user to know where in memory my books was stored.
 * Hastables are java's version of python dictionaries
 * how does collection being private affect how I use collection.get(title). Nope. A class doesn't need an accessor to use ints own private attributes

 * CODE TESTER: 
 * public static void main(String[] args) {
    Library neilsonLibrary = new Library("Neilson library", "10 Chapin Lawn", 3);
    System.out.println(neilsonLibrary);
    neilsonLibrary.addTitle("Purple Hibiscus by Adichie");
    neilsonLibrary.addTitle("Mockingbird by Lee");
    // neilsonLibrary.removeTitle("Chi by Emma");
    neilsonLibrary.checkOut("Mockingbird by Lee");
    neilsonLibrary.checkOut("Mockingbird by Lee");
    // neilsonLibrary.returnBook("Mockingbird by Lee");
    // neilsonLibrary.checkOut("Chi by Emma");
    neilsonLibrary.printCollection();
  }
 */


