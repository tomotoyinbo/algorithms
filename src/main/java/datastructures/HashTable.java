package datastructures;

public class HashTable {

    private int INITIAL_SIZE = 16;

    private HashEntry[] data;//LinkedList

    public HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value){
        //get the index
        int index = getIndex(key);

        //create the linked List entry
        HashEntry entry = new HashEntry(key, value);

        // If no entry there - add it
        if(data[index] == null){

            data[index] = entry;

        } else {// Else handle collision by adding to end of linked list

            HashEntry entries = data[index];

            //Walk to the end...
            while(entries.next != null){
                entries = entries.next;
            }

            //Add new entry
            entries.next = entry;
        }
    }

    public String get(String key){

        int index = getIndex(key);

        HashEntry entries = data[index];

        while (entries != null){
            if (entries.key.equals(key)){ //check for match
                return entries.value; //if found return value
            }else {
                entries = entries.next;//otherwise go to next entry in the chain
            }
        }

        return null;//return null if no match found
    }

    private int getIndex(String key){

        int hashCode = key.hashCode();

        return (hashCode & 0x7fffffff) % INITIAL_SIZE;
    }

    @Override
    public String toString() {

        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();

        for (HashEntry entry : data) {

            if(entry == null) {
                continue;
            }

            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());

            bucket++;
            HashEntry temp = entry.next;

            while(temp != null) {

                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }

        return hashTableStr.toString();
    }

    class HashEntry {

        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {

            this.key = key;
            this.value = value;
        }
    }
}
