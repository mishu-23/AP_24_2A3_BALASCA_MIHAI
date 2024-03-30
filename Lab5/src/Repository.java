import java.io.File;
public class Repository {
    private String masterDirectory;

    public Repository(String masterDirectory) {
        this.masterDirectory = masterDirectory;
    }

    public void getContent() {
        try {
                File directory = new File(masterDirectory);
                if(!directory.exists() || !directory.isDirectory()) {
                    throw new IllegalArgumentException("Master directory inexistent sau nu e director");
                }

                File[] personDirectories = directory.listFiles();
                if(personDirectories == null || personDirectories.length == 0) {
                    throw new IllegalStateException("Nu e niciun angajat in master");
                }

                for(File personDirectory : personDirectories) {
                    if(personDirectory.isDirectory()) {
                        System.out.println("Angajatul: " + personDirectory.getName());
                        File[] files = personDirectory.listFiles();
                        if(files != null) {
                            for(File file : files) {
                                System.out.println("fisier: " + file.getName());
                            }
                        }
                    }
                }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Repository repo = new Repository("C:\\storage\\java\\Lab5\\RepoMaster");
        repo.getContent();
    }
}
