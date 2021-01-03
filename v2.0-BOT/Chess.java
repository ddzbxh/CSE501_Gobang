package allWorks;
import java.util.*;

public class Chess{
	public static int size;
	public static int[][] mainList;
	public static String winner;
	public static String space;
	public static int term;
	public static int checkHelp;
	public static int PBMode;
	public static int language;
	public static int a;
	public static int b;
	public static int c;
	public static int xx;
	public static int yy;
	
	public Chess() {
		this.a = 1;
		this.b = 1;
		this.c = 1;
		this.xx = 7;
		this.yy = 7;
		this.size = 15;
		this.mainList = new int[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.mainList[i][j] = 1;
		}	}
		this.winner = "";
		this.space = " ";
		this.term = 2;
		this.checkHelp = 1;
		this.PBMode = 1;
		this.language = 1;
		askLanguage();
		direction();
		main();
	}
	
	public static int random(int inp) {
		Random rand =new Random();
		int i;
		i = rand.nextInt(inp);
		return i;
	}
	
	public static int random(int low, int inp) {
		Random rand =new Random();
		int i;
		while (true) {
			i = rand.nextInt(inp);
			if (i >= low) {
				break;
		}	}
		return i;
	}
	
	public static int input(String inp) {
		System.out.print(inp);
		Scanner input = new Scanner(System.in);
		int in = input.nextInt();
		return in;
	}
	
	public static String inputS(String inp) {
		System.out.print(inp);
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		return in;
	}
	
	public void main() {
		while (this.term != -1) {
			testWin();
			if (this.winner == "black win" || this.winner == "white win") {
				printTheWinner();
			}else {
				printXNums();
				printBoard();
				playOneStep();
				if (this.checkHelp == 1) {
					this.term += 1;
					if (this.PBMode != 1) {
						for (int i = 0; i < this.size; i++) {
							System.out.println("\n");
						}
					}else {
						for (int i = 0; i < 60; i++) {
							System.out.print("-");
						}
						System.out.print("\n");
					}
				}else {
					askHelp();
	}	}	}	}
	
	public void printXNums() {
		if (this.size <= 10) {
			System.out.print("   ");
			for (int i = 0; i < this.size+1; i++) {
				System.out.print(i+"  ");
			}
			System.out.print("\n");
		}else {
			System.out.print("   1  2  3  4  5  6  7  8  9");
			for (int i = 10; i < this.size+1; i++) {
				System.out.print(" "+i);
			}
			System.out.print("\n");
	}	}
	
	public void printBoard() {
		for (int i = 1; i < this.size+1; i++) {
			if (i <= 9) {
				System.out.print(i+" ");
			}else {
				System.out.print(i);
			}
			for (int j = 0; j < this.size; j++) {
				System.out.print(this.space);
				if (this.mainList[i-1][j] == 255) {
					System.out.print("◙");
				}
				if (this.mainList[i-1][j] == 128) {
					System.out.print("⊡");
				}
				if (this.mainList[i-1][j] == 1) {
					System.out.print("◌");
				}
				System.out.print(this.space);
			}
			System.out.print("\n");
	}	}
	
	public void printTheWinner() {
		if (this.winner == "black win" || this.winner == "white win") {
			for (int i = 0; i < 30; i++) {System.out.print("-");}
			System.out.print("\n");
			for (int i = 0; i < 30; i++) {System.out.print("*");}
			System.out.print("\n");
			for (int i = 0; i < 10; i++) {System.out.print(" ");}
			System.out.println(this.winner);
			for (int i = 0; i < 30; i++) {System.out.print("*");}
			System.out.print("\n");
			for (int i = 0; i < 30; i++) {System.out.print("-");}
			System.out.print("\n");
			this.term = -1;
	}	}
	
	public void playOneStep() {
		if (this.term % 2 == 0) {
			while (true) {
				for (int i = 0; i < this.size; i++) {
					for (int j = 0; j < this.size; j++) {
						try {
							if (this.mainList[i][j] == 128) {
								if (this.mainList[i][j+1] == 128) {
									if (this.mainList[i][j+2] == 128) {
										if (this.mainList[i][j+3] == 1 && this.c== 1) {
											this.mainList[i][j+3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i][j-1] == 1 && this.c== 1) {
											this.mainList[i][j-1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 128) {
								if (this.mainList[i+1][j] == 128) {
									if (this.mainList[i+2][j] == 128) {
										if (this.mainList[i+3][j] == 1 && this.c== 1) {
											this.mainList[i+3][j] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i-1][j] == 1 && this.c== 1) {
											this.mainList[i-1][j] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 128) {
								if (this.mainList[i+1][j+1] == 128) {
									if (this.mainList[i+2][j+2] == 128) {
										if (this.mainList[i+3][j+3] == 1 && this.c== 1) {
											this.mainList[i+3][j+3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i-1][j-1] == 1 && this.c== 1) {
											this.mainList[i-1][j-1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 128) {
								if (this.mainList[i+1][j-1] == 128) {
									if (this.mainList[i+2][j-2] == 128) {
										if (this.mainList[i+3][j-3] == 1 && this.c== 1) {
											this.mainList[i+3][j-3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i-1][j+1] == 1 && this.c== 1) {
											this.mainList[i-1][j+1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 128) {
								if (this.mainList[i-1][j-1] == 128) {
									if (this.mainList[i-2][j-2] == 128) {
										if (this.mainList[i-3][j-3] == 1 && this.c== 1) {
											this.mainList[i-3][j-3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i+1][j+1] == 1 && this.c== 1) {
											this.mainList[i+1][j+1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 128) {
								if (this.mainList[i-1][j+1] == 128) {
									if (this.mainList[i-2][j+2] == 128) {
										if (this.mainList[i-3][j+3] == 1 && this.c== 1) {
											this.mainList[i-3][j+3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i+1][j-1] == 1 && this.c== 1) {
											this.mainList[i+1][j-1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 255) {
								if (this.mainList[i][j+1] == 255) {
									if (this.mainList[i][j+2] == 255) {
										if (this.mainList[i][j+3] == 1 && this.c== 1) {
											this.mainList[i][j+3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i][j-1] == 1 && this.c== 1) {
											this.mainList[i][j-1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 255) {
								if (this.mainList[i+1][j] == 255) {
									if (this.mainList[i+2][j] == 255) {
										if (this.mainList[i+3][j] == 1 && this.c== 1) {
											this.mainList[i+3][j] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i-1][j] == 1 && this.c== 1) {
											this.mainList[i-1][j] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 255) {
								if (this.mainList[i+1][j+1] == 255) {
									if (this.mainList[i+2][j+2] == 255) {
										if (this.mainList[i+3][j+3] == 1 && this.c== 1) {
											this.mainList[i+3][j+3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i-1][j-1] == 1 && this.c== 1) {
											this.mainList[i-1][j-1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 255) {
								if (this.mainList[i+1][j-1] == 255) {
									if (this.mainList[i+2][j-2] == 255) {
										if (this.mainList[i+3][j-3] == 1 && this.c== 1) {
											this.mainList[i+3][j-3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i-1][j+1] == 1 && this.c== 1) {
											this.mainList[i-1][j+1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 255) {
								if (this.mainList[i-1][j-1] == 255) {
									if (this.mainList[i-2][j-2] == 255) {
										if (this.mainList[i-3][j-3] == 1 && this.c== 1) {
											this.mainList[i-3][j-3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i+1][j+1] == 1 && this.c== 1) {
											this.mainList[i+1][j+1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
						try {
							if (this.mainList[i][j] == 255) {
								if (this.mainList[i-1][j+1] == 255) {
									if (this.mainList[i-2][j+2] == 255) {
										if (this.mainList[i-3][j+3] == 1 && this.c== 1) {
											this.mainList[i-3][j+3] = 255;
											this.c = 0;
											break;
										}else if (this.mainList[i+1][j-1] == 1 && this.c== 1) {
											this.mainList[i+1][j-1] = 255;
											this.c = 0;
											break;
							}	}	}	}
						}catch(Exception e){}
				}	}
				break;
		}	}
		if (this.term % 2 == 0 && this.c == 1) {
			int a;
			while (true) {
				try {
					a = this.a;
					if (a > 75) {
						if (this.mainList[this.xx][this.yy] != 1) {
							this.xx += 1;
							this.yy += 1;
							this.b += 1;
						}
					}else if (a > 50) {
						if (this.mainList[this.xx][this.yy] != 1) {
							this.xx -= 1;
							this.yy -= 1;
							this.b += 1;
						}
					}else if (a > 25) {
						if (this.mainList[this.xx][this.yy] != 1) {
							this.xx += 1;
							this.yy -= 1;
							this.b += 1;
						}
					}else {
						if (this.mainList[this.xx][this.yy] != 1) {
							this.xx -= 1;
							this.yy -= 1;
							this.b += 1;
					}	}
				}catch(Exception e){
					if (this.b % 3 != 0) {
						this.xx = random(3, 13);
						this.yy = random(3, 13);
						this.a = random(100);
					}
				}
				try {
					if (this.mainList[this.xx][this.yy] == 1) {
						this.mainList[this.xx][this.yy] = 255;
						break;
					}else {
						this.xx = random(3, 13);
						this.yy = random(3, 13);
						this.a = random(100);
					}
				}catch(Exception e){
					this.xx = random(3, 13);
					this.yy = random(3, 13);
					this.a = random(100);
		}	}	}
		if (this.c == 0) {
			this.c = 1;
		}
		if (this.term % 2 == 1) {
			int x;
			int y;
			while (true) {
			    try {
			    	if (this.language == 1) {
			    		x = input("白棋\nX:");
			    		y = input("\nY:");
			    	}else {
			    		x = input("[white]\nX:");
			    		y = input("Y:");
			    	}
			    	x -= 1;
			    	y -= 1;
			    	if (this.mainList[x][y] != 1) {
			    		if (this.language == 1) {
			    			System.out.println("<此处已经落子，请重新输入>");
			    		}else {
			    			System.out.println("<input overlap, please try again>");
			    		}
			    	}else {
			    		this.mainList[x][y] = 128;
			    		break;
			    	}
			    }catch(Exception e){
			    	this.checkHelp = 0;
			    	askHelp();
	}	}	}	}
	
	public void testWin() {
		for (int i = 0; i < this.size-1; i++) {
			for (int j = 0; j < this.size-1; j++) {
				try {
					if (this.mainList[i][j] != 1) {
						if (this.mainList[i][j] == this.mainList[i][j+1]) {
							if (this.mainList[i][j] == this.mainList[i][j+2]) {
								if (this.mainList[i][j] == this.mainList[i][j+3]) {
									if (this.mainList[i][j] == this.mainList[i][j+4]) {
										if (this.mainList[i][j] == 128) {
											this.winner = "white win";
										}if (this.mainList[i][j] == 255) {
											this.winner = "black win";
					}	}	}	}	}	}
				}catch(Exception e){}
				try {
					if (this.mainList[i][j] != 1) {
						if (this.mainList[i][j] == this.mainList[i+1][j]) {
							if (this.mainList[i][j] == this.mainList[i+2][j]) {
								if (this.mainList[i][j] == this.mainList[i+3][j]) {
									if (this.mainList[i][j] == this.mainList[i+4][j]) {
										if (this.mainList[i][j] == 128) {
											this.winner = "white win";
										}if (this.mainList[i][j] == 255) {
											this.winner = "black win";
					}	}	}	}	}	}
				}catch(Exception e){}
				try {
					if (this.mainList[i][j] != 1) {
						if (this.mainList[i][j] == this.mainList[i+1][j+1]) {
							if (this.mainList[i][j] == this.mainList[i+2][j+2]) {
								if (this.mainList[i][j] == this.mainList[i+3][j+3]) {
									if (this.mainList[i][j] == this.mainList[i+4][j+4]) {
										if (this.mainList[i][j] == 128) {
											this.winner = "white win";
										}if (this.mainList[i][j] == 255) {
											this.winner = "black win";
					}	}	}	}	}	}
				}catch(Exception e){}
				try {
					if (this.mainList[i][j] != 1) {
						if (this.mainList[i][j] == this.mainList[i+1][j-1]) {
							if (this.mainList[i][j] == this.mainList[i+2][j-2]) {
								if (this.mainList[i][j] == this.mainList[i+3][j-3]) {
									if (this.mainList[i][j] == this.mainList[i+4][j-4]) {
										if (this.mainList[i][j] == 128) {
											this.winner = "white win";
										}if (this.mainList[i][j] == 255) {
											this.winner = "black win";
					}	}	}	}	}	}
				}catch(Exception e){}
				try {
					if (this.mainList[i][j] != 1) {
						if (this.mainList[i][j] == this.mainList[i-1][j+1]) {
							if (this.mainList[i][j] == this.mainList[i-2][j+2]) {
								if (this.mainList[i][j] == this.mainList[i-3][j+3]) {
									if (this.mainList[i][j] == this.mainList[i-4][j+4]) {
										if (this.mainList[i][j] == 128) {
											this.winner = "white win";
										}if (this.mainList[i][j] == 255) {
											this.winner = "black win";
					}	}	}	}	}	}
				}catch(Exception e){}
				try {
					if (this.mainList[i][j] != 1) {
						if (this.mainList[i][j] == this.mainList[i-1][j-1]) {
							if (this.mainList[i][j] == this.mainList[i-2][j-2]) {
								if (this.mainList[i][j] == this.mainList[i-3][j-3]) {
									if (this.mainList[i][j] == this.mainList[i-4][j-4]) {
										if (this.mainList[i][j] == 128) {
											this.winner = "white win";
										}if (this.mainList[i][j] == 255) {
											this.winner = "black win";
					}	}	}	}	}	}
				}catch(Exception e){}
	}	}	}
	
	public void askHelp() {
		if (this.language == 1) {
    		System.out.println("<无法识别的输入，是否需要帮助？>");
    	}else {
    		System.out.println("<Unrecognized input, do you need help?>");
    	}
		while (this.checkHelp == 0) {
			for (int i = 0; i < 30; i++) {System.out.print("-");}
			System.out.print("\n");
			while (true) {
				try {
					int inp;
					if (this.language == 1) {
						inp = input("1)游戏\n2)界面参数\n3)Language\n4)返回\n>>>");
					}else {
						inp = input("1)About game\n2)Change parameter\n3)调整语言\n4)Back\n>>>");
					}
					boolean check = false;
					if (inp == 1) {
						check = askGame();
					}else if (inp == 2) {
						check = askPara();
					}else if (inp == 3) {
						askLanguage();
						check = true;
					}else if (inp == 4) {
						check = true;
					}else {
						if (this.language == 1) {
							System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
						}else {
							System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
					}	}
					if (check) {
						this.checkHelp = 1;
						break;
					}else {
						for (int i = 0; i < 30; i++) {System.out.print("-");}
						System.out.print("\n");
					}
				}catch(Exception e){
					if (this.language == 1) {
						System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
					}else {
						System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
	}	}	}	}	}
	
	public boolean askGame() {
		while (true) {
			try {
				int inp;
				if (this.language == 1) {
					inp = input("1)重新开始\n2)返回上级\n>>>");
				}else {
					inp = input("1)Restart\n2)Back\n>>>");
				}
				if (inp == 1) {
					this.mainList = new int[this.size][this.size];
					for (int i = 0; i < this.size; i++) {
						for (int j = 0; j < this.size; j++) {
							this.mainList[i][j] = 1;
					}	}
					this.winner = "";
					this.space = " ";
					this.term = 2;
					printBoard();
					return true;
				}else if (inp == 2) {
					return false;
				}else {
					if (this.language == 1) {
						System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
					}else {
						System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
				}	}
			}catch(Exception e){
			if (this.language == 1) {
				System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
			}else {
				System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
	}	}	}	}
	
	public boolean askPara() {
		while (true) {
			try {
				int inp;
				if (this.language == 1) {
					inp = input("1)调整间隔字符\n2)棋盘刷新方式\n3)返回上级\n>>>");
				}else {
					inp = input("1)Change the space letter\n2)Checkerboard refresh mode\n3)Back\n>>>");
				}
				if (inp == 1) {
					if (this.language == 1) {
						this.space = inputS("间隔字符:");
					}else {
						this.space = inputS("the space letter:");
					}
					return true;
				}else if (inp == 2) {
					askPB();
					return true;
				}else if (inp == 3) {
					return false;
				}else {
					if (this.language == 1) {
						System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
					}else {
						System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
					}	}
			}catch(Exception e){
			if (this.language == 1) {
				System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
			}else {
				System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
	}	}	}	}
	
	public void askPB() {
		while (true) {
			try {
				int inp;
				if (this.language == 1) {
					inp = input("1)横线分割模式\n2)换行模式\n>>>");
				}else {
					inp = input("1)Horizontal division mode\n2)Multiple newline mode\n>>>");
				}
				if (inp == 1) {
					this.PBMode = 1;
					break;
				}else if (inp == 2) {
					this.PBMode = 0;
					break;
				}else {
					if (this.language == 1) {
						System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
					}else {
						System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
				}	}
			}catch(Exception e){
			if (this.language == 1) {
				System.out.println("<无法识别的输入，请输入选项以选择，如1或2>");
			}else {
				System.out.println("<input error, try again, give your choose as 1, 2, etc.>");
	}	}	}	}
	
	public void askLanguage() {
		while (true) {
			try {
				int inp = input("1)简体中文\n2)English\n>>>");
				if (inp == 1) {
					this.language = 1;
					break;
				}else if (inp == 2) {
					this.language = 2;
					break;
				}else {
					System.out.println("Please give your choose by letter as 1, 2, etc.\n请输入选项以选择，如1或2");
				}
			}catch(Exception e){
			System.out.println("Please give your choose by letter as 1, 2, etc.\n请输入选项以选择，如1或2");
	}	}	}
	
	public void direction() {
		if (this.language == 1) {
			for (int i = 0; i < 30; i++) {System.out.print("-");}
			System.out.print("\n");
			System.out.println("project3，《五子棋》\n1.此为单人模式\n2.可识别的输入格式为数字，不规范的输入将被驳回\n3.在已经落子的棋位下棋将被驳回\n4.当有一方胜出，将会自动结束\n5.错误的输入将会呼出设置");
			for (int i = 0; i < 30; i++) {System.out.print("-");}
			System.out.print("\n");
		}else {
			for (int i = 0; i < 30; i++) {System.out.print("-");}
			System.out.print("\n");
			System.out.println("project3, Gobang\n1. This is the solo mode, you will play against a BOT\n2. The recognizable input format is arabic numerals\n3. Select locations that have already been selected will be rejected\n4. When one side wins, it automatically ends\n5. Incorrect input will result to set");
			for (int i = 0; i < 30; i++) {System.out.print("-");}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		Chess main = new Chess();
	}	}