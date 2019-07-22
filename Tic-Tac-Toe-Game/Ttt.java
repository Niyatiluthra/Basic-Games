import java.util.*;
class Board
{
    char board[][] = new char[5][5];
    int fill[] = new int[10];
    Board()
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(j==1||j==3)
                    board[i][j]='|';
                else if(i==1||i==3)
                board[i][j]='-';
                else 
                    board[i][j]=' ';
            }
        }
    }
    void printBoard()
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
    boolean fillBoard(int x, char set)
    {
        fill[x]=1;
        switch(x)
        {
            case 1: 
                board[0][0]=set;
                break;
            case 2: 
                board[0][2]=set;
                break;
            case 3: 
                board[0][4]=set;
                break;
            case 4: 
                board[2][0]=set;
                break;
            case 5: 
                board[2][2]=set;
                break;
            case 6: 
                board[2][4]=set;
                break;
            case 7: 
                board[4][0]=set;
                break;
            case 8: 
                board[4][2]=set;
                break;
            case 9: 
                board[4][4]=set;
                break;
        }
        printBoard();
        // if (checkRows(x,set) || checkColumns(x,set) || checkDiagonals(x,set))
        //     return 1;
        // else 
        //     return 0;
        return (checkRows(x,set) || checkColumns(x,set) || checkDiagonals(x,set));
    }
    boolean checkRows(int x,char set)
    {
        if((x==1)||(x==4)||(x==7))
        {
            if(board[0][0]==set&&board[2][0]==set&&board[4][0]==set)
                return true;
            else 
                return false;
        }
        else if((x==2)||(x==5)||(x==8))
        {
            if(board[0][2]==set&&board[2][2]==set&&board[4][2]==set)
                return true;
            else 
                return false;
        }
        else 
        {
            if(board[0][4]==set&&board[2][4]==set&&board[4][4]==set)
                return true;
            else 
                return false;
        }
    }
    boolean checkColumns(int x,char set)
    {
        if((x==1)||(x==2)||(x==3))
        {
            if(board[0][0]==set&&board[0][2]==set&&board[0][4]==set)
                return true;
            else 
                return false;
        }
        else if((x==4)||(x==5)||(x==6))
        {
            if(board[2][0]==set&&board[2][2]==set&&board[2][4]==set)
                return true;
            else 
                return false;
        }
        else 
        {
            if(board[4][0]==set&&board[4][2]==set&&board[4][4]==set)
                return true;
            else 
                return false;
        }
    }
    boolean checkDiagonals(int x,char set)
    {
        if((x==1)||(x==5)||(x==9))
        {
            if(board[0][0]==set&&board[2][2]==set&&board[4][4]==set)
                return true;
            else 
                return false;
        }
        else if((x==3)||(x==5)||(x==7))
        {
            if(board[0][4]==set&&board[2][2]==set&&board[4][0]==set)
                return true;
            else 
                return false;
        }
        return false;
    }
    boolean check(int x)
    {
        if(fill[x]==1)
            return false;
        else 
            return true;
    }
}
public class Ttt
{
    public static void main (String[] args)
    {
        Board br = new Board();
        br.printBoard();
        int currentPlayer = 1;
        System.out.println("Welcome to Tic Tac Toe! \nPress 1 - 9 to fill your place with your sign ! \nPlayer 1 : X \nPlayer 2 : O");
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean valid=true;
        int flag=0;
        while(n<9)
        {
            int turn = n%2;
            turn++;
            System.out.println("Player "+ turn +" turn");
            int x = sc.nextInt();
            char set;
            if(turn == 1)
                set='X';
            else 
                set='O';
            valid = br.check(x);
            if(x>9||x<0)
                valid=false;
            if(valid == false)
            {
                System.out.println("Wrong move");
                continue;
            }
            else 
            {
                boolean result = br.fillBoard(x,set);

                if(result==true)
                {
                    System.out.println("Player "+turn+" won!");
                    flag = 1;
                    break;
                }
                n++;
            }
        }
        
        if(flag==0)
        {
            System.out.println("Match Draw");
        }
    }
} 