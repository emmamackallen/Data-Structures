/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

  StringNode [] table;	// Hash table - collisions resolved through chaining.
  int numelements;	// Number of elements actually stored in the structure.
  int size;					// Allocated memory (size of the hash table).

  /** 
   * Constructur: initilaizes numelements, size and initial table size.
   */
  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  /*
   * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
   */
  public void insert(String key) {

    if (numelements == size) {
      //TODO: need to expand the hash table and rehash its contents.

	numelements = 0;      
	StringNode[] newTable; 
	int currentSize = size;
 	size = size * 2;

	newTable = new StringNode[size];

	for (int i = 0; i < currentSize; ++i) {
		for (StringNode curr = table[i]; curr != null; curr = curr.getNext()) {
			int c = hash(curr.getKey());
			newTable[c] = new StringNode(curr.getKey(), newTable[c]);						
		}
	}
	table = newTable;
    }
    //TODO: Code for actual insert.
    
	int a = hash(key);
	table[a] = new StringNode(key, table[a]);
	numelements += 1;
  }

  /*
   * finds if a String key is present in the data structure. Returns true if found, else false.
   */
  public boolean find(String key) {
    // TODO:
    
	int b = hash(key);

	for (StringNode curr = table[b]; curr != null; curr = curr.getNext()) {
		if (key.equals(curr.getKey())) {
			return true;
		}
	}
	return false;
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    // TODO:

	for (int i = 0; i < size; ++i) {
		for (StringNode curr = table[i]; curr != null; curr = curr.getNext()) {
			System.out.println(curr.getKey());
		}
	}
  }

  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
	int h = 0;
    // TODO: Compute a polynomial hash function for the String k. Make sure that the hash value h returned is a proper index 
    // in the hash table, ie. in the range [0...capacity-1]. 
    
	for (int i = 0; i < k.length(); ++i) {
		h = ((2917 * h) + (int) k.charAt(i)) % size;
	}
	return h;
  }

}
