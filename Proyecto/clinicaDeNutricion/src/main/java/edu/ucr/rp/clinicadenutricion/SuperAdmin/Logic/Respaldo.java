package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.*;


public class Respaldo {
ArchSupAdmin logiSuper = new ArchSupAdmin();
SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
    public void createZipFile(String porRespaldar, String nombreZip) throws IOException {
        String TARGET_FILE = configuracion.getPathDeGuardado()+"\\"+nombreZip+".zip";
        FileOutputStream fout = new FileOutputStream(TARGET_FILE);
        CheckedOutputStream checksum = new CheckedOutputStream(fout, new Adler32());
        ZipOutputStream zout = new ZipOutputStream(checksum);

        FileInputStream fin = new FileInputStream(porRespaldar);
        ZipEntry zipEntry = new ZipEntry(porRespaldar);
        zout.putNextEntry(zipEntry);
        int length;
        byte[] buffer = new byte[1024];
        while ((length = fin.read(buffer)) > 0) {
            zout.write(buffer, 0, length);
        }

        zout.closeEntry();
        fin.close();
        zout.close();
    }//end createZipFile

}//end respaldo
