import java.sql.*;

public class DBConection {
    Connection dbConnection;

    public Connection getDbConnection()throws ClassNotFoundException,
            SQLException {
        String dbHost = "localhost";
        String dbPort = "3306";
        String dbName = "universitate";
        String dbUser = "root";
        String dbPass = "1151";

        String connectionStr = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionStr,
                dbUser, dbPass);
        return dbConnection;
    }


    /////////// Teste ///////////////

    public void insertTest(int grupaId,String test){
        String query = "INSERT INTO TEST(grupa_id,test)" +
                "VALUES (?,?);";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.setString(2,test);
            prSt.execute();

            System.out.println("Test: Inregistrare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateTest(int grupaId,String test){
        String query = "UPDATE TEST SET test = ? WHERE grupa_id = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setString(1,test);
            prSt.setInt(2,grupaId);
            prSt.execute();

            System.out.println("Test: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteTest(int testId){
        String query = "DELETE FROM TEST WHERE test_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,testId);
            prSt.execute();

            System.out.println("Test: Eliminare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTestGrupa(int grupa_id){
        String query = "DELETE FROM TEST WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,grupa_id);
            prSt.execute();

            System.out.println("Teste: Eliminare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showTest(int grupaId){
        String query = "SELECT * FROM TEST WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            ResultSet rSet = prSt.getResultSet();
            while (rSet.next()){
                int id = rSet.getInt(1);
                String test = rSet.getString(2);
                System.out.println("Id[" + id + "]: " + test);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String toStringTest(int testId){
        String query = "SELECT test FROM TEST WHERE test_id = ?";
        String test;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,testId);
            ResultSet rSet = prSt.getResultSet();

            rSet.next();
            test = rSet.getString(1);
            return test;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEmptyTest(){
        String query = "SELECT COUNT(*) FROM TEST";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existTest(String test){
        String query = "SELECT COUNT(*) FROM TEST WHERE test = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setString(1,test);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existTest(int testId){
        String query = "SELECT COUNT(*) FROM TEST WHERE test_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,testId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /////////// Facultate ///////////////

    public void insertFacultate(String facultate){
        String query = "INSERT INTO FACULTATE(facultate)"+
                "VALUES(?)";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setString(1,facultate);
            prSt.execute();

            System.out.println("Ati inregistrat facultatea:");
            System.out.println(facultate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFacultate(int facultateId,String facultate){
        String query = "UPDATE FACULTATE SET facultate = ? WHERE facultate_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setString(1,facultate);
            prSt.setInt(2,facultateId);
            prSt.execute();

            System.out.println("Facultate: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFacultate(int facultateId){
        deleteGrupaFacult(facultateId);
        String query = "DELETE FROM FACULTATE WHERE facultate_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,facultateId);
            prSt.execute();

            System.out.println("Facultate: Eliminare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFacultate(){
        String query = "SELECT * FROM facultate";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();

            while (rSet.next()) {
                int id = rSet.getInt(1);
                String facultate = rSet.getString(2);
                System.out.println("Id[" + id + "]: " + facultate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String toStringFacultate(int facultateId){
        String query = "SELECT * FROM facultate WHERE facultate_id = ?";
        String facultate;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,facultateId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();

            rSet.next();
            facultate = rSet.getString(2);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return facultate;
    }

    public boolean isEmptyFacultate(){
        String query = "SELECT COUNT(*) FROM facultate";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existFacultate(String facultate){
        String query = "SELECT COUNT(*) FROM facultate WHERE facultate = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setString(1,facultate);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existFacultate(int facultateId){
        String query = "SELECT COUNT(*) FROM facultate WHERE facultate_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,facultateId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /////////// Grupe ///////////////

    public void insertGrupa(int facultateId,String grupa,int anFormare,String limba){
        String query = "INSERT INTO GRUPA(facultate_id,grupa,an_form,limba)" +
                "values (?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,facultateId);
            prSt.setString(2,grupa);
            prSt.setInt(3,anFormare);
            prSt.setString(4,limba);
            prSt.execute();

            System.out.println("Grupa: Inregistrare cu succes!!!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateGrupaFacult(int grupa_id,int facultateID){
        String query = "UPDATE GRUPA SET facultate_id = ? WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,facultateID);
            prSt.setInt(2,grupa_id);
            prSt.execute();

            System.out.println("Grupa: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGrupa(int grupa_id,String grupa){
        String query = "UPDATE GRUPA SET grupa = ? WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setString(1,grupa);
            prSt.setInt(2,grupa_id);
            prSt.execute();

            System.out.println("Grupa: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGrupaAn(int grupa_id,int anFormare){
        String query = "UPDATE GRUPA SET an_form = ? WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,anFormare);
            prSt.setInt(2,grupa_id);
            prSt.execute();

            System.out.println("Grupa: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGrupaLimba(int grupa_id,String limba){
        String query = "UPDATE GRUPA SET limba = ? WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setString(1,limba);
            prSt.setInt(2,grupa_id);
            prSt.execute();

            System.out.println("Grupa: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGrupa(int grupaId){
        String query = "DELETE FROM GRUPA WHERE grupa_id = ?";
        try {
            deleteStudGrupa(grupaId);
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();

            System.out.println("Grupa: Eliminare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGrupaFacult(int facultateId){
        String query;
        PreparedStatement prSt;
        ResultSet rSet;
        try {
            query = "SELECT * FROM GRUPA WHERE facultate_id = ?";
            prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,facultateId);
            prSt.execute();
            rSet = prSt.getResultSet();

            while (rSet.next()){
                deleteStudGrupa(rSet.getInt(1));
                deleteTestGrupa(rSet.getInt(1));

                query = "DELETE FROM GRUPA WHERE grupa_id = ?";
                prSt = dbConnection.prepareStatement(query);
                prSt.setInt(1,rSet.getInt(1));
                prSt.execute();
                System.out.println("Grupa: Eliminare cu succes!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showGrup(){
        String query = "SELECT G.grupa_id,G.grupa,G.an_form,G.limba,F.facultate FROM GRUPA G " +
                " INNER JOIN FACULTATE F ON F.facultate_id = G.facultate_id";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();

            while (rSet.next()) {
                int id = rSet.getInt(1);
                String grupa = rSet.getString(2);
                int anFormare = rSet.getInt(3);
                String limba = rSet.getString(4);
                String facultate = rSet.getString(5);
                System.out.println("Id[" + id + "]: " + grupa + anFormare +
                        limba + " - " + facultate);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showGrupStud(){
        String query = "SELECT  G.grupa_id,G.grupa,G.an_form,G.limba,F.facultate FROM GRUPA G \n" +
                "INNER JOIN FACULTATE F ON F.facultate_id = G.facultate_id\n" +
                "WHERE (SELECT COUNT(*)as nr FROM STUDENT S WHERE S.grupa_id = G.grupa_id) > 0;";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();

            while (rSet.next()) {
                int id = rSet.getInt(1);
                String grupa = rSet.getString(2);
                int anFormare = rSet.getInt(3);
                String limba = rSet.getString(4);
                String facultate = rSet.getString(5);
                System.out.println("Id[" + id + "]: " + grupa + anFormare +
                        limba + " - " + facultate);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toStringGrupa(int grupaId){
        String query = "SELECT G.grupa,G.an_form,G.limba,F.facultate FROM GRUPA G " +
                " INNER JOIN FACULTATE F ON F.facultate_id = G.facultate_id" +
                " WHERE G.grupa_id = ?";
        String grupa;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();

            rSet.next();
            grupa = rSet.getString(1) + rSet.getInt(2) +
                    rSet.getString(3) + " " + rSet.getString(4);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return grupa;
    }

    public int getGrupaId(int facultateId,String grupa,int anForm,String limba){
        String query = "SELECT grupa_id,COUNT(*) FROM GRUPA WHERE facultate_id = ? AND grupa = ? "+
                "AND an_form = ? AND limba = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,facultateId);
            prSt.setString(2,grupa);
            prSt.setInt(3,anForm);
            prSt.setString(4,limba);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return -1;
            }else {
                return rSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getGrupaFacultId(int grupaId){
        String query = "SELECT facultate_id, COUNT(*) FROM GRUPA WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();

            if(rSet.getInt(2) == 0){
                return -1;
            }else {
                return rSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getGrupa(int grupaId){
        String query = "SELECT grupa, COUNT(*) FROM GRUPA WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();

            if(rSet.getInt(2) == 0){
                return null;
            }else {
                return rSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getGrupaAn(int grupaId){
        String query = "SELECT an_form, COUNT(*) FROM GRUPA WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();

            if(rSet.getInt(2) == 0){
                return -1;
            }else {
                return rSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getGrupaLimba(int grupaId){
        String query = "SELECT limba, COUNT(*) FROM GRUPA WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();

            if(rSet.getInt(2) == 0){
                return null;
            }else {
                return rSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEmptyGrupa(){
        String query = "SELECT COUNT(*) FROM GRUPA";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existGrupa(int facultateId,String grupa,int anForm,String limba){
        String query = "SELECT COUNT(*) FROM GRUPA WHERE facultate_id = ? AND grupa = ? "+
                "AND an_form = ? AND limba = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,facultateId);
            prSt.setString(2,grupa);
            prSt.setInt(3,anForm);
            prSt.setString(4,limba);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existGrupa(int grupaId){
        String query = "SELECT COUNT(*) FROM GRUPA WHERE grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existGrupaStud(int grupaId){
        String query = "SELECT G.grupa_id,COUNT(*) FROM GRUPA G " +
                "INNER JOIN FACULTATE F ON F.facultate_id = G.facultate_id " +
                "WHERE G.grupa_id = ? AND (SELECT COUNT(*) FROM STUDENT S WHERE S.grupa_id = G.grupa_id) > 0";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /////////// Studenti ///////////////

    public void insertStud(int grupaId,String nume,String prenume,
                      String gen,int varsta,String localitate){
        String query = "INSERT INTO STUDENT(grupa_id,nume,prenume,gen,varsta,localitate)"+
                "values (?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.setString(2,nume);
            prSt.setString(3,prenume);
            prSt.setString(4,gen); ;
            prSt.setInt(5,varsta);
            prSt.setString(6,localitate);
            prSt.execute();

            System.out.println("Student: Inregistrare cu succes!!!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateStudGrupa(int studId,int grupaId){
        String query = "UPDATE STUDENT SET grupa_id = ? WHERE stud_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.setInt(2,studId);
            prSt.execute();

            System.out.println("Student: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudNume(int studId,String nume){
        String query = "UPDATE STUDENT SET nume = ? WHERE stud_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setString(1,nume);
            prSt.setInt(2,studId);
            prSt.execute();

            System.out.println("Student: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudPrenume(int studId,String prenume){
        String query = "UPDATE STUDENT SET prenume = ? WHERE stud_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setString(1,prenume);
            prSt.setInt(2,studId);
            prSt.execute();

            System.out.println("Student: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudGen(int studId,String gen){
        String query = "UPDATE STUDENT SET gen = ? WHERE stud_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setString(1,gen);
            prSt.setInt(2,studId);
            prSt.execute();

            System.out.println("Student: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudVarsta(int studId,int varsta){
        String query = "UPDATE STUDENT SET varsta = ? WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,varsta);
            prSt.setInt(2,studId);
            prSt.execute();

            System.out.println("Student: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudLocal(int studId,String localitate){
        String query = "UPDATE STUDENT SET localitate = ? WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setString(1,localitate);
            prSt.setInt(2,studId);
            prSt.execute();

            System.out.println("Student: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStud(int studId){
        String query = "DELETE FROM STUDENT WHERE stud_id = ?";
        try{
            PreparedStatement prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();

            System.out.println("Student: Eliminare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudGrupa(int grupaId){
        String query;
        PreparedStatement prSt;
        ResultSet rSet;
        int id;
        try {
            query = "SELECT stud_id FROM STUDENT WHERE grupa_id = ?";
            prSt = dbConnection.prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            rSet = prSt.getResultSet();

            while (rSet.next()){
                id = rSet.getInt(1);
                deleteNoteStud(id);

                query = "DELETE FROM STUDENT WHERE stud_id = ?";
                prSt = dbConnection.prepareStatement(query);
                prSt.setInt(1,id);
                prSt.execute();

                System.out.println("Student: Eliminare cu succes!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showStud(){
        String query = "SELECT \n" +
                "    S.stud_id,\n" +
                "    S.nume,S.prenume,S.gen,S.varsta,S.localitate,\n" +
                "    CONCAT(G.grupa,G.an_form,G.limba,' - ',F.facultate)AS gruppa \n" +
                "FROM STUDENT S \n" +
                "INNER JOIN GRUPA G ON G.grupa_id = S.grupa_id\n" +
                "INNER JOIN FACULTATE F ON F.facultate_id = G.facultate_id\n" +
                "ORDER BY F.facultate,G.grupa,S.nume,S.prenume;";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            while(rSet.next()){
                int id = rSet.getInt(1);
                String nume = rSet.getString(2);
                String prenume = rSet.getString(3);
                String gen = rSet.getString(4);
                int varsta = rSet.getInt(5);
                String localitate = rSet.getString(6);
                String grupa = rSet.getString(7);

                System.out.println("Id[" + id + "] - " + nume + " " + prenume + " " +
                        gen + " " + varsta + " " + localitate + " - " + grupa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void showStudGrup(int grupaId){
        String query = "SELECT \n" +
                "    S.stud_id,\n" +
                "    S.nume,S.prenume,S.gen,S.varsta,S.localitate,\n" +
                "    CONCAT(G.grupa,G.an_form,G.limba,' - ',F.facultate)AS gruppa \n" +
                "FROM STUDENT S \n" +
                "INNER JOIN GRUPA G ON G.grupa_id = S.grupa_id\n" +
                "INNER JOIN FACULTATE F ON F.facultate_id = G.facultate_id\n" +
                "WHERE G.grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            while(rSet.next()){
                int id = rSet.getInt(1);
                String nume = rSet.getString(2);
                String prenume = rSet.getString(3);
                String gen = rSet.getString(4);
                int varsta = rSet.getInt(5);
                String localitate = rSet.getString(6);
                String grupa = rSet.getString(7);

                System.out.println("Id[" + id + "] - " + nume + " " + prenume + " " +
                        gen + " " + varsta + " " + localitate + " - " + grupa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStudId(int grupaId,String nume,String prenume,String gen,
                  int varsta,String localitate){
        String query = "SELECT stud_id,COUNT(*) FROM STUDENT WHERE grupa_id = ? AND nume = ? "+
                "AND prenume = ? AND gen = ? AND varsta = ? AND localitate = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.setString(2,nume);
            prSt.setString(3,prenume);
            prSt.setString(4,gen);
            prSt.setInt(5,varsta);
            prSt.setString(6,localitate);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return -1;
            }else {
                return rSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStudGrupaId(int studId){
        String query = "SELECT grupa_id,COUNT(*) FROM STUDENT WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return -1;
            }else {
                return rSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStudNume(int studId){
        String query = "SELECT nume,COUNT(*) FROM STUDENT WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return null;
            }else {
                return rSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStudPrenume(int studId){
        String query = "SELECT prenume,COUNT(*) FROM STUDENT WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return null;
            }else {
                return rSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStudGen(int studId){
        String query = "SELECT gen,COUNT(*) FROM STUDENT WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return null;
            }else {
                return rSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStudVarsta(int studId){
        String query = "SELECT varsta,COUNT(*) FROM STUDENT WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return -1;
            }else {
                return rSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStudLocal(int studId){
        String query = "SELECT localitate,COUNT(*) FROM STUDENT WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(2) == 0){
                return null;
            }else {
                return rSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String toStringStud(int studId){
        String query = "SELECT \n" +
                "    S.nume,S.prenume,S.gen,S.varsta,S.localitate,\n" +
                "    CONCAT(G.grupa,G.an_form,G.limba,' - ',F.facultate)AS gruppa \n" +
                "FROM STUDENT S \n" +
                "INNER JOIN GRUPA G ON G.grupa_id = S.grupa_id\n" +
                "INNER JOIN FACULTATE F ON F.facultate_id = G.facultate_id\n" +
                "WHERE S.stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            ResultSet rSet = prSt.getResultSet();

            rSet.next();
            String student = rSet.getString(1) + " " + rSet.getString(2) +
                    rSet.getString(3) + " " + rSet.getInt(4) +
                    rSet.getString(5) + " " + rSet.getString(6);
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEmptyStud(){
        String query = "SELECT COUNT(*) FROM STUDENT";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existStud(int grupaId,String nume,String prenume,String gen,
                             int varsta,String localitate){
        String query = "SELECT COUNT(*) FROM STUDENT WHERE grupa_id = ? AND nume = ?" +
                " prenume = ? AND gen = ?" + " varsta = ? AND localitate = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,grupaId);
            prSt.setString(2,nume);
            prSt.setString(3,prenume);
            prSt.setString(4,gen);
            prSt.setInt(5,varsta);
            prSt.setString(6,localitate);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existStud(int studId,int grupaId){
        String query = "SELECT COUNT(*) FROM STUDENT WHERE stud_id = ? AND grupa_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.setInt(2,grupaId);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /////////// Note ///////////////

    public void insertNote(int studId,int testId,float nota){
        String query = "INSERT INTO NOTE(stud_id,nota)" +
                "values (?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.setInt(2,testId);
            prSt.setFloat(3,nota);
            prSt.execute();

            System.out.println("Note: Inregistrare cu succes!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateNote(int notaId,int studId,int testId,float nota) throws RuntimeException {
        String query = "UPDATE NOTE SET stud_id = ?, test_id = ?, nota = ?"+
                "WHERE nota_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.setInt(2,testId);
            prSt.setFloat(3,nota);
            prSt.setInt(4,notaId);
            prSt.execute();

            System.out.println("Note: Modificare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  void deleteNote(int notaId){
        String query = "DELETE FROM NOTE WHERE nota_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,notaId);
            prSt.execute();

            System.out.println("Note: Eliminare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  void deleteNoteStud(int studId){
        String query = "DELETE FROM NOTE WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            prSt.execute();

            System.out.println("Note: Eliminare cu succes!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void showNote(int studId){
        String query = "SELECT T.test,N.nota FROM NOTE N"+
                "INNER JOIN TEST T ON T.test_id = N.test_id"+
                "WHERE stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);

            ResultSet rSet = prSt.getResultSet();
            int i = 0;
            while(rSet.next()){
                i++;
                String test = rSet.getString(1);
                float nota = rSet.getFloat(2);

                System.out.println(i + ": " + test + " - " + nota);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String toStringNote(int studId){
        String query = "SELECT T.test,N.nota FROM NOTE N \n" +
                "INNER JOIN TEST T ON T.test_id = N.test_id\n" +
                "WHERE N.stud_id = ?";
        String note = "";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,studId);
            ResultSet rSet = prSt.getResultSet();

            while (rSet.next()){
                note = note + rSet.getString(1) + " - " + rSet.getFloat(2) + "\n";
            }
            return note;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEmptyNote(){
        String query = "SELECT COUNT(*) FROM NOTE";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existNota(int testId,int stud_id){
        String query = "SELECT COUNT(*) FROM NOTE WHERE test_id = ? AND stud_id = ?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1,testId);
            prSt.setInt(2,stud_id);
            prSt.execute();
            ResultSet rSet = prSt.getResultSet();
            rSet.next();
            if(rSet.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
