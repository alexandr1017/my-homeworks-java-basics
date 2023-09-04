import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zipper {


    public static void zipDirectory(String dirPath, String zipFilePath) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(Paths.get(zipFilePath)))) {
            Path dir = Paths.get(dirPath);
            addDirToZip(dir, dir.getFileName().toString(), zos);
        }
    }

    private static void addDirToZip(Path dir, String pathInZip, ZipOutputStream zos) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                if (Files.isDirectory(file)) {
                    addDirToZip(file, pathInZip + "/" + file.getFileName(), zos);
                } else {
                    addToZip(file, pathInZip + "/" + file.getFileName(), zos);
                }
            }
        }
    }

    private static void addToZip(Path file, String pathInZip, ZipOutputStream zos) {
        try {
            ZipEntry zipEntry = new ZipEntry(pathInZip);
            zos.putNextEntry(zipEntry);
            byte[] bytes = Files.readAllBytes(file);
            zos.write(bytes);
            zos.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unzip(String zipFilePath, String destDir) throws IOException {
        Path dir = Paths.get(destDir);
        if (!Files.exists(dir)) Files.createDirectories(dir);
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(zipFilePath)))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                Path newFile = newFile(dir, zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!Files.isDirectory(newFile)) Files.createDirectories(newFile);
                } else {
                    // fix for Windows-created archives
                    Path parent = newFile.getParent();
                    if (!Files.isDirectory(parent)) Files.createDirectories(parent);

                    // write file content
                    try (OutputStream fos = Files.newOutputStream(newFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }

    private static Path newFile(Path destinationDir, ZipEntry zipEntry) throws IOException {

        Path destFile = destinationDir.resolve(zipEntry.getName());

        String destDirPath = destinationDir.toAbsolutePath().normalize().toString();
        String destFilePath = destFile.toAbsolutePath().normalize().toString();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}
