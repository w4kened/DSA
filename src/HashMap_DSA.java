import java.math.BigInteger;

public class HashMap_DSA {
    public String[] hashmap;

    public HashMap_DSA(int size) {
        this.hashmap = new String[size];
    }

    public int hash(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode += Character.codePointAt(key, i);
        }
        return hashCode % this.hashmap.length;
    }

    public void assign(String key, String value) {
        int arrayIndex = this.hash(key);
        this.hashmap[arrayIndex] = value;
    }

    public String retrieve(String key) {
        int arrayIndex = this.hash(key);
        return this.hashmap[arrayIndex];
    }
}
