import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Universitate {
    public static Scanner obj = new Scanner(System.in);
    public static int nivelMP = 0;
    public static DBConection conection = new DBConection();

    //Frontend program --> Meniu Principal:
    public static void meniuPrincipal(){
        System.out.println("\tMeniu Principal:");
        System.out.println("1. Management Facultati;");
        System.out.println("2. Management Grupe;");
        System.out.println("3. Management Studenti;");
        System.out.println("4. Close Application;");

        switch (obj.next()) {
            case "1":
                nivelMP = 1;
                break;
            case "2":
                nivelMP = 2;
                break;
            case "3":
                nivelMP = 3;
                break;
            case "4":
                String input;
                boolean k = true;

                while(k){
                    cls();
                    System.out.println("Doriti sa iesiti din program? ");
                    System.out.println("<Y>/<N>");
                    input = obj.next();
                    switch(input){
                        case "Y":
                        case "y":
                            System.out.println("Iesire din program...");
                            System.exit(0);
                            break;
                        case "N":
                        case "n":
                            k = false;
                            break;
                    }
                }
                break;
        }
    }

    //Frontend program --> Meniu Principal\Management Facultati:
    public static  void meniuFacultate(){
        System.out.println("\tManagement Facultate:");
        System.out.println("1. Inregistreaza Facultate;");
        System.out.println("2. Modifica Facultate;");
        System.out.println("3. Elimina Facultate;");
        System.out.println("4. Afiseaza toate facultatile;");
        System.out.println("5. Inapoi;");


        switch (obj.next()) {
            case "1":
                nivelMP = 11;
                break;
            case "2":
                nivelMP = 12;
                break;
            case "3":
                nivelMP = 13;
                break;
            case "4":
                nivelMP = 14;
                break;
            case "5":
                nivelMP = 0;
                break;
        }
    }

    //Frontend program --> Meniu Principal\Management Grupe:
    public static  void meniuGrupe(){
        System.out.println("\tManagement Grupe:");
        System.out.println("1. Inregistreaza Grupa;");
        System.out.println("2. Modifica Grupa;");
        System.out.println("3. Elimina Grupa;");
        System.out.println("4. Afiseaza toate Grupele;");
        System.out.println("5. Inregistreaza Test;");
        System.out.println("6. modifica Test;");
        System.out.println("7. Anulare Test;");
        System.out.println("8. Inapoi;");

        switch (obj.next()) {
            case "1":
                nivelMP = 21;
                break;
            case "2":
                nivelMP = 22;
                break;
            case "3":
                nivelMP = 23;
                break;
            case "4":
                nivelMP = 24;
                break;
            case "5":
                nivelMP = 25;
                break;
            case "6":
                nivelMP = 26;
                break;
            case "7":
                nivelMP = 27;
                break;
            case "8":
                nivelMP = 0;
                break;
        }
    }

    //Frontend program --> Meniu Principal\Management Studenti:
    public static  void meniuStudenti(){
        System.out.println("\tManagement Studenti:");
        System.out.println("1. Inregistreaza Student;");
        System.out.println("2. Modifica Student;");
        System.out.println("3. Elimina Student;");
        System.out.println("4. Afiseaza lista de Studenti;");
        System.out.println("5. Noteaza Student;");
        System.out.println("6. Modifica Nota;");
        System.out.println("7. Anuleaza Nota;");
        System.out.println("8. Inapoi;");

        switch (obj.nextInt()) {
            case 1:
                nivelMP = 31;
                break;
            case 2:
                nivelMP = 32;
                break;
            case 3:
                nivelMP = 33;
                break;
            case 4:
                nivelMP = 34;
                break;
            case 5:
                nivelMP = 35;
                break;
            case 6:
                nivelMP = 36;
                break;
            case 7:
                nivelMP = 37;
                break;
            case 8:
                nivelMP = 0;
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        cls();
        //noinspection InfiniteLoopStatement
        while (true){
            // Management nivel 1:
            switch(nivelMP) {
                case 1:
                    meniuFacultate();
                    break;
                case 11:
                    insertFacultate();
                    break;
                case 12:
                    if (!conection.isEmptyFacultate()) {
                        updateFacultate();
                    } else {
                        System.out.println("Nu aveti inregistrata nici o facultate!");
                        nivelMP = 1;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 13:
                    if (!conection.isEmptyFacultate()) {
                        deleteFacultate();
                    } else {
                        System.out.println("Nu aveti inregistrata nici o facultate!");
                        nivelMP = 1;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 14:
                    if (!conection.isEmptyFacultate()) {
                        showFacultate();
                    } else {
                        System.out.println("Nu aveti inregistrata nici o facultate!");
                        nivelMP = 1;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
            }
            cls();

            // Management nivel 2:
            switch (nivelMP){
                case 2:
                    meniuGrupe();
                    break;
                case 21:
                    if(!conection.isEmptyFacultate()){
                        insertGrupa();
                    } else {
                        System.out.println("Nu aveti inregistrata nici o facultate!");
                        nivelMP = 2;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 22:
                    if(!conection.isEmptyGrupa()){
                        updateGrupa();
                    }else {
                        System.out.println("Nu aveti inregistrata nici o grupa!");
                        nivelMP = 2;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 23:
                    if(!conection.isEmptyGrupa()){
                        deleteGrupa();
                    }else {
                        System.out.println("Nu aveti inregistrata nici o grupa!");
                        nivelMP = 2;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 24:
                    if(!conection.isEmptyGrupa()){
                        showGrup();
                    }else {
                        System.out.println("Nu aveti inregistrata nici o grupa!");
                        nivelMP = 2;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
            }
            cls();

            // Management nivel 3:
            switch (nivelMP){
                case 3:
                    meniuStudenti();
                    break;
                case 31:
                    if(!conection.isEmptyGrupa()){
                        insertStud();
                    }else {
                        System.out.println("Nu aveti inregistrata nici o grupa!");
                        nivelMP = 3;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 32:
                    if(!conection.isEmptyStud()){
                        updateStud();
                    }else {
                        System.out.println("Nu aveti inregistrata nici un student!");
                        nivelMP = 3;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 33:
                    if(!conection.isEmptyStud()){
                        deleteStud();
                    }else {
                        System.out.println("Nu aveti inregistrata nici un student!");
                        nivelMP = 3;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 34:
                    if(!conection.isEmptyStud()){
                        showStud();
                    }else {
                        System.out.println("Nu aveti inregistrata nici un student!");
                        nivelMP = 3;
                        System.out.println("\nIntrodu ceva de la tastatura pentru meniul precedent:");
                        obj.next();
                    }
                    break;
                case 35:

                    break;
                case 36:

                    break;
                case 37:

                    break;
                case 38:

                    break;
            }
            cls();

            // Management nivel 0:
            switch (nivelMP){
                case 0:
                    meniuPrincipal();
                    break;
            }
            cls();
        }
    }
////////////// Facultate Methods //////////////

    public static void showFacultate(){
        boolean k = true;

        while (k){
            cls();
            System.out.println("Lista facultatilor:");
            conection.showFacultate();

            System.out.println("\nIntrodu 1 pentru meiul precedent: ");
            if(obj.next().equals("1")){
                k = false;
                nivelMP = 1;
            }
        }
    }

    public static void insertFacultate(){
        System.out.println("Inregistrare Facultate:");
        String facultate;

        System.out.println("Introdu denumirea facultatii:");
        facultate = obj.next();
        if(conection.existFacultate(facultate)){
            System.out.println("Facultatea '" + facultate + "' deja exista!!!");
        }else {
            conection.insertFacultate(facultate);
        }
        nivelMP = 1;
        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
        obj.next();
    }

    public static void updateFacultate(){
        int id = selectFacultate();
        if(id != 0){

            boolean k = true;
            boolean pause = false;
            String facultate;

            while (k){
                cls();
                System.out.println("Modificare facultate:");
                System.out.println("Facultatea - " + conection.toStringFacultate(id));
                System.out.println("Introdu denumirea noua a facultatii, sau 0  pentru meniul precedent:");
                facultate = obj.next();
                if(facultate.equals("0")){
                    k = false;
                }else {
                    if(conection.existFacultate(facultate)){
                        System.out.println("\nFacultatea '" + facultate + "' deja exista!");
                        k = false;
                        pause = true;
                    }else {
                        conection.updateFacultate(id,facultate);
                        System.out.println("\nFacultate a fost modificata in '" + facultate + "';");
                        k = false;
                        pause = true;
                    }
                }
            }
            nivelMP = 1;
            if(pause){
                System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                obj.next();
            }
        } else {
            nivelMP = 1;
        }
    }

    public static void deleteFacultate(){
        int id = selectFacultate();
        boolean k = true;
        String facultate = conection.toStringFacultate(id);

        while (k){
            cls();
            System.out.println("Eliminare facultate:");
            System.out.println("Facultatea - " + facultate);
            System.out.println("\n!!! ATENTIE TOATA INFORMATIA LEGATA DE ACEASTA FACULTATE VA FI PIERDUTA !!!");
            System.out.println("Doriti sa continuati eliminarea?");
            System.out.println("<Y>/<N>");
            switch (obj.next()){
                case "Y":
                case "y":
                    conection.deleteFacultate(id);
                    System.out.println("Facultate '" + facultate + "' a fost eliminata;");
                    k = false;
                    break;
                case "N":
                case "n":
                    k = false;
                    break;
            }
        }
        nivelMP = 1;
        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
        obj.next();
    }

    public static int selectFacultate(){
        int id = 0;
        boolean k = true;
        while (k){
            cls();
            switch (nivelMP){
                case 12:
                    System.out.println("Modificare Facultate:");
                    break;
                case 13:
                    System.out.println("Eliminare Facultate:");
                    break;
                case 21:
                    System.out.println("Inregistrare Grupa:");
                    break;
            }
            System.out.println("Select facultate:");
            conection.showFacultate();
            System.out.println("\nAlege o facultate dupa id, sau introdu 0 pentru meniul precedent: ");
            id = obj.nextInt();
            if(conection.existFacultate(id)){
               k = false;
            }else if(id == 0){
                k = false;
            }
        }
        return id;
    }

////////////// Grupa Methods //////////////

    public static void showGrup(){
        boolean k = true;
        while (k){
            cls();
            System.out.println("Lista grupelor:");
            conection.showGrup();
            System.out.println("\nIntrodu 1 pentru meniul precedent:");
            if(obj.next().equals("1")){
                nivelMP = 2;
                k = false;
            }
        }
    }

    public static void insertGrupa(){
        boolean rep = true;
        while (rep){
            System.out.println("Inregistrare Grupa:");
            int facultateId = selectFacultate();

            if(facultateId != 0){
                String grupa;
                int anForm = 0;
                String limba = "";
                boolean k = true;

                cls();
                System.out.println("Inregistrare Grupa:");
                System.out.println("Introdu denumirea grupei:");
                grupa = obj.next();

                while (k){
                    try{
                        cls();
                        System.out.println("Inregistrare Grupa:");
                        System.out.println("Intrudu anul in care este formata grupa:");
                        anForm = obj.nextInt();
                        k = false;
                    }catch (InputMismatchException e){
                        System.out.println("\nAnul in care este formata grupa Trebue sa fie un numar intreg!");
                        System.out.println("Mai incearca o data:");
                        System.out.println("\nIntrodu ceva de la tastatura pentru a ontinua:");
                        obj.next();
                    }
                }

                k = true;
                while (k){
                    cls();
                    System.out.println("Inregistrare Grupa:");
                    System.out.println("Alege o limba:");
                    System.out.println("Ro, Ru, En;\n");
                    switch (obj.next()){
                        case "RO":
                        case "Ro":
                        case "ro":
                        case "1":
                            limba = "ro";
                            k = false;
                            break;
                        case "RU":
                        case "Ru":
                        case "ru":
                        case "2":
                            limba = "ru";
                            k = false;
                            break;
                        case "EN":
                        case "En":
                        case "en":
                        case "3":
                            limba = "en";
                            k = false;
                            break;
                    }
                }

                if(conection.existGrupa(facultateId,grupa,anForm,limba)){
                    k = true;
                    while (k){
                        cls();
                        System.out.println("Grupa - " +
                                conection.toStringGrupa(
                                        conection.getGrupaId(facultateId,grupa,anForm,limba)
                                ) + " deja exista!"
                        );
                        System.out.println("\n1. Mai incearca;");
                        System.out.println("2. Meniul precedent;");
                        switch (obj.next()){
                            case "1":
                                k = false;
                                break;
                            case  "2":
                                k = false;
                                nivelMP = 2;
                                rep = false;
                                break;
                        }
                    }
                }else {
                    cls();
                    conection.insertGrupa(facultateId,grupa,anForm,limba);
                    System.out.println("Ati inregistrat grupa  '" + grupa + anForm + limba + "' la facultatea " +
                            conection.toStringFacultate(facultateId) + ";");
                    nivelMP = 2;
                    System.out.println("\nIntrodu ceva de la tastatura pentru a continua;");
                    obj.next();
                    rep = false;
                }
            } else{
                rep = false;
                nivelMP = 2;
            }
        }
    }

    public static void updateGrupa(){
        int id = selectGrupa();
        if(id != 0){
            int facultate_id = conection.getGrupaFacultId(id);
            String grupa = conection.getGrupa(id);
            int anForm = conection.getGrupaAn(id);
            String limba = conection.getGrupaLimba(id);
            String facultate;
            boolean k = true;

            while (k){
                cls();
                System.out.println("Modificare Grupa:");
                System.out.println("Id[" + id + "] - "+ grupa +
                        anForm + limba + " - " + conection.toStringFacultate(facultate_id) + ":");
                System.out.println("\n1. Modifica denumirea grupei;");
                System.out.println("2. Modifica anul formarii grupei;");
                System.out.println("3. Modifica limba grupei;");
                System.out.println("4. Alege o alta facultate;");
                System.out.println("5. Inapoi;");

                switch (obj.next()) {
                    case "1":
                        cls();
                        System.out.println("Modificare Grupa:");
                        System.out.println("Id[" + id + "] - "+ grupa +
                                anForm + limba + " - " + conection.toStringFacultate(facultate_id) + ":");
                        System.out.println("Introdu denumirea noua grupei:");
                        grupa = obj.next();
                        if(!conection.existGrupa(facultate_id,grupa,anForm,limba)){
                            conection.updateGrupa(id,grupa);
                            System.out.println("\nAti modificat grupa in - " + conection.toStringGrupa(id));
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }else {
                            System.out.println("Grupa '"+ grupa +
                                    anForm + limba + "' deja exista la facultatea - " +
                                    conection.toStringFacultate(facultate_id) + ":");
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }
                        break;
                    case "2":
                        cls();
                        System.out.println("Modificare Grupa:");
                        System.out.println("Id[" + id + "] - "+ grupa +
                                anForm + limba + " - " + conection.toStringFacultate(facultate_id) + ":");
                        System.out.println("Introdu alt an de formare a grupei:");
                        while (true){
                            try{
                                anForm = obj.nextInt();
                                break;
                            }catch (InputMismatchException e){

                            }
                        }
                        if(!conection.existGrupa(facultate_id,grupa,anForm,limba)){
                            conection.updateGrupaAn(id,anForm);
                            System.out.println("\nAti modificat grupa in - " + conection.toStringGrupa(id));
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }else {
                            System.out.println("Grupa '"+ grupa +
                                    anForm + limba + "' deja exista la facultatea - " +
                                    conection.toStringFacultate(facultate_id) + ":");
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }
                        break;
                    case "3":
                        cls();
                        System.out.println("Modificare Grupa:");
                        System.out.println("Id[" + id + "] - "+ grupa +
                                anForm + limba + " - " + conection.toStringFacultate(facultate_id) + ":");
                        System.out.println("Introdu limba grupei:");
                        limba = obj.next();
                        if(!conection.existGrupa(facultate_id,grupa,anForm,limba)){
                            conection.updateGrupaLimba(id,limba);
                            System.out.println("\nAti modificat grupa in - " + conection.toStringGrupa(id));
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }else {
                            System.out.println("Grupa '"+ grupa +
                                    anForm + limba + "' deja exista la facultatea - " +
                                    conection.toStringFacultate(facultate_id) + ":");
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }
                        break;
                    case "4":
                        cls();
                        facultate = conection.toStringFacultate(facultate_id);
                        facultate_id = selectFacultate();
                        System.out.println("Modificare Grupa:");
                        System.out.println("Id[" + id + "] - "+ grupa +
                                anForm + limba + " - " + facultate + ":");
                        if(!conection.existGrupa(facultate_id,grupa,anForm,limba)){
                            conection.updateGrupaFacult(id,facultate_id);
                            System.out.println("\nAti modificat grupa in - " + conection.toStringGrupa(id));
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }else {
                            System.out.println("Grupa '"+ grupa +
                                    anForm + limba + "' deja exista la facultatea - " +
                                    conection.toStringFacultate(facultate_id) + ":");
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                            nivelMP = 2;
                            k = false;
                        }
                        break;
                    case "5":
                        nivelMP = 2;
                        k = false;
                        break;
                }
            }
        } else {
            nivelMP = 2;
        }
    }

    public static void deleteGrupa(){
        int id = selectGrupa();
        if(id != 0){
            boolean k = true;
            String grupa = conection.toStringGrupa(id);
            while (k){
                cls();
                System.out.println("Eliminare facultate:");
                System.out.println("GRUPA - " + conection.toStringGrupa(id));
                System.out.println("\n!!! ATENTIE TOATA INFORMATIA LEGATA DE ACEASTA GRUPA VA FI PIERDUTA !!!");
                System.out.println("Doriti sa continuati eliminarea?");
                System.out.println("<Y>/<N>");
                switch (obj.next()){
                    case "Y":
                    case "y":
                        conection.deleteGrupa(id);
                        System.out.println("Grupa '" + grupa + "' a fost eliminata;");
                        k = false;
                        break;
                    case "N":
                    case "n":
                        k = false;
                        break;
                }
            }
        }
        nivelMP = 2;
        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
        obj.next();
    }

    public static int selectGrupa(){
        int id = 0;
        boolean k = true;
        while (k){
            cls();
            switch (nivelMP){
                case 22:
                    System.out.println("Modificare Grupa:");
                    break;
                case 23:
                    System.out.println("Eliminare Grupa:");
                    break;
                case 31:
                    System.out.println("Inregistrare Student:");
                    break;
                case 32:
                    System.out.println("Modificare Student:");
                    break;
                case 25:
                    System.out.println("Inregistrare Test:");
                    break;
                case 26:
                    System.out.println("Modificare Test:");
                    break;
                case 27:
                    System.out.println("Anulare Test:");
                    break;
            }
            System.out.println("Select Grupa:");
            conection.showGrup();
            System.out.println("\nAlege o grupa dupa id, sau introdu 0 pentru meniul precedent: ");
            id = obj.nextInt();
            if(conection.existGrupa(id)){
                k = false;
            }else if(id == 0){
                k = false;
            }
        }
        return id;
    }

    public static int selectGrupaStud(){
        int id = 0;
        boolean k = true;
        while (k){
            cls();
            switch (nivelMP){
                case 32:
                    System.out.println("Modificare Student:");
                    break;
            }
            System.out.println("Select Grupa:");
            conection.showGrupStud();
            System.out.println("\nAlege o grupa dupa id, sau introdu 0 pentru meniul precedent: ");
            id = obj.nextInt();
            if(conection.existGrupaStud(id)){
                k = false;
            }else if(id == 0){
                k = false;
            }
        }
        return id;
    }

////////////// Test Methods //////////////

//    public static void showTest(){
//        boolean k = true;
//
//        while (k){
//            cls();
//            System.out.println("Lista facultatilor:");
//            conection.showFacultate();
//
//            System.out.println("\nIntrodu 1 pentru meiul precedent: ");
//            if(obj.next().equals("1")){
//                k = false;
//                nivelMP = 1;
//            }
//        }
//    }
//
//    public static void insertTest(){
//        System.out.println("Inregistrare Facultate:");
//        String facultate;
//
//        System.out.println("Introdu denumirea facultatii:");
//        facultate = obj.next();
//        if(conection.existFacultate(facultate)){
//            System.out.println("Facultatea '" + facultate + "' deja exista!!!");
//        }else {
//            conection.insertFacultate(facultate);
//        }
//        nivelMP = 1;
//        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
//        obj.next();
//    }
//
//    public static void updateTest(){
//        int id = selectFacultate();
//        if(id != 0){
//
//            boolean k = true;
//            boolean pause = false;
//            String facultate;
//
//            while (k){
//                cls();
//                System.out.println("Modificare facultate:");
//                System.out.println("Facultatea - " + conection.toStringFacultate(id));
//                System.out.println("Introdu denumirea noua a facultatii, sau 0  pentru meniul precedent:");
//                facultate = obj.next();
//                if(facultate.equals("0")){
//                    k = false;
//                }else {
//                    if(conection.existFacultate(facultate)){
//                        System.out.println("\nFacultatea '" + facultate + "' deja exista!");
//                        k = false;
//                        pause = true;
//                    }else {
//                        conection.updateFacultate(id,facultate);
//                        System.out.println("\nFacultate a fost modificata in '" + facultate + "';");
//                        k = false;
//                        pause = true;
//                    }
//                }
//            }
//            nivelMP = 1;
//            if(pause){
//                System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
//                obj.next();
//            }
//        } else {
//            nivelMP = 1;
//        }
//    }
//
//    public static void deleteTest(){
//        int id = selectFacultate();
//        boolean k = true;
//        String facultate = conection.toStringFacultate(id);
//
//        while (k){
//            cls();
//            System.out.println("Eliminare facultate:");
//            System.out.println("Facultatea - " + facultate);
//            System.out.println("\n!!! ATENTIE TOATA INFORMATIA LEGATA DE ACEASTA FACULTATE VA FI PIERDUTA !!!");
//            System.out.println("Doriti sa continuati eliminarea?");
//            System.out.println("<Y>/<N>");
//            switch (obj.next()){
//                case "Y":
//                case "y":
//                    conection.deleteFacultate(id);
//                    System.out.println("Facultate '" + facultate + "' a fost eliminata;");
//                    k = false;
//                    break;
//                case "N":
//                case "n":
//                    k = false;
//                    break;
//            }
//        }
//        nivelMP = 1;
//        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
//        obj.next();
//    }
//
//    public static int selectTest(){
//        int id = 0;
//        boolean k = true;
//        while (k){
//            cls();
//            switch (nivelMP){
//                case 12:
//                    System.out.println("Modificare Facultate:");
//                    break;
//                case 13:
//                    System.out.println("Eliminare Facultate:");
//                    break;
//                case 21:
//                    System.out.println("Inregistrare Grupa:");
//                    break;
//            }
//            System.out.println("Select facultate:");
//            conection.showFacultate();
//            System.out.println("\nAlege o facultate dupa id, sau introdu 0 pentru meniul precedent: ");
//            id = obj.nextInt();
//            if(conection.existFacultate(id)){
//                k = false;
//            }else if(id == 0){
//                k = false;
//            }
//        }
//        return id;
//    }

////////////// Student Methods //////////////

    public static void showStud(){
        boolean k = true;
        while (k){
            cls();
            System.out.println("Lista Studentilor:");
            conection.showStud();
            System.out.println("\n1. Inapoi;");
            if(obj.next().equals("1")){
                nivelMP = 3;
                k = false;
            }
        }
    }

    public static void insertStud(){
        boolean rep = true;
        while (rep){
            System.out.println("Inregistrare Grupa:");
            int grupaId = selectGrupa();

            if(grupaId != 0) {
                String nume;
                String prenume;
                String gen = "";
                int varsta = 0;
                String localitate;
                boolean k = true;

                cls();
                System.out.println("Inregistrare Student:");
                System.out.println("Introdu numele studentului:");
                nume = obj.next();

                cls();
                System.out.println("Inregistrare Student:");
                System.out.println("Introdu prenumele studentului:");
                prenume = obj.next();

                k = true;
                while (k) {
                    cls();
                    System.out.println("Inregistrare Student:");
                    System.out.println("Alege genul:");
                    System.out.println("<M>/<F>;\n");
                    switch (obj.next()) {
                        case "M":
                        case "m":
                        case "1":
                            gen = "M";
                            k = false;
                            break;
                        case "F":
                        case "f":
                        case "2":
                            gen = "F";
                            k = false;
                            break;
                    }
                }

                k = true;
                while (k) {
                    try {
                        cls();
                        System.out.println("Inregistrare Student:");
                        System.out.println("Intrudu varsta studentului:");
                        varsta = obj.nextInt();
                        k = false;
                    } catch (InputMismatchException e) {
                        System.out.println("\nVarsta studentului Trebue sa fie un numar intreg!");
                        System.out.println("Mai incearca o data:");
                        System.out.println("\nIntrodu ceva de la tastatura pentru a ontinua:");
                        obj.next();
                    }
                }

                cls();
                System.out.println("Inregistrare Student:");
                System.out.println("Introdu localitate studentului:");
                localitate = obj.next();

                cls();
                conection.insertStud(grupaId, nume, prenume, gen, varsta, localitate);
                System.out.println("Ati inregistrat studentul  '" + nume + " " + prenume + " " +
                        gen + " " + varsta + "' din '" + localitate + "' in grupa " +
                        conection.toStringGrupa(grupaId) + ";");
                nivelMP = 3;
                System.out.println("\nIntrodu ceva de la tastatura pentru a continua;");
                obj.next();
                rep = false;
            }
        }
    }

    public static void updateStud(){
        int id = selectStud();
        if(id != 0){
            int grupaId = conection.getStudGrupaId(id);
            String nume = conection.getStudNume(id);
            String prenume = conection.getStudPrenume(id);
            String gen = conection.getStudGen(id);
            int varsta = conection.getStudVarsta(id);
            String localitate = conection.getStudLocal(id);
            String grupa;
            boolean k = true;

            while (k){
                cls();
                System.out.println("Modificare Student:");
                System.out.println("Id[" + id + "] - "+ nume + " " + prenume + " " +
                        gen + " " + varsta + " " + localitate + " - " +
                        conection.toStringGrupa(grupaId) + ":");
                System.out.println("\n1. Modifica numele studentului;");
                System.out.println("2. Modifica prenumele studentului;");
                System.out.println("3. Modifica geul studentului;");
                System.out.println("4. Modifica varsta studentului;");
                System.out.println("5. Modifica localitatea studentului;");
                System.out.println("6. Alege o alta grupa;");
                System.out.println("7. Inapoi;");

                switch (obj.next()) {
                    case "1":
                        cls();
                        System.out.println("Modificare Student:");
                        System.out.println("Id[" + id + "] - "+ nume + " " + prenume + " " +
                                gen + " " + varsta + " " + localitate + " - " +
                                conection.toStringGrupa(grupaId) + ":");
                        System.out.println("Introdu numele nou al studentului:");
                        nume = obj.next();
                        conection.updateStudNume(id,nume);
                        System.out.println("\nAti modificat Studentul in - " +
                                conection.toStringStud(id));
                        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                        obj.next();
                        nivelMP = 3;
                        k = false;
                        break;
                    case "2":
                        cls();
                        System.out.println("Modificare Student:");
                        System.out.println("Id[" + id + "] - "+ nume + " " + prenume + " " +
                                gen + " " + varsta + " " + localitate + " - " +
                                conection.toStringGrupa(grupaId) + ":");
                        System.out.println("Introdu prenumele nou al studentului:");
                        prenume = obj.next();
                        conection.updateStudPrenume(id,prenume);
                        System.out.println("\nAti modificat Studentul in - " +
                                conection.toStringStud(id));
                        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                        obj.next();
                        nivelMP = 3;
                        k = false;
                        break;
                    case "3":
                        k = true;
                        while (k){
                            cls();
                            System.out.println("Modificare Student:");
                            System.out.println("Id[" + id + "] - "+ nume + " " + prenume + " " +
                                    gen + " " + varsta + " " + localitate + " - " +
                                    conection.toStringGrupa(grupaId) + ":");
                            System.out.println("Alege genul studentului:");
                            System.out.println("<M>/<F>;\n");
                            switch (obj.next()){
                                case "M":
                                case "m":
                                case "1":
                                    gen = "M";
                                    k = false;
                                    break;
                                case "F":
                                case "f":
                                case "2":
                                    gen = "F";
                                    k = false;
                                    break;
                            }
                        }
                        k = true;
                        conection.updateStudGen(id,gen);
                        System.out.println("\nAti modificat Studentul in - " +
                                conection.toStringStud(id));
                        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                        obj.next();
                        nivelMP = 3;
                        k = false;
                        break;
                    case "4":
                        k = true;
                        while (k){
                            try{
                                cls();
                                System.out.println("Modificare Student:");
                                System.out.println("Id[" + id + "] - "+ nume + " " + prenume + " " +
                                        gen + " " + varsta + " " + localitate + " - " +
                                        conection.toStringGrupa(grupaId) + ":");
                                System.out.println("Intrudu varsta studentului:");
                                varsta = obj.nextInt();
                                k = false;
                            }catch (InputMismatchException e){
                                System.out.println("\nVarsta studentului Trebue sa fie un numar intreg!");
                                System.out.println("Mai incearca o data:");
                                System.out.println("\nIntrodu ceva de la tastatura pentru a ontinua:");
                                obj.next();
                            }
                        }
                        conection.updateStudVarsta(id,varsta);
                        System.out.println("\nAti modificat Studentul in - " +
                                conection.toStringStud(id));
                        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                        obj.next();
                        nivelMP = 3;
                        k = false;
                        break;
                    case "5":
                        cls();
                        System.out.println("Modificare Student:");
                        System.out.println("Id[" + id + "] - "+ nume + " " + prenume + " " +
                                gen + " " + varsta + " " + localitate + " - " +
                                conection.toStringGrupa(grupaId) + ":");
                        System.out.println("Introdu localitate noua al studentului:");
                        localitate = obj.next();
                        conection.updateStudLocal(id,localitate);
                        System.out.println("\nAti modificat Studentul in - " +
                                conection.toStringStud(id));
                        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                        obj.next();
                        nivelMP = 3;
                        k = false;
                        break;
                    case "6":
                        grupa = conection.toStringGrupa(grupaId);
                        grupaId = selectGrupa();
                        cls();
                        System.out.println("Modificare Student:");
                        System.out.println("Id[" + id + "] - "+ nume + " " + prenume + " " +
                                gen + " " + varsta + " " + localitate + " - " +
                                grupa + ":");
                        if(grupaId != 0){
                            conection.updateStudGrupa(id,grupaId);
                            System.out.println("\nAti modificat Studentul in - '" +
                                    nume + " " + prenume + " " + gen + " " +
                                    varsta + " " + localitate +"' - " + grupa);
                            System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
                            obj.next();
                        }
                        nivelMP = 3;
                        k = false;
                        break;
                    case "7":
                        nivelMP = 3;
                        k = false;
                        break;
                }
            }
        } else {
            nivelMP = 3;
        }
    }

    public static void deleteStud(){
        int id = selectStud();
        if(id != 0){
            boolean k = true;
            String student = conection.toStringStud(id);
            while (k){
                cls();
                System.out.println("Eliminare Student:");
                System.out.println("Student - " + conection.toStringStud(id));
                System.out.println("\n!!! ATENTIE TOATA INFORMATIA LEGATA CU ACEST STUDENT VA FI PIERDUTA !!!");
                System.out.println("Doriti sa continuati eliminarea?");
                System.out.println("<Y>/<N>");
                switch (obj.next()){
                    case "Y":
                    case "y":
                        conection.deleteStud(id);
                        System.out.println("STUDENT '" + student + "' a fost eliminata;");
                        k = false;
                        break;
                    case "N":
                    case "n":
                        k = false;
                        break;
                }
            }
        }
        nivelMP = 3;
        System.out.println("\nIntrodu ceva de la tastatura pentru a continua:");
        obj.next();
    }

    public static int selectStud(){
        int id1 = selectGrupaStud();
        int id = 0;
        if(id1 != 0){
            boolean k = true;
            while (k){
                cls();
                switch (nivelMP){
                    case 32:
                        System.out.println("Modificare Student:");
                        break;
                    case 33:
                        System.out.println("Eliminare Student:");
                        break;
                }
                System.out.println("Select Student:");
                conection.showStudGrup(id1);
                System.out.println("\nAlege un student dupa id, sau introdu 0 pentru meniul precedent: ");
                id = obj.nextInt();
                if(conection.existStud(id,id1)){
                    k = false;
                }else if(id == 0){
                    k = false;
                }
            }
        }
        return id;
    }



////////////// Note Methods //////////////



////////////// Clear Screen //////////////
    public static void cls(){
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch (Exception e){
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }
    }
}
