package countfolder;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 *
 * @author Sergey
 */
public class Main {

    private static int countFolder;
    private static int countFile;
    private static ArrayList list = new ArrayList();

    public static void main(String[] args) {
        String home = System.getProperty("user.home");
//        String separator = System.getProperty("file.separator");
//        String download = home + separator + "Downloads";
//        File file = new File(download);
        File file = new File(home);
        fileFilter();
        folder(file);
        printResult();
    }

    private static void printResult() {
        System.out.println("_________________________________");
        System.out.println("");
        System.out.println("Folder find: " + countFolder + ", File find: " + countFile);
        System.out.println("Find file with filter(*.txt, *.log): " + list.size());
    }

    private static void folder(File file) {
        if (file.listFiles() != null) {
            File[] listString = file.listFiles();
            File file1 = null;

            for (int i = 0; i < listString.length; i++) {
                file1 = listString[i];
                findFileWithFilter(file1);
                System.out.println(file1);
                if (file1.isDirectory()) {
                    folder(file1);
                    countFolder++;
                }
                if (file1.isFile()) {
                    countFile++;
                }
            }
        }
    }

    private static void findFileWithFilter(File file1) {
        if (file1.listFiles(fileFilter()) != null) {
            File[] paths = file1.listFiles(fileFilter());
            for (File path : paths) {
                String realPath = path.getPath();
                list.add(realPath);
            }
        }
    }

    private static FilenameFilter fileFilter() {
        FilenameFilter fileNameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.lastIndexOf('.') > 0) {
                    int lastIndex = name.lastIndexOf('.');
                    String str = name.substring(lastIndex);
                    if (str.equals(".txt") || str.equals(".log")) {
                        return true;
                    }
                }
                return false;
            }
        };
        return fileNameFilter;

    }
    
}
