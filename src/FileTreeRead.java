import java.io.*;

public class FileTreeRead {
    public FileTreeRead() {}

	private void GetTreeList(int lvl, File f) {
		int i,j;
		String wkStr = "";

		for (j=0; j<lvl; j++) {
			wkStr = wkStr + "    ";
		}

//		try {
			if (f.exists() == true) {	// パスは正しく存在する
				if (f.isDirectory() == true) {	// 指定パスはディレクトリである
					File[]  flist = f.listFiles();

					// ファイル
					for (i = 0 ; i < flist.length ; i++) {
						if (flist[i].isFile() == true) {
							System.out.println(wkStr + flist[i].getName());
						}
					}

					// ディレクトリ
					for (i = 0 ; i < flist.length ; i++) {
						if (flist[i].isDirectory() == true) {
							System.out.println(wkStr + flist[i].getName() + "/");
							FileTreeRead ftr2 = new FileTreeRead();

							ftr2.GetTreeList(lvl+1, flist[i]);
						}
					}
				}
				else if (f.isFile() == true) {	// 指定パスはファイルである
					// 先頭で呼ばれてそのパスがファイルだった場合に
					// このパスへ入る。
					// 再帰的に呼ばれている場合はこのパスは入らない。
					System.out.println(wkStr + f.getName());
				}
			} else {
				System.err.println("Target is NOT Exist!!");
			}
//		} catch(FileNotFoundException e) {
//			System.err.println("File Open Error");
//		} catch(IOException e) {
//			System.err.println("File Close Error");
//		}
	}

}
