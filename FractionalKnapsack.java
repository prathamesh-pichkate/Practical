import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static double getMaxValue(int capacity, Item[] items) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        double totalValue = 0.0;
        int currWgt = 0;

        for (Item item : items) {
            if(currWgt >= capacity){
                break;
            }
            if(currWgt + item.weight <= capacity){
                currWgt += item.weight;
                totalValue += item.value;
            }else{
                int remain = capacity - currWgt;
                totalValue += ((double) (item.value/item.weight)*remain);
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };
        int capacity = 50;

        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}