import java.io.File;

public class Main {

    public static void main(String[] args) {

        //Путь к папке Games
        String pathToGamesFolder = "src/Games";

        //В папке Games создайте несколько директорий: src, res, savegames, temp
        File dirSrc = new File(pathToGamesFolder + "/src");
        File dirRes = new File(pathToGamesFolder + "/res");
        File dirSavegames = new File(pathToGamesFolder + "/savegames");
        File dirTemp = new File(pathToGamesFolder + "/temp");
        if (dirSrc.mkdir()
                && dirRes.mkdir()
                && dirSavegames.mkdir()
                && dirTemp.mkdir()) {
            System.out.println("Create src, res, savegames, temp - DONE");
        }

        //В каталоге src создайте две директории: main, test.
        File dirMain = new File(dirSrc.getPath() + "/main");
        File dirTest = new File(dirSrc.getPath() + "/test");
        if (dirMain.mkdir()
                && dirTest.mkdir()) {
            System.out.println("Create main, test - DONE");
        }

        // В подкаталоге main создайте два файла: Main.java, Utils.java.
        File fileMain = new File(dirMain.getPath() + "/Main.java");
        File fileUtils = new File(dirMain.getPath() + "/Utils.java");
        try {
            if (fileMain.createNewFile()
                    && fileUtils.createNewFile()) {
                System.out.println("Create Main.java, Utils.java - DONE");
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        // В каталог res создайте три директории: drawables, vectors, icons.
        File dirDrawables = new File(dirRes.getPath() + "/drawables");
        File dirVectors = new File(dirRes.getPath() + "/vectors");
        File dirIcons = new File(dirRes.getPath() + "/icons");
        if (dirDrawables.mkdir()
                && dirVectors.mkdir()
                && dirIcons.mkdir()) {
            System.out.println("Create drawables, vectors, icons - DONE");
        }

        // В директории temp создайте файл temp.txt.
        File fileTemp = new File(dirTemp.getPath() + "/temp.txt");
        try {
            if(fileTemp.createNewFile()){
                System.out.println("Create temp.txt - DONE");
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}