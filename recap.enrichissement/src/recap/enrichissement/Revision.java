package recap.enrichissement;

import java.util.Scanner; //IMPORTER LE SCANNER POUR LA SAISIE

public class Revision {

	static Scanner saisie = new Scanner(System.in);
	static String sUserSaisi;
	static String[][] usersPasswords = { {"tommypaulhus", "frederikbacon", "jeanfrancoislaroche", "maximetremblay"}, {"abc12", "def45", "ghi67", "jkl89"}, {"100", "200", "300", "400"} };
	static String sEffetLoading = "Chargement...";
	static char cLettre;
	static int iID;
	static boolean bQuitter = false;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		//PARAMETRES
		//https://www.w3schools.com/java/java_methods_param.asp#:~:text=Parameters%20act%20as%20variables%20inside,separate%20them%20with%20a%20comma.
		//CONVERSION/CASTING
		//OVERLOAD (MEME METHODE NOMS DIFFERENTS)
		
		
		//LOGIN - BOUCLES
		connecterUtilisateur();
		System.out.println("Bonjour, " +sUserSaisi+ " !");
		verifierMotDePasse();
		

		//CHAR AT
		cLettre = sEffetLoading.charAt(1);
		System.out.println(cLettre);
		
		//MENU
		do
		{
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("-- M E N U --");
		System.out.println("1 - Changer de mot de passe.");
		System.out.println("2 - Accèder à mon compte.");
		System.out.println("0 - Quitter.");
		System.out.println("-------------------------------------------------------------");
		
		int iChoix = saisie.nextInt();
		
		switch(iChoix)
		{
		case 1:
			afficherEffetChargement();	
			changerMotDePasse();
			break;
			
		case 2: 
			afficherEffetChargement();	
			verifierMontant();
			break;
			
		case 0:
			System.exit(0);
			break;
		
		}
		
		}while(bQuitter == false);
	}
	private static void afficherEffetChargement()
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		
		for(int i = 0; i < sEffetLoading.length(); i++)
		{
			cLettre = sEffetLoading.charAt(i);
			System.out.print(cLettre);
			try 
			{
				Thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------");
	}

	private static String connecterUtilisateur() 
	{
		boolean bTrouve = false;

		do 
		{
			  System.out.println("Entrez votre nom d'utilisateur :");
			  sUserSaisi = saisie.nextLine();
			  
			  for (int i = 0; i < usersPasswords.length; i++) 
			  {
				    if (usersPasswords[0][i].equals(sUserSaisi)) 
				    {
				        bTrouve = true;
				        break;  // Si l'élément est trouvé, on sort de la boucle
				    }
				    
				    iID = i+1;
			  }
		}
		
		while (bTrouve == false);
		
		
		return sUserSaisi; //NECESSAIRE ?
	}
	
	private static void verifierMotDePasse() 
	{
		
		boolean bTrouve = false; //VARIABLE BOOLEENNE QUI SERVIRA DE CONFIRMATION LORSQUE L'UTILISATEUR TROUVE LE MOT DE PASSE
		String sMotDePasse; //VARIABLE STRING POUR CE QUE L'UTILISATEUR VA SAISIR COMME MOT DE PASSE
		
		do //EXÉCUTE AU MOINS UNE FOIS ET TANT QUE ...
		{
			System.out.println("Entrez votre mot de passe.");
			
			sMotDePasse = saisie.nextLine();
			  
			  for (int i = 0; i < usersPasswords.length; i++) 
			  {
				    if (usersPasswords[1][i].equals(sMotDePasse) && usersPasswords[0][i].equals(sUserSaisi)) //SI LE MOT DE PASSE SAISI CORRESPOND 
				    {
				        bTrouve = true;
				        System.out.println("Connecté !");
				        break;  // Si l'élément est trouvé, on sort de la boucle
				    }
			  }
			  
			  if (bTrouve == false)
			  {
				  System.out.println("Inexact, réessayez !");
			  }
		}
		
		while (bTrouve == false); //... TANT QUE bTrouve EST FAUX
		
	}
	private static void verifierMontant()
	{
		switch(sUserSaisi) 
		{
		  case "tommypaulhus":
			  System.out.println(usersPasswords[2][0]+"$");
		    break;
		    
		  case "frederikbacon":
			  System.out.println(usersPasswords[2][1]+"$");
		    break;
		    
		  case "jeanfrancoislaroche":
			  System.out.println(usersPasswords[2][2]+"$");
		    break;
		    
		  case "maximetremblay":
			  System.out.println(usersPasswords[2][3]+"$");
		    break;
		    
		  default:
		    // code block
		}
	}
	private static void changerMotDePasse()
	{
		String sMotDePasseT; //VARIABLE STRING POUR CE QUE L'UTILISATEUR VA SAISIR COMME MOT DE PASSE
		String sNouveauMotDePasse; //VARIABLE STRING POUR CE QUE L'UTILISATEUR VA SAISIR COMME NOUVEAU MOT DE PASSE
		boolean bTrouve = false; //VARIABLE BOOLEENNE QUI SERVIRA DE CONFIRMATION LORSQUE L'UTILISATEUR TROUVE LE MOT DE PASSE
		
		//WHAT THE HECK IS THIS SHOOT
		
			if(bTrouve == false)
			{
				System.out.println("Entrez votre mot de passe actuel.");
				sMotDePasseT = saisie.nextLine();
				
				if (sMotDePasseT.equals(usersPasswords[1][iID])) //SI LE MOT DE PASSE SAISI CORRESPOND 
			    {
			        bTrouve = true;
			        System.out.println("Entrez votre nouveau mot de passe :");
			        sNouveauMotDePasse = saisie.nextLine();
			        usersPasswords[1][iID] = sNouveauMotDePasse;
			        System.out.println("Changement de mot de passe effectué.");
			    } 
			}
			
			while(bTrouve == false)
			{
				    
				  //System.out.println("Entrez votre mot de passe actuel.");
				  sMotDePasseT = saisie.nextLine();
				
			  if (sMotDePasseT.equals(usersPasswords[1][iID])) //SI LE MOT DE PASSE SAISI CORRESPOND 
			    {
			        bTrouve = true;
			        System.out.println("Entrez votre nouveau mot de passe :");
			        sNouveauMotDePasse = saisie.nextLine();
			        usersPasswords[1][iID] = sNouveauMotDePasse;
			        System.out.println("Changement de mot de passe effectué.");
			        break;  // Si l'élément est trouvé, on sort de la boucle
			    } 
			  else {
				  System.out.println("Inexact, réessayez !");
			  }
		
		}
		
	}
}

//2FA - ??? changement pass bd