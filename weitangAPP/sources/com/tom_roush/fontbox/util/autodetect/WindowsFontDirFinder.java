package com.tom_roush.fontbox.util.autodetect;

import com.tom_roush.fontbox.util.Charsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WindowsFontDirFinder implements FontDirFinder {
    private String getWinDir(String str) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((str.startsWith("Windows 9") ? runtime.exec("command.com /c echo %windir%") : runtime.exec("cmd.exe /c echo %windir%")).getInputStream(), Charsets.ISO_8859_1));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        return line;
    }

    @Override // com.tom_roush.fontbox.util.autodetect.FontDirFinder
    public List<File> find() {
        String winDir;
        ArrayList arrayList = new ArrayList();
        try {
            winDir = System.getProperty("env.windir");
        } catch (SecurityException unused) {
            winDir = null;
        }
        String property = System.getProperty("os.name");
        if (winDir == null) {
            try {
                winDir = getWinDir(property);
            } catch (IOException | SecurityException unused2) {
            }
        }
        if (winDir == null || winDir.length() <= 2) {
            String str = property.endsWith("NT") ? "WINNT" : "WINDOWS";
            for (char c2 = 'C'; c2 <= 'E'; c2 = (char) (c2 + 1)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c2);
                sb.append(":");
                String str2 = File.separator;
                sb.append(str2);
                sb.append(str);
                sb.append(str2);
                sb.append("FONTS");
                File file = new File(sb.toString());
                try {
                    if (file.exists() && file.canRead()) {
                        arrayList.add(file);
                        break;
                    }
                } catch (SecurityException unused3) {
                }
            }
            for (char c3 = 'C'; c3 <= 'E'; c3 = (char) (c3 + 1)) {
                File file2 = new File(c3 + ":" + File.separator + "PSFONTS");
                try {
                    if (file2.exists() && file2.canRead()) {
                        arrayList.add(file2);
                        break;
                    }
                } catch (SecurityException unused4) {
                }
            }
        } else {
            if (winDir.endsWith("/")) {
                winDir = winDir.substring(0, winDir.length() - 1);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(winDir);
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append("FONTS");
            File file3 = new File(sb2.toString());
            if (file3.exists() && file3.canRead()) {
                arrayList.add(file3);
            }
            File file4 = new File(winDir.substring(0, 2) + str3 + "PSFONTS");
            if (file4.exists() && file4.canRead()) {
                arrayList.add(file4);
            }
        }
        return arrayList;
    }
}
