package w4kened.misc;

public class Knapsack_DSA {
    public static int knapSack (int weightCap, int weights[], int values[], int i){
        if (i == 0 || weightCap == 0) {
            return 0;
        }

        else if (weights[i - 1] > weightCap) {
            return knapSack(weightCap, weights, values, i - 1);

        } else {
            return Math.max(
                            values[i - 1] + knapSack(weightCap - weights[i - 1], weights, values, i - 1),
                            knapSack(weightCap, weights, values, i - 1)
                    );
        }
    }
    static int dynamicKnapSack(int weightCap, int weights[], int values[], int i) {
        int index, weight;
        int matrix[][] = new int[i + 1][weightCap + 1];

        for (index = 0; index <= i; index++) {
            for (weight = 0; weight <= weightCap; weight++) {
                // add code here
                if (index == 0 || weight == 0) {
                    matrix[index][weight] = 0;
                }
                else if (weights[index - 1] <= weight) {
                    matrix[index][weight] = Math.max(
                      values[index - 1] + matrix[index - 1][weight - weights[index - 1]],
                      matrix[index - 1][weight]
                    );
                }
                else {
                    matrix[index][weight] = matrix[index - 1][weight];
                }
            }
        }
        return matrix[i][weightCap];
    }


    public static void main(String[] args) {
//        System.out.println(Knapsack_DSA.knapSack(5, new int[] {1, 3, 5}, new int[] {250,300,500}, 3));

        int values[] = new int[] { 70, 20, 39};
        int weights[] = new int[] { 31, 10, 20};
        int weightCap = 50;
        int i = values.length;
        Knapsack_DSA myNapsack = new Knapsack_DSA();
        System.out.println(myNapsack.dynamicKnapSack(weightCap, weights, values, i));
    }

    /*
    Let’s say that you have a knapsack that can only carry 5 pounds, and the house you’re robbing has three items that you want to steal:

    A ring that weighs 1 pound with a value of $250
    Earrings that weigh 3 pounds with a value of $300
    A necklace that weighs 5 pounds with a value of $500

    This information can be summarized as follows:

    weightCap = 5
    weights = [1, 3, 5]
    values = [250, 300, 500]

    You have four possible ways to fill your knapsack:

    Take only the ring, giving you $250
    Take only the earrings, giving you $300
    Take only the necklace, giving you $500
    Take the ring and the earrings, giving you $550

    Since the ring and the earrings have a combined weight of 4 pounds, taking both gives you the maximum value while staying within your weight capacity.
     */
}
