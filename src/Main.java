import java.util.Scanner;

public class Main {
	static int Woods;
	static String KI;
	static String Player;
	static int AmZug;
	static int Taken;
	
	public static void main(String[] args) {
		Woods = 21;
		
		KI = "Computer";
		
		System.out.println("Willkommen");
		System.out.println("Dies ist das Nimh-Spiel");
		System.out.println("\n");
		System.out.println("Regeln:");
		System.out.println("Abwechselnd zieht der Spieler und der Computer 1, 2 oder 3 Hölzer.");
		System.out.println("Gestartet wird mit einer Anzahl, die Sie bestimmen. Wer das letzte ziehen muss, hat verloren.");
		System.out.println("\n");
		System.out.println("Um Hölzer zu ziehen, warte auf die Aufforderung und gebe 1 2 oder 3 ein und bestätige mit Enter");
		System.out.println("Wie lautet dein Name?");
		
		Scanner scanner = new Scanner(System.in);
		Player = scanner.nextLine();
		
//		System.out.println(Player);
		if(Player.equals("Chuck Norris")) {
			System.out.println(Player + " hat " + KI + " besiegt.");
			System.exit(0);
		}
		
		System.out.println("Mit wievielen Hölzern soll gespielt werden?");
		
		while((Woods = StringToInt(scanner.nextLine())) == 0) {
			System.out.println("Keine gültige Auswahl. Bitte nur Zahlen über 0!");
		}
		
//		System.out.println(Player);
		if(Player == null || Player.equals("")) {
			Player = "Player";
		}
		

		
		AmZug = 1;
		while(Woods > 1) {
			if(Woods > 1) {
				System.out.println("\n");
				System.out.println("Restliche: " + Woods);
				
				System.out.println(Player + " ist am Zug");
				System.out.println("Wieviele nimmst du?");
				
				Taken = ConvertEntry(scanner.nextLine());
				while (Taken != 1 && Taken != 2 && Taken != 3) {
					System.out.println("Keine gültige Auswahl! Bitte gib nur 1 2 oder 3 ein!");
					Taken = ConvertEntry(scanner.nextLine());
				}
				
				Woods -= Taken;
				AmZug = 0;
			}

			if(Woods > 1) {
				System.out.println("\n");
				System.out.println("Restliche: " + Woods);
				
				System.out.println(KI + " ist am Zug");
				
				Taken = GetToTake(Woods, Taken);
				System.out.println(KI + " nimmt " + Taken);
				Woods -= Taken;
				AmZug = 1;
			}
		}
		
		System.out.println("\n");
		System.out.println("Restliche: " + Woods);
		
		if(AmZug == 1){
			System.out.println(KI + " hat " + Player + " besiegt!");
		}else {
			System.out.println(Player + " hat " + KI + " besiegt!");
		}
		
	}
	
	private static int ConvertEntry(String entry) {
		int converted;
		switch(entry) {
		case "1":
			converted = 1;
			break;
		case "2":
			converted = 2;
			break;
		case "3":
			converted = 3;
			break;
		case "eins":
			converted = 1;
			break;
		case "zwei":
			converted = 2;
			break;
		case "drei":
			converted = 3;
			break;
		case "eins du Hurensohn":
			System.out.println("Selber Hurensohn!");
			converted = 1;
			break;
		case "zwei du Hurensohn":
			System.out.println("Selber Hurensohn!");
			converted = 2;
			break;
		case "drei du Hurensohn":
			System.out.println("Selber Hurensohn!");
			converted = 3;
			break;
		case "Ich nehm die Nummer drei":
			System.out.println("Die ham mi g'hoit um zu lenken, net um zu denken. Nummer drei!");
			converted = 3;
			break;
		default:
			converted = 0;
			break;
		}
		return converted;
	}
	
	private static int StringToInt(String entry) {
		Integer temp;
		try {
			temp = new Integer(entry);
		}catch(Exception e) {
			return 0;
		}
		return temp;
	}

	private static int GetToTake(int Left, int Took) {
		int Differenz;
		int Counter = Left-1;
		
		while((Counter % 4)!= 0) {
			Counter -= 1;
		}
		
		Differenz = (Left - Counter) - 1;
		
		if((Differenz < 4) && (Differenz > 0)) {
			return Differenz;
		}else if( Differenz > 0){
			return 1;
		}else if(Differenz < 4) {
			return 3;
		}
		
//		if(Left > 5) {
//			if(((Left - 2) % 4) == 0) return 1;
//			if(((Left - 3) % 4) == 0) return 2;
//			if(((Left - 4) % 4) == 0) return 3;
//		}else {
//			if((Left - 1) == 1) return 1;
//			if((Left - 2) == 1) return 2;
//			if((Left - 3) == 1) return 3;
//		}
			
		System.out.println("Ich glaube einer von uns schummelt. Und ich bin sicher, dass ich es nicht bin.");
		return 1;
	}
}
 