// Name: Robert Petty
// Class: CS 5040
// Term: Fall 2018
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ

import java.util.Scanner;

public class RadixSort_Robert_Petty {

    public static void main(String[] args){

        //Input numbers to array
        Scanner input = new Scanner(System.in);
        int[] inputs = new int[6];
        char again = 'Y';
        while(Character.toUpperCase(again) == 'Y') {  //loop to rerun program if wanted
            for (int i = 0; i < inputs.length; i++) {
                boolean validInt = false;
                while (!validInt) {
                    System.out.println("Enter value #" + (i + 1) + ":  ");
                    try {
                        inputs[i] = Integer.parseInt(input.nextLine());
                        validInt = true;
                    } catch (Exception e) {
                        System.out.print("Enqueue failed: Must be integer. Try again\n");
                    }
                }
            }

            //program results
            System.out.print("\nInputs array before sorting: ");
            for (int i = 0; i < inputs.length; i++) {
                System.out.print(inputs[i] + (i == inputs.length - 1 ? " " : ", "));
            }
            System.out.println();
            inputs = sort(inputs);
            System.out.print("Inputs array after sorting: ");
            for (int i = 0; i < inputs.length; i++) {
                System.out.print(inputs[i] + (i == inputs.length - 1 ? " " : ", "));
            }

            //ask to do it again or end
            System.out.println("\n\nDo you want to re-run code with different inputs (Y/N):");
            do {
                again = input.nextLine().charAt(0);
                if (again != 'Y' && again != 'N' && again != 'y' && again != 'n'){
                    System.out.println("invalid input. try again");
                }
            }while(again != 'Y' && again != 'N' && again != 'y' && again != 'n');
        }
    }

    //Method for radix sort
    public static int[] sort(int[] inputs) {
        Queue_Robert_Petty[] queueArray = new Queue_Robert_Petty[10];
        for (int i = 0; i < 10; i++){
            queueArray[i] = new Queue_Robert_Petty();
        }

        int maxDigit = getDigits(inputs); //determine number of digits of highest value
        int k;

        //sorting portion
        for (int i = 0; i < maxDigit; i++) {

            for (int j = 0; j < inputs.length; j++) {
                int index = Math.abs(ExtractDigit(inputs[j], i+1));
                queueArray[index].enqueue(inputs[j]);
            }
            k = 0;
            for (int j = 0; j < queueArray.length; j++){
                while(!queueArray[j].isEmpty()){
                   inputs[k++] = queueArray[j].front();
                   queueArray[j].dequeue();
               }
            }
        }

        //this portion is used to accommodate negative values
        Queue_Robert_Petty signSortQ = new Queue_Robert_Petty();
        for (int i = inputs.length - 1; i >= 0 ; i--){
            if(inputs[i] < 0) {
                signSortQ.enqueue(inputs[i]);
            }
        }
        for (int i = 0; i < inputs.length; i++){
            if(inputs[i] >= 0) {
                signSortQ.enqueue(inputs[i]);
            }
        }
        k = 0;
        while(!signSortQ.isEmpty()){
            inputs[k++] = signSortQ.front();
            signSortQ.dequeue();
        }

        return inputs;
    }

    //Method to find # of digits to check
    public static int getDigits(int[] inputs){
        int number = inputs[0];
        for(int i = 1; i < inputs.length; i++){
            number = inputs[i] > number ? inputs[i] : number;
        }
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number >= 1){
            number /= Math.pow(10,count++);
        }

        return count;
    }

    // Method to find value at specifid digit (from right to left)
    public static int ExtractDigit(int number, int place){
        return number % (int)Math.pow(10, place) / (int)Math.pow(10, place - 1);
    }

}

