import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!!!!");

        FileTreeRead ftr = new FileTreeRead();

		File f = new File("App.java");
		ftr.GetTreeList(1, f);

    }
}
