import java.util.Scanner;

public class Assignment {
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        System.out.println("Welcome to Fred's diamond printer!\n");
        //Print pattern examples using the default num provided
        int defaultNum = 7;
        printPattern(combinePatterns(new char[][][]{pattern1(defaultNum), pattern2(defaultNum), pattern3(defaultNum), pattern4(defaultNum)}));


/**
        int pattern = getValue("Enter pattern number (5 to exit): ",0,5);
        int rowNum = getValue("Enter number of rows: ",0,10);
        System.out.println(patern + " : "+rowNum);
**/

    }

    static char[][] pattern1(int num){
        char[][] board = new char[num][num]; //creates a blank 2d array of characters to work with, must be char because of the way I combine
        char[] row = new char[num]; //creates a row of empty characters
        for(int i = 0; i < num; i++){ //goes through the rows
            row[i] = String.valueOf(num-i).charAt(0); //sets a number to the row at i
            board[num-i-1] = row.clone(); //asigns a copy of the row from the bottom up so I can modify it for the next row

        }
        return board;
    }
    static char[][] pattern2(int num){
        char[][] board = new char[num][num]; //blank char

        char[] row = new char[num]; //empty char array for row
        for(int rowNum = 0; rowNum < num; rowNum++){
            row[num-rowNum-1] = String.valueOf(num-rowNum).charAt(0); //sets a value for row at num-i-1 (from bottom)
            board[rowNum] = row.clone(); //clones so the row can be modified again

        }
        return board;
    }
    static char[][] pattern3(int num){  //vertically mirrors pattern 1
        char[][] pattern1 = pattern1(num);
        char[][] board = new char[num][num];

        for(int rowNum=0;rowNum<pattern1.length;rowNum++){
            for(int columnNum=0;columnNum<pattern1[rowNum].length;columnNum++){
                board[rowNum][num-columnNum-1] = pattern1[rowNum][columnNum];
            }
        }
        /**
        char[] row = new char[num]; //blank row
        for(int i = 0;i<row.length;i++){
            row[i] = String.valueOf(i+1).charAt(0); //creates the first row, that s full

        }
        for(int i = 0; i < num; i++){
            if(i>0) //or else 0-1 would be out of bounds
            row[i-1]=0; //removes a character
            board[i] = row.clone(); //asigns a clone so the row can be modified for next iteration

        }**/
        return board;
    }
    static char[][] pattern4(int num){
        boolean even = num%2==0; //checks if even to adjust board size
        char[][] board = new char[even?num+1:num][even?num-1:num]; //sets the size of the board with adjustment in case of even
        for(int rowNum=0;rowNum<(board.length/2+(even?0:1));rowNum++){ //goes through half the array
            {
                int current=1; //keep track of which number it's at.
                for (int columnIndex = (board[rowNum].length / 2 - (rowNum)); columnIndex < (board[rowNum].length / 2) + (rowNum + 1); columnIndex++) { //iterate through middle part of row according to size

                    board[rowNum][columnIndex] = String.valueOf(current).charAt(0); //assigns current number to array.
                    board[board.length - rowNum - (even?2:1)] = board[rowNum]; //mirrors char for bottom

                    current++;
                }
            }


        }

        return board;
    }
    static char[][] combinePatterns(char[][][] patterns){ //combines a set of patterns into one 2d array for display purposes
        int space = 5; //space between, must be at least 3
        int num = patterns[0].length; //checks the dimension of the arrays(they should be the same)
        char[][] board = new char[num][num*patterns.length+patterns.length*space]; //creates blank board big enough to contain all patterns

        for(int row=0;row<num;row++){ //go through each row
            int column = 0; //tracks current column location
            for(int i=0;i<patterns.length;i++){ //go through every patern
                char[][] pattern = patterns[i]; //get the pattern's row.
                if(row==0) { //if on the first row, display info on pattern number
                    board[row][column+space-3] = String.valueOf(i+1).charAt(0);
                    board[row][column+space-2] = ')';
                }
                column+=space;
                for(char value:pattern[row]){
                    board[row][column] = value; //sets the relative char at the current location
                    column++;
                }


            }
        }
        return board;
    }
    static void printPattern(char[][] board){ //print a 2d character array
        for(char[] i:board){
            for(char j:i){
                System.out.print(j==0?' ':j); //assigns a space to a null character if necessary and prints the char
            }
            System.out.println();
        }
    }
    public static int getValue(String m, int min,int max){//Get an input value within range
        int i;
        boolean error = false; //to track if it's the first iteration
        System.out.println(m); //print provided message
        do{
            if(error){
                System.out.println("Illegal value"); //say that it's invalid so the user knows to enter a value again
            }
            error = true; //next iteration should display an error
            try {
                i = sc.nextInt(); //get an int from the scanner
            }catch(Exception e){
                i = min-1; //will always make the while condition true if an error occured with the provided input
            }
        }while(i<min  || i>max);
        sc.nextLine(); //properly flush the new line character remaining after the nextInt();
        return i;
    }
}
