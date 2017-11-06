package loggUtility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LoggerUtility {

    public static String pathTestCases = "./src/loggCase_gen/";
    public static String filenameResultSoll = "_resultSoll.txt";
    public static String filenameResultIst = "_resultIst.txt";

    private static boolean show = false; //Default...false
    private static boolean write = true; //Default...true

    public static boolean isShow() {
        return show;
    }

    public static void setShow(boolean show) {
        LoggerUtility.show = show;
    }

    public static boolean isWrite() {
        return write;
    }

    public static void setWrite(boolean write) {
        LoggerUtility.write = write;
    }

    
    //Config Testdata-File-Repository
    protected static BufferedWriter bwResult = null;

    private static void openLogFile(String filename, boolean append)
            throws Exception {
        bwResult = new BufferedWriter(
                new FileWriter(new File(pathTestCases
                        + filename),
                        append));
        System.out.println("openLogFile:" + pathTestCases
                + filename);
    }

    private static void showLog(String logText)
            throws Exception {
        System.out.println(logText);
    }

    private static void writeLog(String logText)
            throws Exception {
        if (write) {
            bwResult.write(logText);
            bwResult.newLine();
            bwResult.flush();
        }
        if (show) {
            showLog(logText);
        }
    }

    private static void closeLogFile()
            throws Exception {
        if (bwResult != null) {
            bwResult.close();
            bwResult = null; //WICHTIG!!
        }
    }

    public static void writeResultSoll(String logText, String caseId, 
            String caseNote)
            throws Exception 
    {
        if (write)
            openLogFile(caseId + filenameResultSoll, false);
        
        //Config-Daten als Header speichern:
        writeLog("header=resultSoll" +
                "; testCase=" + caseId +
                "; caseNote=" + caseNote);

        writeLog(logText);
        if (write)
            closeLogFile();
        
    }

    public static void appendResultSoll(String logText, String caseId)
            throws Exception {
         if (write)
            openLogFile(caseId + filenameResultSoll, true);
        writeLog(logText);
         if (write)
            closeLogFile();
    }

    public static void writeResultIst(String logText, String caseId,
            String caseNote)
            throws Exception {
         if (write)
            openLogFile(caseId + filenameResultIst, false);
        //Config-Daten als Header speichern:
        writeLog("header=resultIst"
                + "; testCase=" + caseId +
                "; caseNote=" + caseNote);

        writeLog(logText);
         if (write)
            closeLogFile();
    }

    public static void appendResultIst(String logText, String caseId)
            throws Exception {
         if (write)
            openLogFile(caseId + filenameResultIst, true);
        writeLog(logText);
         if (write)
            closeLogFile();
    }
    
}
