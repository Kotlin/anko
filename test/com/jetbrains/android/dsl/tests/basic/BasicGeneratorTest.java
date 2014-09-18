package com.jetbrains.android.dsl.tests.basic;

import com.jetbrains.android.dsl.DSLGenerator;
import com.jetbrains.android.dsl.tests.DirectoryFilter;
import com.jetbrains.android.dsl.tests.JarFilter;
import com.jetbrains.android.dsl.tests.TestGeneratorProps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicGeneratorTest extends Assert {

    private final String kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
    private final String tmpJarFile = this.getClass() + "out.jar";

    private static final FileFilter directoryFilter = new DirectoryFilter();
    private static final FileFilter jarFilter = new JarFilter();

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File("props/imports_layouts.txt").exists());
        assertTrue(new File("props/imports_views.txt").exists());
        assertTrue(new File("props/custom_method_parameters.txt").exists());
        assertTrue(new File("props/excluded_classes.txt").exists());
        assertTrue(new File("props/excluded_methods.txt").exists());
        assertTrue(new File("props/helper_constructors.txt").exists());
        assertTrue(new File("props/helper.txt").exists());
        assertTrue(new File(kotlincFilename).exists());
    }

    protected ProcResult compile(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(args);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        String str;
        while (((str = br1.readLine()) != null) && (br2.readLine() != null)) {
            if (str.startsWith("ERROR"))
                errors.append(str);
        }
        p.waitFor();
        return new ProcResult(errors.toString(), p.exitValue());
    }

    @Test
    public void testResultCompiles() throws Exception {
        File[] versions = new File("original/").listFiles(directoryFilter);
        for (File ver: versions) {
          String fVersion = ver.getName();
          int version = Integer.parseInt(fVersion.replaceAll("[^0-9]", ""));

          List<File> jarFiles = Arrays.asList(ver.listFiles(jarFilter));
          List<String> jarFilesString = new ArrayList<>();
          StringBuilder classpath = new StringBuilder();
          for (File f: jarFiles) {
              jarFilesString.add(f.getAbsolutePath());
              if (classpath.length()>0) {
                  classpath.append(File.pathSeparatorChar);
              }
              classpath.append(f.getPath());
          }

          TestGeneratorProps settings = new TestGeneratorProps();
          DSLGenerator gen = new DSLGenerator(version, fVersion, jarFilesString, settings);
          gen.run();
          String kotlincArgs[] = {kotlincFilename,
              "-jar", tmpJarFile,
              "-classpath", classpath.toString(),
          };
          ArrayList<String> args = new ArrayList<>(Arrays.asList(kotlincArgs));
          for (File file: settings.tmpFiles.values()) {
              args.add(file.getAbsolutePath());
          }
          ProcResult res = compile(args.toArray(new String[args.size()]));
          assertEquals(res.stderr, "");
          for (File file: settings.tmpFiles.values()) {
              file.delete();
          }
        }
    }

    @Test
    public void testResultExists() throws Exception {
      File[] versions = new File("original/").listFiles(directoryFilter);
      for (File ver: versions) {
          String fVersion = ver.getName();
          int version = Integer.parseInt(fVersion.replaceAll("[^0-9]", ""));

          List<File> jarFiles = Arrays.asList(ver.listFiles(jarFilter));
          List<String> jarFilesString = new ArrayList<>();
          StringBuilder classpath = new StringBuilder();
          for (File f: jarFiles) {
              jarFilesString.add(f.getAbsolutePath());
              if (classpath.length()>0) {
                  classpath.append(File.pathSeparatorChar);
              }
              classpath.append(f.getPath());
          }

          TestGeneratorProps settings = new TestGeneratorProps();
          DSLGenerator gen = new DSLGenerator(version, fVersion, jarFilesString, settings);
          gen.run();
          for (File file: settings.tmpFiles.values()) {
              assertTrue(file.length() > 0);
          }
          for (File file: settings.tmpFiles.values()) {
              file.delete();
          }
      }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        new File(tmpJarFile).delete();
    }

    class ProcResult {
        public String stderr;
        public int exitCode;

        ProcResult(String stderr, int exitCode) {
            this.stderr = stderr;
            this.exitCode = exitCode;
        }
    }
}
