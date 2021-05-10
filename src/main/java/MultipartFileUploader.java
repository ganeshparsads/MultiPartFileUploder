import java.io.File;
import java.io.IOException;
import java.util.List;

public class MultipartFileUploader {
    public static void main(String[] args) {
        String charset = "UTF-8";
        File uploadFile1 = new File("<filePath>");
        String requestURL = "<endpoint>";

        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

            multipart.addHeaderField("authorization", "<secret>");

            multipart.addFilePart("fileUpload", uploadFile1);

            List<String> response = multipart.finish();

            System.out.println("SERVER REPLIED:");

            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
