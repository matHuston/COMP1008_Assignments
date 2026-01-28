package lab_2;
import java.util.ArrayList;
 
public class Lab4 {
    public static void main(String[] args) {
 
        // Lab 4 – COMP1008 Programming Fundamentals
        // Topic: Arrays & ArrayLists
 
        // ================================================
        // STEP 1: Create an array of grocery items (String)
        // Add at least 6 items to the array
        // Example: {"Milk", "Eggs", "Bread", ... }
        // ================================================
        String[] groceries = {
            // TODO: Fill in your grocery items
            "Chicken Thighs", 
            "Smoked Pork Sausage", 
            "Bell Peppers", 
            "Onions",
            "Garlic",
            "Celery",
            "Parsley"
        };
 
 
        // ================================================
        // STEP 2: Print the array using Arrays.toString()
        // ================================================
            System.out.println(groceries.toString());
 
        // ================================================
        // STEP 3: Transfer all array items into an ArrayList
        // Use a loop to add each item
        // ================================================
        // TODO: Loop through the array and add items to groceryList
        ArrayList<String> groceryList = new ArrayList<>();
        for(String food : groceries){
            groceryList.add(food);
        }
        System.out.println(groceryList);
 
        // ================================================
        // STEP 4: Modify the ArrayList
        // Add two new items
        // Remove one item by name or index
        // Print the updated ArrayList
        // ================================================
        groceryList.add("Flour");
        groceryList.add("Butter");
        groceryList.remove(4);
        System.out.println(groceryList);
 
        // ================================================
        // STEP 5: Count how many items start with a vowel
        // Hint: vowels = a, e, i, o, u
        // Use .toLowerCase(). startsWith()
        // ================================================
        String[] vowels = {"a", "e", "i", "o", "u"};
        int counter = 0;
        for (String item : groceryList) {
            String lowerItem = item.toLowerCase();
            for(String letter : vowels){
                if(lowerItem.startsWith(letter)){
                    counter += 1;
                }
            }
        }
 
        // ================================================
        // STEP 6: Print the final results
        // ================================================
        System.out.println("There are " + counter + " many vowels in the list.");
    }
}
 