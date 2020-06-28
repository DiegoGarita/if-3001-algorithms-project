package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.*;

public class Respaldo {

    LogicaSuperAdmin logiSuper = new LogicaSuperAdmin();
    SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));

    public void createZipFile(String porRespaldar, String nombreZip) throws IOException {

        String TARGET_FILE = configuracion.getPathDeGuardado() + "\\" + nombreZip + ".zip";
        FileOutputStream fos = new FileOutputStream(TARGET_FILE);
        CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(cos);

        FileInputStream fis = new FileInputStream(porRespaldar);
        ZipEntry zipEntry = new ZipEntry(porRespaldar);
        zos.putNextEntry(zipEntry);
        int length;
        byte[] buffer = new byte[1024];
        while ((length = fis.read(buffer)) > 0) {
            zos.write(buffer, 0, length);
        }

        zos.closeEntry();
        fis.close();
        zos.close();
    }

}
