package w4kened.misc;
import java.util.ArrayList;

class Combinatorics_DSA {
    ArrayList<Integer> values;

    public Combinatorics_DSA (String data){
        this.values = new ArrayList<>();
        String[] splitedData = data.split(",");
        for (String elem : splitedData) {
            values.add(Integer.valueOf(elem));
        }
    }
    public void permutateWithoutRepetitions(int k) {
        //Order is required
        ArrayList<Integer> permutations = new ArrayList<>();
        boolean[] isUsed = new boolean[values.size()];
        generatePermutations(k, isUsed, permutations);
    }
    private void generatePermutations(int k, boolean[] isUsed, ArrayList<Integer> permutations) {
        if (permutations.size() == k) {
            System.out.println(permutations);
            return;
        }
        for (int i = 0; i < this.values.size(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permutations.add(this.values.get(i));
                generatePermutations(k, isUsed, permutations);
                permutations.remove(permutations.size()-1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Combinatorics_DSA combinatorics = new Combinatorics_DSA("1,2,3");
        combinatorics.permutateWithoutRepetitions(2);
    }
}